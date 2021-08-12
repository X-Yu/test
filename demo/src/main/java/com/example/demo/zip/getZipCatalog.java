package com.example.demo.zip;

import com.sun.deploy.net.HttpResponse;
import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipFile;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName : getZipCatalog  //类名
 * @Description : zip目录  //描述
 * @Author : lhy  //作者
 * @Date: 2020-03-26 10:58  //时间
 */
@RestController
@RequestMapping("/zip")
public class getZipCatalog {

    @RequestMapping("/look")
    public Map look() throws IOException {

        String url="/Users/lhy/Documents/ok-project/C.zip";
        ZipFile zf = new ZipFile(url);
        Enumeration<ZipEntry> enumeration = zf.getEntries();
        ZipEntry ze;

            Map<String,String> map=new HashMap<>();
    while(enumeration.hasMoreElements()){

        ze= enumeration.nextElement();
        System.out.println(ze.getName()+"---"+ze.getSize());

    }

            return map;
    }

    @RequestMapping("/download")
    public Map download(@RequestParam("file_name") String file_name, HttpServletResponse response) throws IOException {

        String url="/Users/lhy/Documents/ok-project/C.zip";
        if(file_name==null){
            file_name="上线/finishEvent.action.xml";
        }

        ZipFile zf = new ZipFile(url);
        Enumeration<ZipEntry> enumeration = zf.getEntries();
        ZipEntry ze;

        Map<String,String> map=new HashMap<>();

        while(enumeration.hasMoreElements()){


            ze= enumeration.nextElement();
            if(ze.getName().equals(file_name)){
                InputStream in=zf.getInputStream(zf.getEntry(file_name));
                byte[] buffer = new byte[in.available()];
                response.setHeader("Content-Disposition", "attachment; filename=" + file_name);
                response.setHeader("content-length", ze.getSize() + "");
                OutputStream out=response.getOutputStream();

                BufferedInputStream bis = new BufferedInputStream(in);
                int i = bis.read(buffer);
                while (i != -1) {
                    out.write(buffer, 0, i);
                    i = bis.read(buffer);
                }
                out.write(buffer, 0, i);
            }
            System.out.println(ze.getName()+"---"+ze.getSize());

        }

        return map;
    }

    public static void main(String[] args) throws IOException {
        String url = "/Users/lhy/Documents/1.zip";
        String path = "/Users/lhy/Documents";
        String name = "1.zip";
        ZipFile zf = null;
        try {
            File file = new File(url);
            zf = new ZipFile(url);
            if(zf.getEncoding()==null){
                zf = new ZipFile(file, "GBK", false);
            }else{
                zf = new ZipFile(url);
            }
            System.out.println(zf.getEncoding());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Enumeration<ZipEntry> enumeration = zf.getEntries();
        ZipEntry ze;

        while ((enumeration.hasMoreElements())) {
            ze = enumeration.nextElement();

            if (ze.isDirectory()) {
                System.out.println(path);
                File dir = new File(path + File.separatorChar + ze);
                dir.mkdirs();
            } else {
                // 获取文件名称
                String resultName = ze.getName();
//                if (ze.getName().lastIndexOf("/") >= 0) {
//                    resultName = ze.getName().substring((ze.getName().lastIndexOf("/") + 1), ze.getName().length());
//                }

                File createFile = new File(path + File.separatorChar + ze);
                if (!createFile.getParentFile().exists()) {
                    createFile.getParentFile().mkdirs();
                }

                createFile.createNewFile();
                // 将压缩文件内容写入到这个文件中
                InputStream is = zf.getInputStream(ze);
                FileOutputStream fos = new FileOutputStream(createFile);
                int len;
                byte[] buf = new byte[1024];
                while ((len = is.read(buf)) != -1) {
                    fos.write(buf, 0, len);
                }
                // 关流顺序，先打开的后关闭
                fos.close();
                is.close();
            }
        }
    }
}
