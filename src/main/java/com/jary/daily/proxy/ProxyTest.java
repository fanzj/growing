package com.jary.daily.proxy;

/**
 * @author fanzhengjie
 * @create 2018/9/30 下午1:55
 * @description 测试类
 */
public class ProxyTest {

    public static void main(String[] args) {
        //保存字节码
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true");
        JDKProxy jdkProxy = new JDKProxy();
        UserManager userManagerJDK = (UserManager) jdkProxy.newProxy(new UserManagerImpl());
        userManagerJDK.addUser("tom", "root");

        CGLibProxy cgLibProxy = new CGLibProxy();
        UserManager userManagerCglib = (UserManager) cgLibProxy.createProxyObject(new UserManagerImpl());
        userManagerCglib.addUser("jack", "123");
        userManagerCglib.delUser("rose");
    }

}
