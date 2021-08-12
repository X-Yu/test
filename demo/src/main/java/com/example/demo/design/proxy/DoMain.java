package com.example.demo.design.proxy;


import java.lang.reflect.Method;
import java.util.*;

/**
 * @ClassName : DoMain  //类名
 * @Description :   //描述
 * @Author : lhy  //作者
 * @Date: 2020-09-27 15:36  //时间
 */
public class DoMain {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
//        m2();
        Set  set=new HashSet();
        set.add("b");
        set.add("a");
        set.add("d");
        set.add("c");
        Iterator iterator=set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    public static void m2() throws ClassNotFoundException, IllegalAccessException, InstantiationException {

        String class_path = "com.example.demo.design.proxy.MyWork";
        Class clazz = Class.forName(class_path);
//        Object obj = clazz.newInstance();

        Method[] methods =  clazz.getDeclaredMethods();
        for (Method m :
                methods) {
            System.out.println(m.getName());
        }
    }

    public static void m1() {
        StaticProxy staticProxy = new StaticProxy(new MyWork("XX"));
        staticProxy.computer();
    }
}
