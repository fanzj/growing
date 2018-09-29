package com.jary.daily.service.impl;

import com.jary.daily.service.TestService;
import org.springframework.stereotype.Service;

/**
 * @author fanzhengjie
 * @create 2018/9/26 下午10:33
 * @description
 */
@Service
public class TestServiceImpl implements TestService{

    @Override
    public void doSth() {
        System.out.println("i want to do sth");
    }
}
