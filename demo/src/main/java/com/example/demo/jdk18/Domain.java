package com.example.demo.jdk18;

import com.spire.doc.fields.omath.MathObject;
import org.springframework.util.StringUtils;

import java.util.Iterator;
import java.util.Set;
import java.util.regex.Pattern;

/**
 * @ClassName : Domain  //类名
 * @Description :   //描述
 * @Author : lhy  //作者
 * @Date: 2021-04-15 16:51  //时间
 */
public class Domain {

    public static void main(String[] args) {
        String topics = "chat.*,c";
        String topic = "chat:2380";
       boolean falg=Pattern.matches(topics, topic);
        System.out.println(falg);
    }


}
