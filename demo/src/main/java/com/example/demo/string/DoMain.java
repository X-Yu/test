package com.example.demo.string;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.apache.commons.lang3.time.DateUtils;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Year;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.TemporalUnit;
import java.util.*;

/**
 * @ClassName : DoMain  //类名
 * @Description :   //描述
 * @Author : lhy  //作者
 * @Date: 2021-03-04 16:56  //时间
 */
public class DoMain {
    public static void main(String[] args) {
//
//
       m1();
    }

    public static void m1(){
        String a="1|+|2|+||+|34";
        String  [] b=a.split("\\|\\+\\|");
        for (String s:b
             ) {
            System.out.println(s);
        }
    }

}
