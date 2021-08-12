package com.example.demo.design.group;

/**
 * @ClassName : EndImpl  //类名
 * @Description :   //描述
 * @Author : lhy  //作者
 * @Date: 2020-09-27 14:21  //时间
 */
public class EndImpl implements IEnd {
   String name;

    public EndImpl(String name) {
        this.name = name;
    }

    @Override
    public void getInfo() {
        System.out.println("end name:"+name);
    }
}
