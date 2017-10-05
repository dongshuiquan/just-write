package com.dsq.awt;

import javax.imageio.ImageIO;

/**
 * Created by DELL on 2017/10/4.
 */
public class ImageIOTest {
    public static void main(String[] args) {
        String[] readFormat = ImageIO.getReaderFormatNames();
        for(String s : readFormat) {
            System.out.println(s);
        }
        System.out.println("======================");
        String[] writeFormat = ImageIO.getWriterFormatNames();
        for(String s : writeFormat) {
            System.out.println(s);
        }
    }
}
