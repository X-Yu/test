package com.example.demo.netty;

import java.io.File;

/**
 * @ClassName : Consume  //类名
 * @Description :   //描述
 * @Author : lhy  //作者
 * @Date: 2020-10-25 08:38  //时间
 */
public class Consume {
    public static void main(String[] args) {
        File file=new File("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1603960426805&di=6b74f9b69870e2f4db01bcf4db00d7b2&imgtype=0&src=http%3A%2F%2Fmedia-cdn.tripadvisor.com%2Fmedia%2Fphoto-s%2F01%2F3e%2F05%2F40%2Fthe-sandbar-that-links.jpg");
        System.out.println(file.getName());
        System.out.println(file.length());
    }
}
