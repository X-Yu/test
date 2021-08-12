package com.example.demo.conevrt;

import com.spire.xls.ExcelVersion;
import com.spire.xls.Workbook;
import com.spire.xls.Worksheet;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @ClassName : excelToImg  //类名
 * @Description :   //描述
 * @Author : lhy  //作者
 * @Date: 2020-05-22 17:59  //时间
 */
public class excelToImg {
    public static void main(String[] args) throws IOException {
        Workbook workbook = new Workbook();
        workbook.loadFromFile("/Users/lhy/Documents/测试/平安用例.xls");
        //Get the first sheet
        Worksheet sheet = workbook.getWorksheets().get(0);

        //Add an image to the specific cell
//        sheet.getPictures().add(15, 8,"/Users/lhy/Documents/SpireXls.png");

        //Save the result file
//        workbook.saveToFile("/Users/lhy/Documents/output/WriteImages.xlsx", ExcelVersion.Version2010);

//        String inputFile = "data/ExcelSampleN.xlsx";
        String outputFile="/Users/lhy/Documents/测试/output/SheetToImage.png";

        //Create a workbook and load a file
//        workbook.loadFromFile(inputFile);

        //Get the first worksheet

        //Save the sheet to image
        BufferedImage bufferedImage = sheet.toImage(sheet.getFirstRow(), sheet.getFirstColumn(), sheet.getLastRow(), sheet.getLastColumn());
        ImageIO.write(bufferedImage,"PNG",new File(outputFile));
    }


}
