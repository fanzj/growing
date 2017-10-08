package com.jary.daily.grows.thread.pool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * @author fanzhengjie
 * @version 1.0
 * @create 2017/10/8 上午10:51
 * 线程池
 * 创建线程池，销毁线程池，添加新任务
 */
public final class ThreadPool {

    private static Logger logger = LoggerFactory.getLogger(ThreadPool.class);
    private static Logger taskLogger = LoggerFactory.getLogger("TaskLogger");

    private static boolean debug = taskLogger.isDebugEnabled();

    private static ThreadPool instance = ThreadPool.getInstance();

    public static final int SYSTEM_BUSY_TASK_COUNT = 150;

    /*默认池中线程数*/
    public static int worker_num = 5;

    /*已处理的任务数*/
    private static int taskCounter = 0;

    public static boolean systemIsBusy = false;

    private static List<Task> taskQueue = Collections.synchronizedList(new LinkedList<Task>());

    /*池中的所有线程*/
    public PoolWorker[] workers;

    private ThreadPool() {
        workers = new PoolWorker[5];
        for (int i = 0; i < workers.length; i++) {
            workers[i] = new PoolWorker(i);
        }
    }

    private ThreadPool(int pool_worker_num) {
        worker_num = pool_worker_num;
        workers = new PoolWorker[worker_num];
        for (int i = 0; i < workers.length; i++) {
            workers[i] = new PoolWorker(i);
        }
    }

    /**
     * 增加新的任务
     * 每增加一个新任务，都要唤醒任务队列
     * @param newTask
     */
    public void addTask(Task newTask) {
        synchronized (taskQueue) {
            newTask.setTaskId(++taskCounter);
            newTask.setSubmitTime(new Date());
            taskQueue.add(newTask);
            /* 唤醒队列, 开始执行 */
            taskQueue.notifyAll();
        }
        logger.info("Submit Task<" + newTask.getTaskId() + ">: "
                + newTask.info());
    }

    /**
     * 批量增加新任务
     * @param taskes
     */
    public void batchAddTask(Task[] taskes) {
        if (taskes == null || taskes.length == 0) {
            return;
        }
        synchronized (taskQueue) {
            for (int i = 0; i < taskes.length; i++) {
                if (taskes[i] == null) {
                    continue;
                }
                taskes[i].setTaskId(++taskCounter);
                taskes[i].setSubmitTime(new Date());
                taskQueue.add(taskes[i]);
            }
            /* 唤醒队列, 开始执行 */
            taskQueue.notifyAll();
        }
        for (int i = 0; i < taskes.length; i++) {
            if (taskes[i] == null) {
                continue;
            }
            logger.info("Submit Task<" + taskes[i].getTaskId() + ">: "
                    + taskes[i].info());
        }
    }

    /**
     * 线程池信息
     * @return
     */
    public String getInfo() {
        StringBuffer sb = new StringBuffer();
        sb.append("\nTask Queue Size:" + taskQueue.size());
        for (int i = 0; i < workers.length; i++) {
            sb.append("\nWorker " + i + " is "
                    + ((workers[i].isWaiting()) ? "Waiting." : "Running."));
        }
        return sb.toString();
    }
    /**
     * 销毁线程池
     */
    public synchronized void destroy() {
        for (int i = 0; i < worker_num; i++) {
            workers[i].stopWorker();
            workers[i] = null;
        }
        taskQueue.clear();
    }

    public static synchronized ThreadPool getInstance() {
        if (instance == null)
            instance = new ThreadPool();
        return instance;
    }

    private class PoolWorker extends Thread {

        private int index = -1;

        /*该工作线程是否有效*/
        private boolean isRunning = true;

        /* 该工作线程是否可以执行新任务 */
        private boolean isWaiting = true;

        public PoolWorker(int index){
            this.index = index;
            start();
        }

        public void stopWorker(){
            this.isRunning = false;
        }

        public boolean isWaiting(){
            return this.isWaiting;
        }


        /**
         * 循环执行任务
         * 这也许是线程池的关键所在
         */
        @Override
        public void run() {
            while (isRunning){
                Task r = null;
                synchronized (taskQueue){
                    while(taskQueue.isEmpty()){
                        try {
                            /* 任务队列为空，则等待有新任务加入从而被唤醒 */
                            taskQueue.wait(20);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    /*取出任务执行*/
                    r = taskQueue.remove(0);
                }

                if(r!=null){
                    isWaiting = false;
                    try{
                        if(debug){
                            r.setBeginTime(new Date());
                            taskLogger.debug("Worker<" + index
                                    + "> start execute Task<" + r.getTaskId() + ">");
                            if(r.getBeginTime().getTime() - r.getSubmitTime().getTime() > 1000){
                                taskLogger.debug("longer waiting time. "
                                        + r.info() + ",<" + index + ">,time:"
                                        + (r.getBeginTime().getTime() - r
                                        .getSubmitTime().getTime()));
                            }
                        }

                        /**该任务是否需要立即执行*/
                        if(r.needExecuteImmediate()){
                            new Thread(r).start();
                        }else{
                            r.run();
                        }

                        if(debug){
                            r.setFinishTime(new Date());
                            taskLogger.debug("Worker<" + index
                                    + "> finish task<" + r.getTaskId() + ">");
                            if (r.getFinishTime().getTime()
                                    - r.getBeginTime().getTime() > 1000)
                                taskLogger.debug("longer execution time. "
                                        + r.info() + ",<" + index + ">,time:"
                                        + (r.getFinishTime().getTime() - r
                                        .getBeginTime().getTime()));
                        }
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    isWaiting = true;
                    r = null;
                }
            }
        }
    }

}
