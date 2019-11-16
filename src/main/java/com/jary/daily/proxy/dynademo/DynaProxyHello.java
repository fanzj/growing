package com.jary.daily.proxy.dynademo;

import com.jary.daily.proxy.staticdemo.IHello;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author fanzhengjie
 * @create 2019/11/1 下午5:45
 * @description
 */
public class DynaProxyHello implements InvocationHandler{

    /**
     * 目标对象
     */
    private Object target;

    public DynaProxyHello(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return null;
    }
}
