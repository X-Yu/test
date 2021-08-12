package com.example.demo.thread.lock;

import org.springframework.scheduling.concurrent.ThreadPoolExecutorFactoryBean;

import java.util.concurrent.*;

/**
 * @ClassName : DoMain  //类名
 * @Description :   //描述
 * @Author : lhy  //作者
 * @Date: 2020-10-21 11:08  //时间
 */
public class DoMain {

    public static void main(String[] args) {
        LinkedBlockingQueue q = new LinkedBlockingQueue();
        ExecutorService consume = new ThreadPoolExecutor(3, 6,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(), new MyThreadFactory("消费"));
        consume.submit(new Consume(q));
        consume.submit(new Consume(q));
        consume.submit(new Consume(q));

        ExecutorService production = new ThreadPoolExecutor(3, 6,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(), new MyThreadFactory("生产"));
        production.submit(new Production(q));
        production.submit(new Production(q));
        production.submit(new Production(q));
    }
}
