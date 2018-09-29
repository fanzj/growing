package com.jary.daily.config;

import com.codahale.metrics.*;
import java.util.concurrent.TimeUnit;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author fanzhengjie
 * @create 2018/9/16 下午5:02
 * @description
 */
//@Configuration
public class MetricConfig {

    /*@Bean
    public MetricRegistry metrics() {
        return new MetricRegistry();
    }

    *//**
     * Reporter 数据的展现位置
     *//*
    @Bean
    public ConsoleReporter consoleReporter(MetricRegistry metrics) {
        return ConsoleReporter.forRegistry(metrics)
            .convertRatesTo(TimeUnit.MINUTES)
            .convertDurationsTo(TimeUnit.SECONDS)
            .build();
    }

    @Bean
    public Slf4jReporter slf4jReporter(MetricRegistry metrics) {
        return Slf4jReporter.forRegistry(metrics)
            .outputTo(LoggerFactory.getLogger("demo.metrics"))
            .convertRatesTo(TimeUnit.MINUTES)
            .convertDurationsTo(TimeUnit.SECONDS)
            .build();
    }

    @Bean
    public JmxReporter jmxReporter(MetricRegistry metrics) {
        return JmxReporter.forRegistry(metrics).build();
    }

    *//**
     * 自定义单位
     *//*
   *//* @Bean
    public ListManager listManager(MetricRegistry metrics) {
        return new ListManager(metrics);
    }*//*

    *//**
     * TPS 计算器
     *//*
    @Bean
    public Meter requestMeter(MetricRegistry metrics) {
        return metrics.meter("request");
    }

    *//**
     * 直方图
     *//*
    @Bean
    public Histogram responseSizes(MetricRegistry metrics) {
        return metrics.histogram("response-sizes");
    }

    *//**
     * 计数器
     *//*
    @Bean
    public Counter pendingJobs(MetricRegistry metrics) {
        return metrics.counter("requestCount");
    }

    *//**
     * 计时器
     *//*
    @Bean
    public Timer responses(MetricRegistry metrics) {
        return metrics.timer("executeTime");
    }
*/
}
