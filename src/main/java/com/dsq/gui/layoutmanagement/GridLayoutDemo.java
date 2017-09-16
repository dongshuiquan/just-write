package com.dsq.gui.layoutmanagement;

import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JButton;


public class GridLayoutDemo {

    public static void main(String[] args) {
        JFrame f=new JFrame("GridLayout");
        //设置f的布局管理器为3行3列的GridLayout,组件间水平与垂直间距为5
        f.setLayout(new GridLayout(3,3,5,5));
        for(int i=1;i<10;i++){
            JButton btn=new JButton(String.valueOf(i));
            f.add(btn);
        }
        f.pack();
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}