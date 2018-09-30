package com.jary.daily.proxy;

/**
 * @author fanzhengjie
 * @create 2018/9/30 下午1:49
 * @description
 */
public class UserManagerImpl implements UserManager{

    @Override
    public void addUser(String id, String password) {
        System.out.println(".: 调用了UserManagerImpl.addUser()方法！ ");
    }

    @Override
    public void delUser(String id) {
        System.out.println(".: 调用了UserManagerImpl.delUser()方法！ ");
    }
}
