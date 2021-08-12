package com.example.demo.serialize;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Base64;

/**
 * @ClassName : User  //类名
 * @Description :   //描述
 * @Author : lhy  //作者
 * @Date: 2020-06-10 14:21  //时间
 */
public class User implements Serializable {

    private String name;
    private String age;
    private transient String pwd;

    public User(String name, String age, String pwd) {
        this.name = name;
        this.age = age;
        this.pwd = pwd;
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        System.out.println("自定义序列化" +
                "");
        //4.执行默认序列化
        out.defaultWriteObject();//序列化

    }
    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
