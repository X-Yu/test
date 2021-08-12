package com.example.demo.conevrt;


import com.spire.pdf.PdfDocument;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Iterator;

/**
 * @ClassName : pdfToImg  //类名
 * @Description :   //描述
 * @Author : lhy  //作者
 * @Date: 2020-05-22 14:44  //时间
 */
public class pdfToImg {

    public static void main(String[] args) throws IOException {

        generate("/Applications/baiducloud/1");
//        wordgenerate("","");
    }

    public static void generate( String outputFile) throws IOException {
        String inputFile = "/Users/lhy/Desktop/测试/Netty权威指南 PDF电子书下载 带目录书签 完整版.pdf";
        String outputPath = "/Users/lhy/Desktop/测试/output";

        //Open pdf document
        PdfDocument doc = new PdfDocument();
        doc.loadFromFile(inputFile);

        //Save to images
        BufferedImage image;
            image = doc.saveAsImage(0);
            File file = new File(outputPath + "/" + String.format(("ToImage-img-%d.png"), 0));
            ImageIO.write(image, "PNG", file);

        doc.close();
    }


}
