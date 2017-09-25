package com.jary.daily.grows.algorithms.design.chain;

/**
 * @author fanzhengjie
 * @version 1.0
 * @create 2017/9/23 下午7:13
 */
public abstract class Handler {

    /**
     * 持有下一个处理请求对象
     */
    protected Handler successor = null;

    public Handler getSuccessor() {
        return successor;
    }

    /**
     * 设置下一个处理请求的对象
     * @param successor
     */
    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }

    /**
     * 处理聚餐费用的申请
     * @param user 申请人
     * @param fee  申请的钱数
     * @return 成功或失败的具体通知
     */
    public abstract String handleFeeRequest(String user, double fee);
}
