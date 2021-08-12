package com.example.demo.poi;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @ClassName : AppendCloumn  //类名
 * @Description :   //描述
 * @Author : lhy  //作者
 * @Date: 2021-03-09 11:35  //时间
 */
public class AppendCloumn {


    public static void main(String[] args) throws IOException {
        add("/Users/lhy/Desktop/111.xls","/Users/lhy/Desktop/222.xls");
    }
    public static void add(String file,String outfile) throws IOException {

        FileInputStream fis = new FileInputStream(file);
        HSSFWorkbook wb = null;
        try {
            wb = new HSSFWorkbook(fis);
            HSSFSheet sheet = wb.getSheetAt(0);
            HSSFRow two_row = sheet.getRow(1);
            two_row.createCell(2).setCellValue("项目名称为XXXX");

        } catch (IOException e) {
            e.printStackTrace();
        }

        FileOutputStream fos = new FileOutputStream(outfile);
        try {
            fos.flush();
            wb.write(fos);

        } catch (IOException e) {
            e.printStackTrace();
        }
        if (wb != null) {
            try {
                wb.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (fos != null) {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (fis != null) {
            fis.close();
        }

    }

}
