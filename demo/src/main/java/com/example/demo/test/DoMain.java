package com.example.demo.test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.*;
import java.util.*;

/**
 * @ClassName : DoMain  //类名
 * @Description : 测试  //描述
 * @Author : lhy  //作者
 * @Date: 2020-04-07 15:28  //时间
 */
public class DoMain {
    public static void main(String[] args) throws Exception {
//        int [] a=new int[]{1,2,3};
//        for (int i=0;i<a.length;i++){
//            System.out.println(a[3]);
//        }
        TestInterface ti=new Test();
        ti.m1();
        ti.m2();

    }

    public static String randomNumber(int length) {
        int[] arr = new int[]{0, 1, 2, 3, 4, 5, 6};
        Random random = new Random();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int r = random.nextInt(7);
            int c = arr[r];
            String b = Integer.toHexString(c);
            result.append(b);
        }
        return result.toString();
    }

    public static String getNumber(int count) {
        String number = randomNumber(1);
        System.out.println("count" + count);
        System.out.println("number" + number);
        for (int i = 0; i < count; i++) {
//            CoroutineForm numberForm = coroutineFormMapping.selectByNumber(number);
            String numberForm = "1";

            if (numberForm.equals(number)) {
                System.out.println("一样");
                number = getNumber(count - 1);
//                System.out.println(number);
            } else {
                break;
            }

        }
        return number;
    }
}
