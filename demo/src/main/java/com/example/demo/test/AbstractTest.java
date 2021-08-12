package com.example.demo.test;

/**
 * @ClassName : AbstractTest  //类名
 * @Description :   //描述
 * @Author : lhy  //作者
 * @Date: 2020-09-23 15:42  //时间
 */
public abstract class AbstractTest implements TestInterface {

    @Override
    public void m1() {
        if (m2()) {
            System.out.print("true");
        } else {
            System.out.println("抽象实现1");
        }

    }

    public abstract boolean m2();

    @Override
    public void m3() {
        System.out.println("抽象实现3");
    }
}
