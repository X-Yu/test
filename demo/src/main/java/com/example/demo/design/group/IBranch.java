package com.example.demo.design.group;

import java.util.List;

/**
 * @ClassName : IBranch  //类名
 * @Description :   //描述
 * @Author : lhy  //作者
 * @Date: 2020-09-27 14:15  //时间
 */
public interface IBranch extends IInfo {
    public void addInfo(IInfo info);
    public void getInfo();
    public List getSub();
}
