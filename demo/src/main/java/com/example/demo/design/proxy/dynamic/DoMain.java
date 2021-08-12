package com.example.demo.design.proxy.dynamic;

import java.lang.reflect.Proxy;

/**
 * @ClassName : DoMain  //类名
 * @Description :   //描述
 * @Author : lhy  //作者
 * @Date: 2020-09-27 15:36  //时间
 */
public class DoMain {

    public static void main(String[] args) {
        MyWork myWork=new MyWork("XX");
        DynamicProxy staticProxy=new DynamicProxy(myWork);
       Work work= (Work) Proxy.newProxyInstance(myWork.getClass().getClassLoader(),myWork.getClass().getInterfaces(),staticProxy);
       work.computer();
//        staticProxy.invoke(myWork.getClass().getClassLoader(),)
    }
}
