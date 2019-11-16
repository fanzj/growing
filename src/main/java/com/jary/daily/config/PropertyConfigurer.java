package com.jary.daily.config;

import com.google.common.collect.Maps;
import java.io.FileInputStream;
import java.util.Map;
import java.util.Properties;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.core.io.Resource;

/**
 * @author fanzhengjie
 * @create 2019/8/10 下午1:53
 * @description
 */
public class PropertyConfigurer extends PropertyPlaceholderConfigurer {

    private static Map<String, String> propertiesMap = Maps.newHashMap();

    @Override
    protected void processProperties(ConfigurableListableBeanFactory beanFactoryToProcess, Properties props)
        throws BeansException {
        super.processProperties(beanFactoryToProcess, props);

        for(Object key : props.keySet()){
            String keyStr = key.toString();
            String value = String.valueOf(props.get(keyStr));
            propertiesMap.put(keyStr, value);
        }
    }

    public static String getProperty(String key){
        return propertiesMap.get(key);
    }

    public static Map<String, String> getAllProperty() {
        return propertiesMap;
    }

    public static void main(String[] args) {
        int payType = 35;
        System.out.println((byte) (1 << payType));
    }
}
