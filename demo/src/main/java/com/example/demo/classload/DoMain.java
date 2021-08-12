package com.example.demo.classload;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @ClassName : DoMain  //类名
 * @Description :   //描述
 * @Author : lhy  //作者
 * @Date: 2021-05-11 16:59  //时间
 */
public class DoMain extends ClassLoader {
    private String path;

    public DoMain(String path) {
        this.path = path;
    }

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        String p = "/Users/lhy/Documents/ok-project/demo/src/main/java/com/example/demo/classload/First.class";
        DoMain doMain = new DoMain(p);
        Class clazz = doMain.findClass("com.example.demo.classload.First");
        Object obj = (First) clazz.newInstance();
        System.out.println(((First) obj).getA());
    }


    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        File file = new File(path);
        Class l = null;
        if (file.exists()) {
            FileInputStream in = null;
            ByteArrayOutputStream out = null;
            try {
                in = new FileInputStream(file);
                out = new ByteArrayOutputStream();

                byte[] buffer = new byte[1024];
                int size = 0;
                while ((size = in.read(buffer)) != -1) {
                    out.write(buffer, 0, size);
                }

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    in.close();
                } catch (IOException e) {

                    e.printStackTrace();
                }
            }
            byte[] data = out.toByteArray();
            if (data != null) {
                l = defineClass(name, data, 0, data.length);
            }
            return l;
        }
        return l;
    }
}
