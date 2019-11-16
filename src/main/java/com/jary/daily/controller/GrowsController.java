package com.jary.daily.controller;

import com.alibaba.fastjson.JSONObject;
import com.jary.daily.grows.algorithms.design.observer.User;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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

    @RequestMapping(value = "/departments/{departmentId}")
    public String findDepatment(@PathVariable String departmentId){
        LOGGRE.info("日志输出测试");
        String result = "Find department with ID: "+departmentId;
        return result;
    }


    @RequestMapping(value="/departments/{departmentId}/employees/{employeeId}")
    public String findEmployee(
            @PathVariable String departmentId,
            @PathVariable String employeeId){

        System.out.println("Find employee with ID: " + employeeId +
                " from department: " + departmentId);
        return "someResult";

    }

    @RequestMapping(value="/courses/{courseId}")
    public ModelAndView findCourse(String courseId){
        ModelAndView mav = new ModelAndView("你的html");
        mav.addObject("courseId",courseId);//传入到页面
        System.out.println("Find courses with ID: " + courseId);
        return mav;
    }

    @RequestMapping(value = "/getJson", method = RequestMethod.POST)
    public String testGetJson(HttpServletRequest request){
        String param= null;
        try {
            BufferedReader streamReader = new BufferedReader( new InputStreamReader(request.getInputStream(), "UTF-8"));
            StringBuilder responseStrBuilder = new StringBuilder();
            String inputStr;
            while ((inputStr = streamReader.readLine()) != null)
                responseStrBuilder.append(inputStr);


            JSONObject jsonObject = JSONObject.parseObject(responseStrBuilder.toString());
            param = jsonObject.toJSONString();
            System.out.println(jsonObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return param;

    }

}
