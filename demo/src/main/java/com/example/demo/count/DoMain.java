package com.example.demo.count;

import java.math.BigDecimal;

/**
 * @ClassName : DoMain  //类名
 * @Description :   //描述
 * @Author : lhy  //作者
 * @Date: 2021-04-07 10:45  //时间
 */
public class DoMain {

    public static void main(String[] args) {
        String a="0";
        String raiot="0.35";
        String month="20000";
         a= new BigDecimal(raiot).multiply(new BigDecimal(month)).setScale(2,BigDecimal.ROUND_DOWN).toString();
        System.out.println(a);
    }
}
