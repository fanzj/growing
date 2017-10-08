package com.jary.daily.grows.thread.pool;

import java.util.Date;

/**
 * @author fanzhengjie
 * @version 1.0
 * @create 2017/10/8 上午10:35
 * 所有任务接口
 * 其他任务必须继承访问类
 */
public abstract class Task implements Runnable {

    private Date generateTime = null;

    private Date submitTime = null;

    private Date beginTime = null;

    /*执行完成时间*/
    private Date finishTime = null;

    private long taskId;

    public Task() {
        this.generateTime = new Date();
    }

    @Override
    public void run() {
        /**
        * 相关执行代码
        *
        * beginTransaction();
        *
        * 执行过程中可能产生新的任务 subtask = taskCore();
        *
        * commitTransaction();
        *
        * 增加新产生的任务 ThreadPool.getInstance().batchAddTask(taskCore());
        */
    }

    /**
     * 所有任务的核心 所以特别的业务逻辑执行之处
     * @return
     * @throws Exception
     */
    public abstract Task[] taskCore() throws Exception;

    /**
     * 是否用到数据库
     * @return
     */
    protected abstract boolean useDb();

    /**
     * 是否需要立即执行
     * @return
     */
    protected abstract boolean needExecuteImmediate();

    /**
     * 任务信息
     * @return
     */
    public abstract String info();

    public Date getGenerateTime() {
        return generateTime;
    }

    public void setGenerateTime(Date generateTime) {
        this.generateTime = generateTime;
    }

    public Date getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(Date submitTime) {
        this.submitTime = submitTime;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

    public long getTaskId() {
        return taskId;
    }

    public void setTaskId(long taskId) {
        this.taskId = taskId;
    }
}
