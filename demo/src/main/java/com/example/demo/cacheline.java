package com.example.demo;

/**
 * @ClassName : cacheline  //类名
 * @Description :   //描述
 * @Author : lhy  //作者
 * @Date: 2020-07-16 16:20  //时间
 */
public class cacheline {
    public static class C {
        // head 8
        // classpoint 4
        // instance 24 or 8
        // padding 4
//        public volatile long a1;
        public volatile long a1,a2,a4;
    }

    public static class E extends C{
        // head 8
        // classpoint 4
        // instance 8
        // padding 4
        private volatile long x=0;
    }

    public static void main(String[] args) throws InterruptedException {
        //
         E[] arr = new E[2];
        arr[0]=new E();
        arr[1]=new E();
        long s=System.currentTimeMillis();
        long count = 10000_000;
        Thread t1 = new Thread(() -> {
            for (long i = 0; i < 10000000; i++) {
                arr[0].x = i;
            }

        });
        Thread t2 = new Thread(() -> {
            for (long i = 0; i < 10000000; i++) {
                arr[1].x = i;
            }

        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        long e=System.currentTimeMillis();
        System.out.println(e-s);

    }


}
