package com.dsq.awt;

import javax.swing.*;
import java.awt.*;

/**
 * Created by DELL on 2017/10/4.
 */
public class BoxExam {
    private Frame f = new Frame();
    private Box horizontal = Box.createHorizontalBox();
    private Box vertical = Box.createVerticalBox();
    public void init() {
        horizontal.add(new Button("h1"));
        horizontal.add(new Button("h2"));
        vertical.add(new Button("v1"));
        vertical.add(new Button("v2"));
        f.add(horizontal, BorderLayout.NORTH);
        f.add(vertical);
        f.pack();
        f.setVisible(true);
    }

    public static void main(String[] args) {
        new BoxExam().init();
    }
}
