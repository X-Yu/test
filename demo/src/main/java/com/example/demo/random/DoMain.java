package com.example.demo.random;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

/**
 * @ClassName : DoMain  //类名
 * @Description :   //描述
 * @Author : lhy  //作者
 * @Date: 2021-05-10 17:23  //时间
 */
public class DoMain {
    public static List p = new LinkedList();

    static {
        for (int i = 0; i < 10; i++) {
            p.add(i);
        }
    }

    public static void main(String[] args) {
        match(3);

    }

    public static void match(int groupNumber ) {
        List<Integer> first = new LinkedList<>();
        List<Integer> two = new LinkedList<>();
        System.out.println("---start---");

        int i = 0;
        int value = 10;
        while (i < groupNumber) {
            Integer index = random(value);
            if (first.contains(index)) {
                while (first.contains(index)) {
                    index = random(value);
                }
            }
            first.add(index);
            p.remove(index);
            value--;
            i++;
        }

        System.out.println("一队:");
        Stream.of(first).forEach(a -> System.out.println(a));
        System.out.println("二队:");
        p.removeAll(first);
        Stream.of(p).forEach(a -> System.out.println(a));


        System.out.println("---end---");
    }

    public static int random(int value) {
        ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
        return threadLocalRandom.nextInt(value);
    }

}
