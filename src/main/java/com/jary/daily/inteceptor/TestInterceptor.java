package com.jary.daily.inteceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author fanzhengjie
 * @version 1.0
 * @create 2017/9/21 上午10:24
 * 测试拦截器
 */
public class TestInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        System.out.println("TestInterceptor.preHandle");
        boolean flag = false;
        //获取请求路径进行判断
        String servletPath = httpServletRequest.getServletPath();
        System.out.println("servletPath = "+servletPath);
        if(servletPath.equals("/author")){
            flag = false;
            System.out.println("/author方法被拦截");
        }else{
            flag = true;
            System.out.println("未被拦截");
        }
        return flag;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("TestInterceptor.postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println("TestInterceptor.afterCompletion");
    }
}
