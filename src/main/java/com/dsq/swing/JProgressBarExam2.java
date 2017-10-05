package com.dsq.swing;

import javax.swing.*;
import java.awt.*;

/**
 * Created by DELL on 2017/10/4.
 */
public class JProgressBarExam2 {
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
        bar.setMaximum(100);
        bar.setStringPainted(true);
        noBorder.addActionListener(e -> bar.setBorderPainted(indeterminate.isSelected()));
        SimulatedActivity target = new SimulatedActivity(100);
        new Thread(target).start();
        Timer timer = new Timer(300, e -> bar.setValue(target.getCurrent()));
        timer.start();
        indeterminate.addActionListener(e -> {
            bar.setIndeterminate(indeterminate.isSelected());
            bar.setStringPainted(!indeterminate.isSelected());
        });
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new JProgressBarExam2().init();
    }
}

class SimulatedActivity implements Runnable {
    private volatile int current;
    private int amount;

    public SimulatedActivity(int amount) {
        this.amount = amount;
        current = 0;
    }

    public int getCurrent() {
//        System.out.println(current);
        return current;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public void run() {
        while (current < amount) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            current++;
        }
    }
}