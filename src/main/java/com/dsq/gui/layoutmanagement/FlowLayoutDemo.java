package com.dsq.gui.layoutmanagement;

import javax.swing.*;
import java.awt.*;

/**
 * Created by DELL on 2017/7/20.
 */
public class FlowLayoutDemo {

    public static void main(String[] args) {
        JFrame f=new JFrame("FlowLayout");
        f.setLayout(new FlowLayout());
        for(int i=0;i<7;i++){
            JButton btn=new JButton("Button"+i);
            f.add(btn);
        }
        f.setSize(400,150);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}