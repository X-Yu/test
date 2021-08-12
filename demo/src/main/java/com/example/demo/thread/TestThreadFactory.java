package com.example.demo.thread;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @ClassName : TestThreadFactory  //类名
 * @Description :   //描述
 * @Author : lhy  //作者
 * @Date: 2020-09-23 16:51  //时间
 */
public class TestThreadFactory implements ThreadFactory {
    String name;

    public TestThreadFactory(String name) {
        this.name = name;
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r);
        t.setName(name);
        return t;
    }
}
