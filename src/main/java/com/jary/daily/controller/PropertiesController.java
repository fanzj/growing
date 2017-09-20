package com.jary.daily.controller;

import com.jary.daily.domain.AuthorSettings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author fanzhengjie
 * @version 1.0
 * @create 2017/9/18 下午1:21
 */
@RestController
public class PropertiesController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PropertiesController.class);

    @Autowired
    private AuthorSettings authorSettings;

    @RequestMapping("/author")
    public String index() {
        return "author name is " + authorSettings.getName() + " and author age is " + authorSettings.getAge();
    }
}
