package com.jary.daily.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author fanzhengjie
 * @version 1.0
 * @create 2017/8/19 上午10:16
 */
@RestController
public class GrowsController {

    private static Logger LOGGRE = LoggerFactory.getLogger(GrowsController.class);

    @RequestMapping(value = "/okHttpGet",method = RequestMethod.GET)
    @ResponseBody
    public String okHttpGet(@RequestParam("userName") String userName, @RequestParam("age") int age){
        return String.format("GET请求 userName = %s, age = %d\n",userName,age);
    }

}
