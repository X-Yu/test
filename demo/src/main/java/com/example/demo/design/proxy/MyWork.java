package com.example.demo.design.proxy;

/**
 * @ClassName : MyWork  //类名
 * @Description :   //描述
 * @Author : lhy  //作者
 * @Date: 2020-09-27 15:33  //时间
 */
public class MyWork implements Work {
    String name;

    public MyWork(String name) {
        this.name = name;
    }

    @Override
    public void computer() {
        System.out.println(name + " 使用电脑工作");
    }
}
