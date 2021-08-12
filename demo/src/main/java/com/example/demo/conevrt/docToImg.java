package com.example.demo.conevrt;

import com.spire.doc.Document;
import com.spire.doc.documents.ImageType;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @ClassName : docToImg  //类名
 * @Description : doc转换图片  //描述
 * @Author : lhy  //作者
 * @Date: 2020-05-25 11:25  //时间
 */
public class docToImg {
    public static void main(String[] args) throws IOException {
        String input = "/Users/lhy/Desktop/测试/绘本备课.doc";
        String output = "/Users/lhy/Desktop/测试/output/toImage.png";

        //load Word document
        Document document= new Document();
        document.loadFromFile(input);

        //save to images
        BufferedImage image= document.saveToImages(0, ImageType.Bitmap);
        File file= new File(output);
        ImageIO.write(image, "PNG", file);
    }
}
