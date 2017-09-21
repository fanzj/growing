package com.jary.daily.grows.basic;

import sun.security.krb5.internal.crypto.Des;

/**
 * @author fanzhengjie
 * @version 1.0
 * @create 2017/9/20 下午6:14
 */
public class Goods {

    private class Content implements Contents {

        private int i = 11;

        @Override
        public int value() {
            return i;
        }
    }

    protected class GDestination implements Destination{

        private String label;

        public GDestination(String whereTo){
            this.label = whereTo;
        }

        @Override
        public String readLabel() {
            return label;
        }
    }

    public Destination dest(String s){
        return new GDestination(s);
    }

    public Contents cont(){
        return new Content();
    }
}
