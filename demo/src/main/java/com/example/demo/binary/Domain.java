package com.example.demo.binary;

import java.io.*;

/**
 * @ClassName : Domain  //类名
 * @Description :   //描述
 * @Author : lhy  //作者
 * @Date: 2020-06-29 10:26  //时间
 */
public class Domain extends ClassLoader{
    int a=0;
    int b=1;

    public static void main(String[] args) throws IOException {

        String path="/Users/lhy/Documents/留言导入.xlsx";
        File f=new File(path);
        InputStream in =new FileInputStream(f);
        byte [] b =new byte[3];        System.out.println(getSystemClassLoader());

        in.read(b);
        System.out.println(b[0]+"--"+b[1]+"--"+b[2]);
        if (b[0] == -17 && b[1] == -69 && b[2] == -65)
            System.out.println(f.getName() + "：编码为UTF-8");
        else
            System.out.println(f.getName() + "：可能是GBK，也可能是其他编码");
    }

}
