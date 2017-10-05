package com.dsq.awt;

import java.awt.*;

/**
 * Created by DELL on 2017/10/4.
 */
public class FlowLayoutExam {
    public static void main(String[] args) {
        Frame f = new Frame("测试窗口");
        f.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 5));
        for(int i = 0; i < 10; i++) {
            f.add(new Button("button " + i));
        }
        f.pack();
        f.setVisible(true);
    }
}
