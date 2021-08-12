package com.example.demo.thread.pool;

/**
 * @ClassName : executor  //类名
 * @Description :   //描述
 * @Author : lhy  //作者
 * @Date: 2020-10-21 16:42  //时间
 */
public class executor {
    public static void main(String[] args) {
        int [] a={0,1,1,2,3,5,8};
        int b= split(a);
        System.out.println(b);
    }

    public static int sum(int[] numbers, int from, int to) {
        int sum = 0;
        for (int i = from; i <= to; i++) {
            sum += numbers[i];
        }
        return sum;
    }

    public static int  split(int [] number){
        int count=0;
        int total=number.length;
        int group= total/4;
        System.out.println(group);
        for(int i=0;i<=group;i++){
            int form=i*group;
//            int to=(i==)
           count+=  sum(number,i*group,(i+1)*group-1);
        }
        return count;
    }

}
