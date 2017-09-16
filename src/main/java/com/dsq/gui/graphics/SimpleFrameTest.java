package com.dsq.gui.graphics;

import javax.swing.*;
import java.awt.*;

/**
 * Created by DELL on 2017/7/1.
 */
public class SimpleFrameTest
{
    public static void main(String[] args){
        EventQueue.invokeLater(() ->{
            //SimpleFrame simpleFrame = new SimpleFrame();
            SimpleFrame simpleFrame = new SimpleFrame("MyFrame");
            simpleFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            simpleFrame.setVisible(true);

        });
    }
}

class SimpleFrame extends JFrame{
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;

    public SimpleFrame(){
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        //setTitle("MyFrame");
        //setLocationByPlatform(true);
        //setBounds(800, 400, DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }
    public SimpleFrame(String title){
        super(title);
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }
}
