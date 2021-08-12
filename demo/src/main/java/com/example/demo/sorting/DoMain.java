package com.example.demo.sorting;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * @ClassName : DoMain  //类名
 * @Description :   //描述
 * @Author : lhy  //作者
 * @Date: 2021-05-12 10:22  //时间
 */
public class DoMain {
    public static void main(String[] args) {

        List<Map<String, String>> xhintList = new ArrayList<>();
        int c = 0;
        for (int i = 0; i < 500000; i++) {
            Map<String, String> map = new HashMap<>();

            if (c == 60) {
                c = 0;
            }
            String date = LocalDateTime.now().minusSeconds(i).format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss"));
            System.out.println(date);
            map.put("latesttime", date);
            c++;
            xhintList.add(map);
        }

//        Map<String,String> map=new HashMap<>();
//        map.put("latesttime","2020-01-01 10:10:20");
//        map.put("latesttime","2020-01-01 10:15:20");
//        map.put("latesttime","2020-01-01 11:15:20");
//        xhintList.add(map);
        System.out.println("" + System.currentTimeMillis());
        xhintList.sort(Comparator.comparing((Map v) -> Optional.ofNullable(v.get("latesttime")).toString()).reversed());
        System.out.println("" + System.currentTimeMillis());
//        for (Map<String,String> m:xhintList
//             ) {
//            System.out.println(m.get("latestime"));
//        }

    }
}
