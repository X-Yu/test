package com.example.demo.load;

import sun.reflect.Reflection;

/**
 * @ClassName : DoMain  //类名
 * @Description :   //描述
 * @Author : lhy  //作者
 * @Date: 2020-09-23 14:50  //时间
 */
public class DoMain {
    public static void main(String[] args) {
//        Class<?> caller = Reflection.getCallerClass();
//        System.out.println(caller.getName());
        m2();
    }

    public static void m1() throws ClassNotFoundException {
       Class clazz= Class.forName("");
       clazz.getClassLoader();
        ClassLoader.getSystemClassLoader();

    }

    public static void m2(){
        Parent p=new Parent();
        System.out.println(p.getClass());
        System.out.println(p);
        Son s=new Son();
        System.out.println(s.getClass());
        s.m();
        System.out.println(s.getClass().getSuperclass());
    }
}
