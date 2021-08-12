package com.example.demo.design.group;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName : BranchImpl  //类名
 * @Description :   //描述
 * @Author : lhy  //作者
 * @Date: 2020-09-27 14:19  //时间
 */
public class BranchImpl implements IBranch {
    List<IInfo> sub = new ArrayList();
    String name;

    public BranchImpl(String name) {
        this.name = name;
    }


    @Override
    public void addInfo(IInfo info) {
        sub.add(info);
    }

    @Override
    public void getInfo() {
        System.out.println("branch name:" + name);
    }

    public List getSub() {
        return sub;
    }

}
