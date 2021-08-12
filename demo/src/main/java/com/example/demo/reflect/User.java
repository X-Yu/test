package com.example.demo.reflect;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName : User  //类名
 * @Description :   //描述
 * @Author : lhy  //作者
 * @Date: 2020-10-29 14:27  //时间
 */
public class User {
    private String name = 1 + "";

    private static  Map<String, Object> map = new HashMap<>();

    static{
        map.put("5","5");
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Object> getMap() {
        map.put("3","3");
        map.put("4","4");
        return map;
    }

    public void setMap(Map<String, Object> map) {
        map.put("1", "1");
        map.put("2", "2");
        this.map = map;
    }
}
