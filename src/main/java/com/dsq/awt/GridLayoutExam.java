package com.dsq.awt;

import java.awt.*;

/**
 * Created by DELL on 2017/10/4.
 */
public class GridLayoutExam {
    public static void main(String[] args) {
        Frame f = new Frame("计算器");
        Panel p1 = new Panel();
        p1.add(new TextField(30));
        f.add(p1, BorderLayout.NORTH);
        Panel p2 = new Panel();
        p2.setLayout(new GridLayout(3, 5, 4, 4));
        String[] names = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
            "+", "-", "*", "/", "="};
        for(String name : names) {
            p2.add(new Button(name));
        }
        f.add(p2);
        f.pack();
        f.setVisible(true);
    }
}
