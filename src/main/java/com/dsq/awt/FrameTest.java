package com.dsq.awt;

import java.awt.*;

/**
 * Created by DELL on 2017/10/4.
 */
public class FrameTest {
    public static void main(String[] args) {
        Frame frame = new Frame("测试窗口");
        frame.setBounds(30, 30, 350, 200);
        frame.setVisible(true);
    }
}
