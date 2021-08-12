package com.example.demo.conevrt;

import com.spire.presentation.Presentation;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * @ClassName : pptToImg  //类名
 * @Description :   //描述
 * @Author : lhy  //作者
 * @Date: 2020-05-25 11:42  //时间
 */
public class pptToImg {
    public static void main(String[] args) throws Exception {
        String inputFile ="/Users/lhy/Desktop/测试/测试PPT.pptx";
        String outputFile="/Users/lhy/Desktop/测试/output";
        Presentation ppt = new Presentation();
        ppt.loadFromFile(inputFile);
        //Save PPT document to images
            BufferedImage image = ppt.getSlides().get(0).saveAsImage();
            String fileName = outputFile + "/" + String.format("pptToImage-%1$s.png", 0);
            ImageIO.write(image, "PNG",new File(fileName));
        ppt.dispose();
    }
}
