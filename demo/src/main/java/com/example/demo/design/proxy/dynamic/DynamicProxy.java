package com.example.demo.design.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @ClassName : DynamicProxy  //类名
 * @Description :   //描述
 * @Author : lhy  //作者
 * @Date: 2020-09-27 15:55  //时间
 */
public class DynamicProxy implements InvocationHandler {
    public Object obj;

    public DynamicProxy(Object obj) {
        this.obj = obj;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//        Object ob= proxy.getClass().newInstance();
       Object result= method.invoke(obj,args);
        return result;
    }
}
