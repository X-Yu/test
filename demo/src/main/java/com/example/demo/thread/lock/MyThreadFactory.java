package com.example.demo.thread.lock;

import java.util.concurrent.ThreadFactory;

/**
 * @ClassName : MyThreadFactory  //类名
 * @Description :   //描述
 * @Author : lhy  //作者
 * @Date: 2020-10-21 15:40  //时间
 */
public class MyThreadFactory implements ThreadFactory {
    String name;

    public MyThreadFactory(String name) {
        this.name = name;
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r);
        t.setName(name);
        return t;
    }
}
