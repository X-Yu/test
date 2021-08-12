package com.example.demo.poi;

import com.example.demo.cacheline;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;

import java.awt.*;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @ClassName : DoMain  //类名
 * @Description :   //描述
 * @Author : lhy  //作者
 * @Date: 2021-03-08 16:44  //时间
 */
public class DoMain {
    public static void main(String[] args) {
        FileOutputStream fos = null;
        HSSFWorkbook workbook = null;
        try {
            fos = new FileOutputStream("/Users/lhy/Desktop/模板.xlsx");
            workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet("项目人员");

            HSSFCellStyle style = workbook.createCellStyle();
            style.setAlignment(HorizontalAlignment.CENTER);
            style.setVerticalAlignment(VerticalAlignment.CENTER);
            HSSFFont font = workbook.createFont();
            font.setBold(true);
            style.setFont(font);

            HSSFCellStyle style2 = workbook.createCellStyle();
            style2.setFont(font);

            HSSFCellStyle style3 = workbook.createCellStyle();
            style3.setAlignment(HorizontalAlignment.RIGHT);
            style3.setFont(font);

            HSSFCellStyle style4 = workbook.createCellStyle();
            style4.setAlignment(HorizontalAlignment.CENTER);
            style4.setVerticalAlignment(VerticalAlignment.CENTER);

            HSSFRow titlerow = sheet.createRow(0);
            titlerow.setRowStyle(style);

            HSSFCell c0 = titlerow.createCell(0);
            c0.setCellStyle(style);
            c0.setCellValue("自主研发“研发支出”辅助账");
            sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 32));

            HSSFRow twoRow = sheet.createRow(1);


            HSSFCell c1 = twoRow.createCell(0);
            sheet.addMergedRegion(new CellRangeAddress(1, 1, 0, 1));
            c1.setCellStyle(style2);
            c1.setCellValue("项目名称：");


            HSSFCell c1_v = twoRow.createCell(2);
            sheet.addMergedRegion(new CellRangeAddress(1, 1, 2, 4));
            c1_v.setCellValue("XXXXX名称");

            HSSFCell c1_2 = twoRow.createCell(5);
            sheet.addMergedRegion(new CellRangeAddress(1, 1, 5, 6));
            c1_2.setCellValue("项目编号：");
            c1_2.setCellStyle(style2);

            HSSFCell c1_2_v = twoRow.createCell(7);
            sheet.addMergedRegion(new CellRangeAddress(1, 1, 7, 9));
            c1_2_v.setCellValue("XXX编号：");

            HSSFCell c1_3 = twoRow.createCell(10);
            sheet.addMergedRegion(new CellRangeAddress(1, 1, 10, 11));
            c1_3.setCellValue("资本化、费用化支出选项：");
            c1_3.setCellStyle(style2);

            HSSFCell c1_3_v = twoRow.createCell(12);
            sheet.addMergedRegion(new CellRangeAddress(1, 1, 12, 14));
            c1_3_v.setCellValue("XXXX元");

            HSSFCell c1_4 = twoRow.createCell(15);
            sheet.addMergedRegion(new CellRangeAddress(1, 1, 15, 16));
            c1_4.setCellValue("项目实施状态选项：");
            c1_4.setCellStyle(style2);


            HSSFCell c1_4_v = twoRow.createCell(17);
            sheet.addMergedRegion(new CellRangeAddress(1, 1, 17, 18));
            c1_4_v.setCellValue("未完成");

            HSSFCell c1_5 = twoRow.createCell(19);
            sheet.addMergedRegion(new CellRangeAddress(1, 1, 19, 20));
            c1_5.setCellValue("研发成果：");
            c1_5.setCellStyle(style2);

            HSSFCell c1_5_v = twoRow.createCell(21);
            sheet.addMergedRegion(new CellRangeAddress(1, 1, 21, 22));
            c1_5_v.setCellValue("xxx成果");

            HSSFCell c1_6 = twoRow.createCell(23);
            sheet.addMergedRegion(new CellRangeAddress(1, 1, 23, 24));
            c1_6.setCellValue("研发成果证书号：");


            HSSFCell c1_6_v = twoRow.createCell(25);
            sheet.addMergedRegion(new CellRangeAddress(1, 1, 25, 27));
            c1_6_v.setCellValue("XXX证书号：");

            HSSFCell c1_7 = twoRow.createCell(28);
            sheet.addMergedRegion(new CellRangeAddress(1, 1, 28, 32));
            c1_7.setCellStyle(style3);
            c1_7.setCellValue("金额单位：元（列至角分）：");

            HSSFRow threeRow = sheet.createRow(2);


            HSSFRow fourRow = sheet.createRow(3);

            HSSFRow fiveRow = sheet.createRow(4);

            HSSFRow sixRow = sheet.createRow(5);

            HSSFRow sevenRow = sheet.createRow(6);

            HSSFRow eightRow = sheet.createRow(7);

            HSSFCell three_c_0 = threeRow.createCell(0);
            sheet.addMergedRegion(new CellRangeAddress(2, 2, 0, 1));
            three_c_0.setCellStyle(style4);
            three_c_0.setCellValue("2019");

            sheet.addMergedRegion(new CellRangeAddress(2, 3, 2, 2));
            HSSFCell three_c_1 = threeRow.createCell(2);
            three_c_1.setCellValue("凭证");
            three_c_1.setCellStyle(style4);

            sheet.addMergedRegion(new CellRangeAddress(2, 5, 3, 3));
            HSSFCell three_c_2 = threeRow.createCell(3);
            three_c_2.setCellValue("摘要");
            three_c_2.setCellStyle(style4);

            sheet.addMergedRegion(new CellRangeAddress(2, 5, 4, 4));
            HSSFCell three_c_3 = threeRow.createCell(4);
            three_c_3.setCellValue("贷方金额");
            three_c_3.setCellStyle(style4);

            sheet.addMergedRegion(new CellRangeAddress(2, 5, 5, 5));
            HSSFCell three_c_4 = threeRow.createCell(5);
            three_c_4.setCellValue("借或贷");
            three_c_4.setCellStyle(style4);

            sheet.addMergedRegion(new CellRangeAddress(2, 5, 6, 6));
            HSSFCell three_c_5 = threeRow.createCell(6);
            three_c_5.setCellValue("余额");
            three_c_5.setCellStyle(style4);

            sheet.addMergedRegion(new CellRangeAddress(2, 2, 7, 32));
            HSSFCell c_6 = threeRow.createCell(7);
            c_6.setCellValue("费用明细（借方）");
            c_6.setCellStyle(style4);

            sheet.addMergedRegion(new CellRangeAddress(3, 3, 0, 1));
            HSSFCell four_c_0= fourRow.createCell(0);
            four_c_0.setCellStyle(style4);
            four_c_0.setCellValue("年");




            workbook.write(fos);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (workbook == null) {
                try {
                    workbook.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
