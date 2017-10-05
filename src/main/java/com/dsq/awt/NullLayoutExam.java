package com.dsq.awt;

import java.awt.*;

/**
 * Created by DELL on 2017/10/4.
 */
public class NullLayoutExam {
    Frame f = new Frame();
    Button b1 = new Button("first");
    Button b2 = new Button("second");
    public void init() {
        f.setLayout(null);
        b1.setBounds(20, 30, 90, 30);
        b2.setBounds(30, 45, 120, 40);
        f.add(b1);
        f.add(b2);
        f.setBounds(50, 50, 200, 100);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        new NullLayoutExam().init();
    }
}
