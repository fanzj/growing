package com.jary.daily.test;

import com.oracle.webservices.internal.api.databinding.Databinding;

/**
 * @author fanzhengjie
 * @version 1.0
 * @create 2017/9/14 下午3:37
 */
public class UserDTO {

    private String username;



    public static void main(String[] args){
        UserDTO user = new UserDTO();
        user.username = "admin";


    }

    public static class UserVO{
        private String username;

        private static StringBuilder Builder;


        private static void test(){
            Builder.append("a");
        }


    }
}
