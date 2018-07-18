package com.jary.daily.grows.number;

/**
 * @author fanzhengjie
 * @create 2018/7/18 下午11:09
 * @description
 */
public class ResultResponse {

    private String headPicUrl;

    private Integer actionType;

    private Integer actionValue;

    private String secondPoint;

    public String getHeadPicUrl() {
        return headPicUrl;
    }

    public void setHeadPicUrl(String headPicUrl) {
        this.headPicUrl = headPicUrl;
    }

    public Integer getActionType() {
        return actionType;
    }

    public void setActionType(Integer actionType) {
        this.actionType = actionType;
    }

    public Integer getActionValue() {
        return actionValue;
    }

    public void setActionValue(Integer actionValue) {
        this.actionValue = actionValue;
    }

    public String getSecondPoint() {
        return secondPoint;
    }

    public void setSecondPoint(String secondPoint) {
        this.secondPoint = secondPoint;
    }

    @Override
    public String toString() {
        return "ResultResponse{" +
            "headPicUrl='" + headPicUrl + '\'' +
            ", actionType=" + actionType +
            ", actionValue=" + actionValue +
            ", secondPoint='" + secondPoint + '\'' +
            '}';
    }
}
