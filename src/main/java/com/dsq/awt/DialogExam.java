package com.dsq.awt;

import java.awt.*;

/**
 * Created by DELL on 2017/10/4.
 */
public class DialogExam {
    Frame f = new Frame();
    Dialog d1 = new Dialog(f, "mode", true);
    Dialog d2 = new Dialog(f, "not mode", false);
    Button b1 = new Button("mode");
    Button b2 = new Button("not mode");

    public void init() {
        d1.setBounds(20, 30, 300, 400);
        d2.setBounds(20, 30, 300, 400);
        b1.addActionListener( e -> d1.setVisible(true));
        b2.addActionListener( e -> d2.setVisible(true));
        f.add(b1);
        f.add(b2, BorderLayout.SOUTH);
        f.pack();
        f.setVisible(true);
    }

    public static void main(String[] args) {
        new DialogExam().init();
    }
}
