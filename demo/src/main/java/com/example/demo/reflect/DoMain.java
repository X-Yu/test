package com.example.demo.reflect;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

/**
 * @ClassName : DoMain  //类名
 * @Description :   //描述
 * @Author : lhy  //作者
 * @Date: 2020-10-29 14:27  //时间
 */
public class DoMain {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException, IOException, NoSuchMethodException, InvocationTargetException {
            m2();
    }

    public static String Up(String name) {
        char[] s = name.toCharArray();
        s[0] -= 32;
        return String.valueOf(s);
    }

    public static void m2() throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        Map<String,String> map=new HashMap<>();
        User user=new User();
        Class clazz= User.class;
        Field field= clazz.getDeclaredField("map");
        field.setAccessible(true);
         Map m= (Map) field.get(user );
        System.out.println(m.size());
    }

    public static void m1() throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        File file = new File("");
        String path = file.getCanonicalPath();
        System.out.println(path);
        Class<?> aClass = Class.forName("com.example.demo.reflect.UserController");
        Field[] fields = aClass.getDeclaredFields();
        Object obj = aClass.newInstance();
        Thread t = new Thread();
        t.getName();
        for (Field f : fields
        ) {
            User user = new User();
            f.setAccessible(true);
            System.out.println(f.getName());
            System.out.println(f.getType().getName());
            Class c2 = Class.forName(f.getType().getName());
            Object o2 = c2.newInstance();
            f.set(obj, o2);
            Method m1 = aClass.getDeclaredMethod("get" + Up(f.getName()), null);
            System.out.println(m1.invoke(obj, null));
        }
        Method[] methods = aClass.getDeclaredMethods();
        for (Method m : methods
        ) {
            System.out.println(m.getName());
        }
    }

}
