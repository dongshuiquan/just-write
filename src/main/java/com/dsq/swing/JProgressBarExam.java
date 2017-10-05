package com.dsq.swing;

import javax.swing.*;
import java.awt.*;

/**
 * Created by DELL on 2017/10/4.
 */
public class JProgressBarExam {
    JFrame frame = new JFrame();
    JProgressBar bar = new JProgressBar(JProgressBar.VERTICAL);
    JCheckBox indeterminate = new JCheckBox("不确定进度");
    JCheckBox noBorder = new JCheckBox("不绘制边框");

    public void init() {
        Box box = new Box(BoxLayout.Y_AXIS);
        box.add(indeterminate);
        box.add(noBorder);
        frame.setLayout(new FlowLayout());
        frame.add(box);
        frame.add(bar);
        bar.setMinimum(0);
        bar.setMaximum(1000);
        bar.setStringPainted(true);
        noBorder.addActionListener(e -> bar.setBorderPainted(indeterminate.isSelected()));
        indeterminate.addActionListener(e -> {
            bar.setIndeterminate(indeterminate.isSelected());
            bar.setStringPainted(!indeterminate.isSelected());
        });
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        for(int i = 0; i <= 100; i++) {
            bar.setValue(i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new JProgressBarExam().init();
    }
}
