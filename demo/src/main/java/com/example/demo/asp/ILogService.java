package com.example.demo.asp;

import org.springframework.stereotype.Service;

/**
 * @ClassName : ILogService  //类名
 * @Description : 日志实现  //描述
 * @Author : lhy  //作者
 * @Date: 2020-03-27 10:37  //时间
 */
@Service
public class ILogService implements  LogService {

    @Log(addLog = "添加日志了")
    @Override
    public void save(LogBean logBean) {
        System.out.println("--添加日志了--");
    }
}
