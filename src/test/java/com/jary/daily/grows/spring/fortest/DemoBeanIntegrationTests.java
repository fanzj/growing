package com.jary.daily.grows.spring.fortest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author fanzhengjie
 * @version 1.0
 * @create 2017/9/16 下午1:59
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestConfig.class})
@ActiveProfiles("prod")
public class DemoBeanIntegrationTests {

    @Autowired
    private TestBean testBean;

    @Test
    public void prodBeanShouldInject(){
        String expected = " from production profile";
        String actual = testBean.getContent();
        System.out.printf("expected = %s, actual = %s\n",expected,actual);
       // Assert.assertEquals(expected,actual);
    }
}
