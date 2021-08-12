package com.example.demo.design.group;

/**
 * @ClassName : DoMain  //类名
 * @Description :   //描述
 * @Author : lhy  //作者
 * @Date: 2020-09-27 14:23  //时间
 */
public class DoMain {
    public static void main(String[] args) {
        m1();
    }

    public static void m1() {
        IInfo end1 = new EndImpl("end1");
        EndImpl end2 = new EndImpl("end2");
        EndImpl end3 = new EndImpl("end3");

        BranchImpl branch3 = new BranchImpl("branch3");

        BranchImpl branch1 = new BranchImpl("branch1");
        branch1.addInfo(end1);
        branch1.addInfo(end3);
        branch1.addInfo(branch3);
        BranchImpl branch2 = new BranchImpl("branch2");
        branch2.addInfo(end2);


        RootImpl root = new RootImpl("root");
        root.addBranch(branch1);
        root.addBranch(branch2);

        root.getSub(root.getSubList());

    }
}
