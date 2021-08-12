package com.example.demo.sorting;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName : quickSort  //类名
 * @Description : 快排  //描述
 * @Author : lhy  //作者
 * @Date: 2020-06-29 11:18  //时间
 */
public class quickSort {

    public static void main(String[] args) {
//        int[] array = new int[]{5, 3, 8, 6, 10, 20, 30, 7, 2, 1};
//        int high = array.length - 1;
//        exce(array, 0, high);
//        for (int a :
//                array) {
//            System.out.println(a);
//        }
        Map map=new HashMap();
        System.out.println(map.size());
        map.put("1","1");
    }

    public static void exce(int[] array, int low, int high) {
        int i = low;
        int j = high;
        int temp = array[low];
        if (i >= j) {
            return;
        }

        while (i < j) {
            while (array[j] >= temp && i < j) {
                j--;
            }
            while (array[i] <= temp && i < j) {
                i++;
            }
            if (i < j) {
                int x = array[j];
                array[j] = array[i];
                array[i] = x;
            }

        }
        array[low] = array[i];
        array[i] = temp;

        if (i - 1 > low) exce(array, low, i - 1);
        if (j + 1 < high) exce(array, j + 1, high);
    }


}
