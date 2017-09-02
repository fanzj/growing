package com.jary.daily.grows.annoation.demo1;

import com.jary.daily.grows.annoation.demo1.Greeting;
import com.jary.daily.grows.annoation.demo1.NewAnnotation;

/**
 * @author fanzhengjie
 * @version 1.0
 * @create 2017/8/28 上午10:09
 */
public class AnnotationTest {

    @NewAnnotation(value = "saymethod")
    public static void saying(){

    }

    @NewAnnotation("mainmethod")
    public static void main(String[] args){
        saying();
        sayHelloWithDefaultFontColor();
        sayHelloWithRedFontColor();
    }

    // 此时的fontColor为默认的RED
    @Greeting(name="defaultfontcolor")
    public static void sayHelloWithDefaultFontColor() {
    }

    // 将fontColor改为BLUE
    @Greeting(name="notdefault", fontColor=Greeting.FontColor.BLUE)
    public static void sayHelloWithRedFontColor(){
    }
}
