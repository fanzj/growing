package com.jary.daily.grows.guava;

import java.util.Map;

/**
 * @author fanzhengjie
 * @version 1.0
 * @create 2017/11/2 下午6:22
 */
public class MaintainLabel {

    private Map<String,String> platform;
    private Map<String,String> type;
    private Map<String,String> business;
    private Map<String,String> channel;
    private Map<String,Map<String,String>> bank;

    public Map<String, String> getPlatform() {
        return platform;
    }

    public void setPlatform(Map<String, String> platform) {
        this.platform = platform;
    }

    public Map<String, String> getType() {
        return type;
    }

    public void setType(Map<String, String> type) {
        this.type = type;
    }

    public Map<String, String> getBusiness() {
        return business;
    }

    public void setBusiness(Map<String, String> business) {
        this.business = business;
    }

    public Map<String, String> getChannel() {
        return channel;
    }

    public void setChannel(Map<String, String> channel) {
        this.channel = channel;
    }

    public Map<String, Map<String, String>> getBank() {
        return bank;
    }

    public void setBank(Map<String, Map<String, String>> bank) {
        this.bank = bank;
    }

}
