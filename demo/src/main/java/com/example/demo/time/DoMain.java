package com.example.demo.time;

import cn.hutool.core.date.DateUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName : DoMain  //类名
 * @Description :   //描述
 * @Author : lhy  //作者
 * @Date: 2021-08-11 10:37  //时间
 */
public class DoMain {

    public static void main(String[] args) {
//  m1();
        m2();
        m1();
    }
    public static void m1(){
        String time="10-8月 -21 02.42.53.000000 下午";
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd-M月 -yy hh:mm:ss.SSSSSS a");
        Date date= DateUtil.parse(time,"dd-M月 -yy hh.mm.ss.SSSSSS a");
        System.out.println(DateUtil.format(date,"yyyy-MM-dd HH:mm:ss"));
        try {
            System.out.println(simpleDateFormat.parse(time));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public static void m2(){
        System.out.println(DateUtil.format(new Date(),"dd-M月 -yy hh.mm.ss.SSSSSS a"));
    }

}
