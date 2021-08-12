package com.example.demo.asp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName : LogController  //类名
 * @Description : 日志请求  //描述
 * @Author : lhy  //作者
 * @Date: 2020-03-27 10:37  //时间
 */
@RestController
@RequestMapping("/log")
public class LogController {

    @Autowired
    private LogService logService;

    @RequestMapping("/other")

    public String other(){
        System.out.println("---进入 controller--");
        LogBean logBean=new LogBean();
        logService.save(logBean);
        System.out.println("---");
        return "结束";
    }

}
