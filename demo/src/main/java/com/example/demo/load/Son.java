package com.example.demo.load;

/**
 * @ClassName : Son  //类名
 * @Description :   //描述
 * @Author : lhy  //作者
 * @Date: 2020-09-24 09:57  //时间
 */
public class Son  extends Parent{

    private String s;

    public void m(){
        Class clazz=super.getClass();
        System.out.println(clazz);
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }
}
