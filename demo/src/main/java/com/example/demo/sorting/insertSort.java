package com.example.demo.sorting;

/**
 * @ClassName : insertSort  //类名
 * @Description :   //描述
 * @Author : lhy  //作者
 * @Date: 2020-10-13 17:57  //时间
 */
public class insertSort {
    public static void main(String[] args) {
        int[] a = {3, 5, 2, 4, 1};
        m1(a, 1);
        for (int b : a
        ) {
            System.out.println(b);
        }
    }

    public static void m1(int[] arr, int start) {
//        for (int i = 0; i < arr.length; i++) {
        int b = arr[start];
        if (start == 0) {
            return;
        }
        if (b > arr[b - 1]) {
            int swap = arr[b];
            arr[b] = arr[b - 1];
            arr[b - 1] = swap;
            m1(arr, b - 1);
        } else {
            m1(arr, b + 1);
        }
//        }
    }
}
