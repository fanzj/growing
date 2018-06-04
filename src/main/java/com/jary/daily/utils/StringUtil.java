package com.jary.daily.utils;


import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;

/**
 * Created by xiky on 2017/4/25.
 */
public class StringUtil {

    public static String getKeysByList(String...args) {
        String keys = "";
        for (int i = 0; i < args.length; i++) {
            if (i == 0) keys = args[i];
            else keys = keys + "," + args[i];
        }
        return keys;
    }

    public static String getLineInfo()
    {
        StackTraceElement ste = new Throwable().getStackTrace()[1];
        return ste.getFileName() + ": Line " + ste.getLineNumber();

    }

    public static String readFile(String path) throws IOException {
        File file = new File(path);
        BufferedReader reader = null;

        InputStreamReader inputStreamReader = null;
        FileInputStream fileInputStream = null;
        StringBuilder builder = new StringBuilder();
        try {
            fileInputStream = new FileInputStream(file);
            inputStreamReader = new InputStreamReader(fileInputStream,StandardCharsets.UTF_8.toString());
            reader = new BufferedReader(inputStreamReader);
            String tempString = null;
            int line = 1;
            while ((tempString = reader.readLine()) != null) {
                builder.append(new String(tempString.getBytes()).trim());
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fileInputStream!=null){
                fileInputStream.close();
            }
            if(inputStreamReader!=null){
                inputStreamReader.close();
            }
            if (reader != null) {
                reader.close();
            }
        }
        return builder.toString();
    }



    public static void main(String[] args) throws IOException {
        StringUtil stringUtil = new StringUtil();
        stringUtil.getFile("config/maintain.json");
    }

    public void getFile(String fileName) throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        /**
         getResource()方法会去classpath下找这个文件，获取到url resource, 得到这个资源后，调用url.getFile获取到 文件 的绝对路径
         */
        URL url = classLoader.getResource(fileName);
        /**
         * url.getFile() 得到这个文件的绝对路径
         */
        System.out.println(url.getFile());
        File file = new File(url.getFile(), StandardCharsets.UTF_8.toString());
        System.out.println(readFile(url.getFile()));
    }
}
