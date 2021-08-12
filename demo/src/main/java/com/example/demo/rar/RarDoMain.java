package com.example.demo.rar;

import com.github.junrar.Archive;
import com.github.junrar.exception.RarException;
import com.github.junrar.rarfile.BaseBlock;
import com.github.junrar.rarfile.FileHeader;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * @ClassName : RarDoMain  //类名
 * @Description :   //描述
 * @Author : lhy  //作者
 * @Date: 2020-04-16 15:08  //时间
 */
public class RarDoMain {

    public static void main(String[] args) throws IOException, RarException {
        unRar();

    }

    public static void unRar() throws IOException, RarException {
        String sourceRarPath = "/Users/lhy/Documents/44.rar";
        String destDirPath = "/Users/lhy/Documents/44";
        File sourceRar = new File(sourceRarPath);
        File destDir = new File(destDirPath);
        Archive archive = null;
        FileOutputStream fos = null;
        System.out.println("Starting 开始解压...");

        Stack<Map> stack = new Stack<>();
        try {
            archive = new Archive(sourceRar, null);
            FileHeader fh = archive.nextFileHeader();
            File destFileName = null;
            while (fh != null) {
                Map<String, String> map = new HashMap<>();
                String compressFileName = fh.getFileNameW().trim();
                compressFileName = compressFileName.replaceAll("\\\\", "/");
                if (fh.isDirectory()) {
                    if (compressFileName.indexOf("/") >= 0) {
                        compressFileName = compressFileName.substring((compressFileName.indexOf("/")+1), compressFileName.length());
                    }
                    fh.setFileNameW(compressFileName);
                    map.put("f_title", compressFileName);
                    map.put("f_path", destDirPath + File.separatorChar + compressFileName);
                    map.put("f_type", "directory");
                    map.put("f_size", fh.getFullPackSize() + "");
                    destFileName = new File(destDir.getAbsolutePath() + "/" + compressFileName);
                    if (!destFileName.exists()) {
                        destFileName.mkdirs();
                    }
                    stack.push(map);
                    fh = archive.nextFileHeader();

                    continue;
                }

                destFileName = new File(destDirPath + File.separatorChar + compressFileName);
                System.out.println(destFileName + "文件写入路径");
                String title = compressFileName.substring((compressFileName.lastIndexOf("/") + 1), compressFileName.lastIndexOf("."));
                fh.setFileNameW(title);
                map.put("f_title", title);
                map.put("f_path", destDirPath + File.separatorChar + compressFileName);
                String type = compressFileName.substring((compressFileName.lastIndexOf(".") + 1), compressFileName.length());
                map.put("f_type", type);
                map.put("f_size", fh.getFullPackSize() + "");
//                    if (fh.isDirectory()) {
//                        if (!destFileName.exists()) {
//                            destFileName.mkdirs();
//                        }
//                        fh = archive.nextFileHeader();
//                        continue;
//                    }
                if (!destFileName.getParentFile().exists()) {
                    destFileName.getParentFile().mkdirs();
                }


                fos = new FileOutputStream(destFileName);
                archive.extractFile(fh, fos);
                fos.close();
                fos = null;
                fh = archive.nextFileHeader();
                stack.push(map);
            }

            while (!stack.empty()) {
                Map<String, String> resultMap = stack.pop();
                System.out.println("文件名:" + resultMap.get("f_title"));
                System.out.println("地址:" + resultMap.get("f_path"));
                System.out.println("类型:" + resultMap.get("f_type"));
                System.out.println("大小:" + resultMap.get("f_size"));
            }

            archive.close();
            archive = null;
            System.out.println("Finished 解压完成!");
        } catch (Exception e) {
            throw e;
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                    fos = null;
                } catch (Exception e) {
                }
            }
            if (archive != null) {
                try {
                    archive.close();
                    archive = null;
                } catch (Exception e) {
                }
            }
        }
    }
}
