package com.example.demo.serialize;

import org.openjdk.jol.info.ClassLayout;

import java.io.*;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName : DoMain  //类名
 * @Description :   //描述
 * @Author : lhy  //作者
 * @Date: 2020-06-10 14:25  //时间
 */
public class DoMain {

   static Lock lock=new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {

        User u=new User("li","2","12");
        System.out.println("maureen test:" + ClassLayout.parseInstance(u).toPrintable());

        System.out.println(u.hashCode());
        System.out.println("maureen test:" + ClassLayout.parseInstance(u).toPrintable());
        lock.tryLock(3, TimeUnit.SECONDS);
        System.out.println(u.hashCode());
        lock.unlock();

        synchronized (u){
            System.out.println(u.hashCode());
            System.out.println("maureen test:" + ClassLayout.parseInstance(u).toPrintable());
        }


    }

    public void m1(){
        User user = new User("li", "20", "123456");
        ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream(1024);
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(arrayOutputStream);
            oos.writeObject(user);
            ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(arrayOutputStream.toByteArray()));
            User u2 = (User) objectInputStream.readObject();
            System.out.println(user);
            System.out.println(u2);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

}
