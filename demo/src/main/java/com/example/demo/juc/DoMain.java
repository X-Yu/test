package com.example.demo.juc;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName : DoMain  //类名
 * @Description :   //描述
 * @Author : lhy  //作者
 * @Date: 2020-09-24 15:44  //时间
 */
public class DoMain {
    public static void main(String[] args) {

//        ConcurrentHashMap<String,Map<String,String>> concurrentHashMap=new ConcurrentHashMap();
//        Map<String,String> map=new HashMap<>();
//        Map cmap= concurrentHashMap.putIfAbsent("1",map);
//        if(cmap==null){
//            cmap=map;
//        }
//        System.out.println(cmap.size());

        int a=-1<<29;
        System.out.println(a);
        System.out.println(a | 0);
    }
}
