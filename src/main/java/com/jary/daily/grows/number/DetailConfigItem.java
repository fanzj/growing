package com.jary.daily.grows.number;

/**
 * @author fanzhengjie
 * @create 2018/7/18 下午11:09
 * @description
 */
public class DetailConfigItem {

    private String imageUrl;

    private Integer actionType;

    private Integer actionValue;

    private String secondPoint;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
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
        return "DetailConfigItem{" +
            "imageUrl='" + imageUrl + '\'' +
            ", actionType=" + actionType +
            ", actionValue=" + actionValue +
            ", secondPoint='" + secondPoint + '\'' +
            '}';
    }
}
