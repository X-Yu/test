package com.example.demo.thread;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName : Domain  //类名
 * @Description :   //描述
 * @Author : lhy  //作者
 * @Date: 2020-09-09 16:49  //时间
 */
public class Domain {
    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, ClassNotFoundException, NoSuchMethodException, InstantiationException {
//        Class clazz= Class.forName("com.example.demo.thread.Demons");
//        Object obj= clazz.newInstance();
//        Method m= clazz.getMethod("b", Integer.class);
//
//        m.invoke(obj,12);
//        LinkedBlockingQueue linkedBlockingQueue=new LinkedBlockingQueue(2);
//        System.out.println(linkedBlockingQueue.offer("3"));
//        linkedBlockingQueue.add("1");
//
//        System.out.println(linkedBlockingQueue.poll());
//        System.out.println(linkedBlockingQueue.size());
        m2();
    }

    public void m() throws IllegalAccessException, InvocationTargetException {

        Demons d = new Demons();
        Class clazz = d.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field f : fields) {
            System.out.println(f.getDeclaringClass());
            System.out.println(f.getName());
            System.out.println(f.getType().getName());
            f.setAccessible(true);
            try {
                System.out.println(f.get(d));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

            if (f.getType().getName().equals("java.lang.Integer")) {
                f.set(d, 2);
            }
            System.out.println(f.get(d));
        }

        Method[] methods = clazz.getDeclaredMethods();
        for (Method m : methods
        ) {
            System.out.println("方法名:" + m.getName());
            Type[] types = m.getParameterTypes();
            for (Type t : types
            ) {
                System.out.println("类型:" + t.getTypeName());
            }
            m.setAccessible(true);
            String s = "123";
            if (m.getName().equals("a")) {
                m.invoke(d, s);
            }


        }

    }

    public static void m2() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 4, 3, TimeUnit.SECONDS, new LinkedBlockingQueue<>(1), new TestThreadFactory("domain"));
        Demons demons = new Demons();
        threadPoolExecutor.execute(demons);
        Demons demons2 = new Demons();
        Demons demons3 = new Demons();
        Demons demons4 = new Demons();
        Demons demons5 = new Demons();
        threadPoolExecutor.execute(demons2);
        threadPoolExecutor.execute(demons3);
        threadPoolExecutor.execute(demons4);
        threadPoolExecutor.execute(demons5);
        threadPoolExecutor.execute(demons5);
    }
}
