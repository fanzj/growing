package com.jary.daily.controller;

import com.jary.daily.service.TestService;
import com.jary.daily.service.impl.TestServiceImpl;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author fanzhengjie
 * @create 2018/9/26 下午10:29
 * @description
 */
@RestController
public class TestController {

    //@Autowired
    private TestService testService;

    @Autowired
    public void setTestService(TestService testService) {
        this.testService = testService;
    }

    @RequestMapping(value = "/test2")
    public String test(){
        testService.doSth();
        return new Date().toString();
    }

}
