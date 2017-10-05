package com.dsq.awt;

import java.awt.*;

/**
 * Created by DELL on 2017/10/4.
 */
public class ScrollPaneExam {
    public static void main(String[] args) {
        Frame f = new Frame("测试窗口");
        ScrollPane sp = new ScrollPane(ScrollPane.SCROLLBARS_ALWAYS);
        sp.add(new TextField(20));
        sp.add(new Button("click me!"));
        f.add(sp);
        f.pack();
        f.setVisible(true);
    }
}
