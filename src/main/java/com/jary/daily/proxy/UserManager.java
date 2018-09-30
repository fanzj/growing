package com.jary.daily.proxy;

/**
 * @author fanzhengjie
 * @create 2018/9/30 下午1:41
 * @description 代理
 */
public interface UserManager {

    void addUser(String id, String password);

    void delUser(String id);
}
