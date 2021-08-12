package com.example.demo.numberT;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @ClassName : DoMain  //类名
 * @Description :   //描述
 * @Author : lhy  //作者
 * @Date: 2021-05-07 18:19  //时间
 */
public class DoMain {
    public static void main(String[] args) {

//m3();
    }

    public static void m1(){
        String bodyString="{\"response\": {\"subCode\":\"00000\",\"subMsg\":\"处理完成\",\"sndDt\":\"20210803141558\",\"msgBody\":{\"acctNo\":\"6212261001073560630\",\"acctName\":\"曹朵一\",\"bankCode\":\"01020000\",\"busiMerNo\":\"100000000000002\",\"trxTtlAmt\":\"1000\",\"payType\":\"cardpay\",\"ordrDesc\":\"聚合收银台测试\",\"trxDt\":\"20210803141630\",\"trxPayDt\":\"20210803141558\",\"pyerInf\":{\"pyerBankCode\":\"01020000\",\"pyerBankType\":\"0102\",\"pyerAcctType\":\"0\",\"pyerAcctNo\":\"6212261001073560630\",\"pyerAcctName\":\"曹朵一\",\"pyerIdType\":\"0\",\"pyerIdNo\":\"40123198109239750\",\"pyerBankName\":\"工商银行\",\"pyerMobile\":\"15523706110\",\"pyerProtocolNo\":\"0102202011300922580001\",\"pyerProtocolUser\":\"100000000000002\"},\"fqRspInf\":{\"fqNum\":\"\",\"fqPayFee\":\"\",\"fqPayFeeStyle\":\"\",\"fqFirstFee\":\"\",\"fqEachFee\":\"\",\"fqDwnAmt\":\"\",\"fqRealRate\":\"\"},\"oriMerOrdrNo\":\"10000000000000220210803141640546\",\"retCode\":\"00000\",\"retMsg\":\"交易?成功\",\"tradeStatus\":\"00\",\"trxFinDt\":\"20210803141558\",\"remark\":\"商户联调测试\",\"remark1\":\"remark1\",\"remark2\":\"remark2\",\"remark3\":\"\",\"remark4\":\"\"},\"remark\":\"\"},\"code\":\"00000\",\"msg\":\"处理完成\",\"sign\":\"70cc1a5164b3b3361447b80da4edb6b06240783299e1baac7ab6d42943bcfc9d4908a89a18edf047dc6cf309a0be099b23fb876a7e22bc6327282926a08ea340dbd258c2e976f348c49e842d4c27050cb45a6b3163254e6f7a910a1003735b27cacecb255e05a290e885f0cced80288a0fc9b33c271e5f4978348dae56d34e9738feb8e662e2f34dc203ab42921d963d0998cfb419f927f1bd78e3a5cc4725649773c334cc362bab9ba7eae7a878f239dea562035382d99487b9343b360c8f3bc89d21641eb7fac57e03dbc544e32885a5d317dcbfe30b4659ac27fbc8bdcb3a934b65c89ffb021126e496a9ee4c0e5cca5a8eb1103b073cf17c1518764a62b2\"}";
        String[] split = bodyString.split("&");
        for (String s1 : split) {
            System.out.println("string s1--"+s1);
            String[] split1 = s1.split("=");
            System.out.println("split1---"+split1.length);
            System.out.println("split1---"+split1[0]);
//            map.put(split1[0], split1[1]);
        }
//        return map;
    }

    public static void m2(){
        String b="sdseg+sdfs=sdfag";
        System.out.println(b.split(("=")).length);
        System.out.println(b.split("=")[0]);
    }


    public static void m3(){
        Queue<Map> queue=new ConcurrentLinkedQueue();
        Map<String, String> map=new HashMap<>();
        map.put("111","222");
        queue.offer(map);
        map.put("111","333");
        queue.offer(map);
        while(!queue.isEmpty()){
            Map<String, String> m1= queue.poll();
            System.out.println(m1.toString());
        }
    }

}
