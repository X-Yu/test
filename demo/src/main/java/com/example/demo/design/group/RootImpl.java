package com.example.demo.design.group;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName : RootImpl  //类名
 * @Description :   //描述
 * @Author : lhy  //作者
 * @Date: 2020-09-27 14:16  //时间
 */
public class RootImpl implements IRoot {
    List subList = new ArrayList<>();
    private String name;

    public RootImpl(String name) {
        this.name = name;
    }

    @Override
    public void addBranch(IBranch branch) {
        subList.add(branch);
    }

    @Override
    public void addEnd(IEnd end) {
        subList.add(end);
    }

    @Override
    public void getInfo() {
        System.out.println("root name:" + name + "-");
    }


    @Override
    public void getSub(List sub) {
        for (Object list : sub) {
            if (list instanceof IBranch) {
                ((IBranch) list).getInfo();
                getSub(((IBranch) list).getSub());
            } else {
                ((IEnd) list).getInfo();
            }
        }
    }

    public List getSubList() {
        return subList;
    }

    public void setSubList(List subList) {
        this.subList = subList;
    }
}
