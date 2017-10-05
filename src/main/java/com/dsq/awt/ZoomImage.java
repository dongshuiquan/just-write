package com.dsq.awt;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by DELL on 2017/10/4.
 */
public class ZoomImage {
    private final int WIDTH = 80;
    private final int HEIGTH = 60;
    BufferedImage image = new BufferedImage(WIDTH, HEIGTH, BufferedImage.TYPE_INT_RGB);
    Graphics g = image.getGraphics();

    public void zoom() throws IOException {
        Image srcImage = ImageIO.read(new File("icon.gif"));
        g.drawImage(srcImage, 0, 0, WIDTH, HEIGTH, null);
        ImageIO.write(image, "jpeg", new File(System.currentTimeMillis() + ".jpg"));
    }

    public static void main(String[] args) throws IOException {
        new ZoomImage().zoom();
    }
}
