package com.dsq.awt;

import java.awt.*;

/**
 * Created by DELL on 2017/10/4.
 */
public class PanelTest {
    public static void main(String[] args) {
        Frame frame = new Frame("测试窗口");
        Panel panel = new Panel();
        panel.add(new TextField(20));
        panel.add(new Button("点击我"));
        frame.add(panel);
        frame.setVisible(true);
        frame.pack();
    }
}
