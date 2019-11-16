package com.jary.daily.grows.spring;

import com.jary.daily.config.PropertyConfigurer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author fanzhengjie
 * @version 1.0
 * @create 2017/8/19 下午7:17
 */
public class MainTest {

    public static void main(String[] args) {
        /*ApplicationContext context = new ClassPathXmlApplicationContext("bean/bean.xml");
        PersonService personService = (PersonService) context.getBean("personService");
        personService.destroy2();*/

       /* AbstractApplicationContext context =new  ClassPathXmlApplicationContext("bean/bean.xml");
        PersonService  person = (PersonService)context.getBean("personService");
        person.setMessage("hello  spring");
        PersonService  person_new = (PersonService)context.getBean("personService");
        System.out.println(person.getMessage());
        System.out.println(person_new.getMessage());
        context.registerShutdownHook();*/

        AbstractApplicationContext context =new  ClassPathXmlApplicationContext("applicationContext.xml");
        System.out.println(PropertyConfigurer.getProperty("sslCertsDir"));
        System.out.println(PropertyConfigurer.getAllProperty());
    }
}
