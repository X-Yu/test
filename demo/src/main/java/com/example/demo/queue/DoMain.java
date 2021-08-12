package com.example.demo.queue;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Iterator;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @ClassName : DoMain  //类名
 * @Description :   //描述
 * @Author : lhy  //作者
 * @Date: 2020-09-22 16:12  //时间
 */
public class DoMain {
    static LinkedBlockingQueue<String> lbq=new LinkedBlockingQueue();
    public static void main(String[] args) {
//        m1();
        System.out.println(LocalDateTime.now());
        System.out.println(LocalDateTime.now().toEpochSecond(ZoneOffset.of("+8")));
    }

    private static class T1 implements Runnable{

        @Override
        public void run() {
            try {
                 Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i=0;i<5;i++){
                try {
                    lbq.put(i+"");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("T1 结束");
        }
    }

    private  static class T2 implements  Runnable{

        @Override
        public void run() {
            for(int i=5;i<10;i++){
                try {
                    lbq.put(i+"");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("T2 结束");
        }
    }
    public static void m1(){

        T1 t1=new T1();
        Thread t=new Thread(t1);
        t.setPriority(5);
        t.setName("1");
        t.start();


        T2 t2=new T2();
        Thread tt=new Thread(t2);
        tt.setPriority(10);
        tt.setName("2");
        tt.start();

        System.out.println("执行遍历");
        Iterator  ite= lbq.iterator();
        while(ite.hasNext()){
            System.out.println(ite.next()+"-");
        }

    }
}
