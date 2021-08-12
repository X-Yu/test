package com.example.demo.referencesvalue;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

/**
 * @ClassName : Domain  //类名
 * @Description :   //描述
 * @Author : lhy  //作者
 * @Date: 2020-04-20 17:47  //时间
 */
public class Domain {
    public static void main(String[] args) {
        String name="阿西吧/接口优化.txt";
        String relaName = name.substring(0, name.lastIndexOf("."));
        System.out.println(relaName);
        String parentDocument="";

        relaName = relaName.substring((relaName.lastIndexOf("/") + 1), relaName.length());
        System.out.println(relaName);
        parentDocument = relaName.substring(0, relaName.lastIndexOf("/"));
        System.out.println(relaName+"---"+parentDocument);
    }
}
