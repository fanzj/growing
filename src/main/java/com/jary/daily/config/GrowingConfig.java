package com.jary.daily.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * @author fanzhengjie
 * @version 1.0
 * @create 2017/9/21 上午10:53
 */
@Configuration
@ImportResource(locations = "classpath:/bean/*.xml")
public class GrowingConfig {
}
