package com.example.demo.conevrt;

import com.spire.pdf.FileFormat;
import com.spire.pdf.PdfDocument;

/**
 * @ClassName : PdfToDoc  //类名
 * @Description :   //描述
 * @Author : lhy  //作者
 * @Date: 2020-11-05 11:17  //时间
 */
public class PdfToDoc {
    public static void main(String[] args) {
        String input = "/Users/lhy/Documents/file/招商证券项目规划与管理系统.pdf";
        String output = "/Users/lhy/Documents/file/招商证券项目规划与管理系统.doc";

        //Load a pdf document
        PdfDocument doc = new PdfDocument();
        doc.loadFromFile(input);

        //Convert to doc file.
        doc.saveToFile(output, FileFormat.DOC);
        doc.close();
    }
}
