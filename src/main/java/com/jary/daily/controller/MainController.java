package com.jary.daily.controller;

import com.codahale.metrics.Counter;
import com.codahale.metrics.Histogram;
import com.codahale.metrics.Meter;
import com.codahale.metrics.Timer;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author fanzhengjie
 * @create 2018/9/16 下午5:08
 * @description
 */
@Controller
@RequestMapping("/")
public class MainController {

    /*@Autowired
    private Meter requestMeter;

    @Autowired
    private Histogram responseSizes;

    @Autowired
    private Counter pendingJobs;

    @Autowired
    private Timer responses;

    //@Autowired
    //private ListManager listManager;

    @RequestMapping("/hello")
    @ResponseBody
    public String helloWorld() {

        requestMeter.mark();

        pendingJobs.inc();

        responseSizes.update(new Random().nextInt(10));

        //listManager.getList().add(1);

        final Timer.Context context = responses.time();
        try {
            return "Hello World";
        } finally {
            context.stop();
        }
    }*/
}
