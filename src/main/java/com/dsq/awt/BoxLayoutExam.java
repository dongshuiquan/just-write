package com.dsq.awt;

import javax.swing.*;
import java.awt.*;

/**
 * Created by DELL on 2017/10/4.
 */
public class BoxLayoutExam {
    private Frame f = new Frame();
    public void init() {
        f.setLayout(new BoxLayout(f, BoxLayout.Y_AXIS));
        f.add(new Button("first"));
        f.add(new Button("second"));
        f.pack();
        f.setVisible(true);
    }

    public static void main(String[] args) {
        new BoxLayoutExam().init();
    }
}
