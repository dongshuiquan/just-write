package com.dsq.awt;

import java.awt.*;

/**
 * Created by DELL on 2017/10/4.
 */
public class BorderLayoutExam {
    public static void main(String[] args) {
        Frame f = new Frame("测试窗口");
        f.setLayout(new BorderLayout(30, 5));
        f.add(new Button("south"), BorderLayout.SOUTH);
        f.add(new Button("north"), BorderLayout.NORTH);
        f.add(new Button("west"), BorderLayout.WEST);
        f.add(new Button("east"), BorderLayout.EAST);
        f.pack();
        f.setVisible(true);
    }
}
