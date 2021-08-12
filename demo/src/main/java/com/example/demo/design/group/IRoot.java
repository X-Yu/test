package com.example.demo.design.group;

import java.util.List;

public interface IRoot {
    public void addBranch(IBranch branch);
    public void addEnd(IEnd end);
    public void getInfo();
    public void  getSub(List sub);
}
