package com.example.demo.referencesvalue;

/**
 * @ClassName : ListNode  //类名
 * @Description :   //描述
 * @Author : lhy  //作者
 * @Date: 2020-04-20 17:46  //时间
 */
public class ListNode {
    private int i;
    private ListNode next;

    public ListNode(int x) {
        i = x;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "i=" + i +
                ", next=" + next +
                '}';
    }
}
