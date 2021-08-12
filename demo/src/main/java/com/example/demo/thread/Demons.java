package com.example.demo.thread;

import org.apache.tools.ant.taskdefs.Sleep;

/**
 * @ClassName : Demons  //类名
 * @Description :   //描述
 * @Author : lhy  //作者
 * @Date: 2020-09-09 16:47  //时间
 */
public class Demons implements Runnable {

    private String a="a";
    private Integer b=1;

    private String a(String s) {
        System.out.println(s+"--a");
        return s;
    }

    public Integer b(Integer d) {
        System.out.println("---d:"+d);
        return b;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("执行" + i + "次");
        }
    }
}
