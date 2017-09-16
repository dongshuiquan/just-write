package com.dsq.gui.layoutmanagement;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JButton;


public class BoxLayoutDemo {

    public static void main(String[] args) {
        JFrame f=new JFrame("BoxLayout");
        //创建水平Box组件
        Box box=Box.createHorizontalBox();
        JButton btnA=new JButton("A");
        JButton btnB=new JButton("B");
        box.add(btnA);
        box.add(Box.createHorizontalStrut(50));
        box.add(btnB);
        f.add(box);

        f.pack();

        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}