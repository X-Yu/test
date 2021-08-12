package com.example.demo.asp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName : DoMain  //类名
 * @Description :   //描述
 * @Author : lhy  //作者
 * @Date: 2020-09-23 17:41  //时间
 */
public class DoMain {
    public static void main(String[] args) {
        List<LogBean> lists=new ArrayList<>();
        LogBean logBean=new LogBean();
        logBean.setName("1");
        lists.add(logBean);

        LogBean logBean2=new LogBean();
        logBean2.setName("1");
        lists.add(logBean2);
    }
}
