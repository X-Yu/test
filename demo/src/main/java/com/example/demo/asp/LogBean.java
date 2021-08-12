package com.example.demo.asp;

import java.util.Date;

/**
 * @ClassName : LogBean  //类名
 * @Description : 日志实体  //描述
 * @Author : lhy  //作者
 * @Date: 2020-03-27 10:34  //时间
 */
public class LogBean {
    private String name;
    private Date createDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public static void main(String[] args) {
        System.out.println("--111--");
    }
}
