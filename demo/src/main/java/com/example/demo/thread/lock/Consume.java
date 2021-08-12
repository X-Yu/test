package com.example.demo.thread.lock;

import java.util.concurrent.BlockingQueue;

/**
 * @ClassName : Consume  //类名
 * @Description :   //描述
 * @Author : lhy  //作者
 * @Date: 2020-10-21 11:07  //时间
 */
public class Consume implements Runnable {
    private BlockingQueue<Integer> queue = null;

    public Consume(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Integer i = queue.take();
                System.out.println("消费了" + i + "次");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
