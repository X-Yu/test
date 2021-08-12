package com.example.demo.thread.lock;

import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @ClassName : Production  //类名
 * @Description :   //描述
 * @Author : lhy  //作者
 * @Date: 2020-10-21 11:07  //时间
 */
public class Production implements Runnable {

    private BlockingQueue<Integer> queue = null;

    public Production(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
            try {
                int i=0;
                queue.put(i++);
                System.out.println("生产了"+i+"次");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

    }
}
