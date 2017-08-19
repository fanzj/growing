package com.jary.daily.grows.spring;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author fanzhengjie
 * @version 1.0
 * @create 2017/8/19 下午7:11
 */
public class PersonService implements InitializingBean,DisposableBean{

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    //方式一
    @PostConstruct
    public void init(){
        System.out.println("I'm  init  method  using  @PostConstrut...."+message);
    }

    @PreDestroy
    public void destroy2(){
        System.out.println("I'm  destory method  using  @PreDestroy....."+message);
    }

    //方式二
    public void initUp(){
        System.out.println("initUp");
    }

    public void  cleanUp(){
        System.out.println("cleanUp");
    }

    //方式三
    @Override
    public void destroy() throws Exception {
        // TODO Auto-generated method stub
        System.out.println("I'm  init  method  using implements InitializingBean interface...."+message);

    }

    @Override
    public void afterPropertiesSet() throws Exception {
        // TODO Auto-generated method stub
        System.out.println("I'm  init  method  using implements DisposableBean interface...."+message);

    }
}
