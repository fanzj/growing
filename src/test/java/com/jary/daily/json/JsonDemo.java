package com.jary.daily.json;

import com.jary.daily.utils.StringUtil;
import org.junit.Test;

import java.io.IOException;
import java.net.URL;

/**
 * @author fanzhengjie
 * @version 1.0
 * @create 2017/10/31 下午7:01
 */
public class JsonDemo {

    @Test
    public void readJsonFile() throws IOException {
        StringUtil stringUtil = new StringUtil();
        stringUtil.getFile("config/maintain.json");
    }
}
