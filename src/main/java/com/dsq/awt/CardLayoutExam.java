package com.dsq.awt;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by DELL on 2017/10/4.
 */
public class CardLayoutExam {
    Frame f = new Frame("测试窗口");
    String[] names = {"first", "second", "third", "fouth", "fi"};
    Panel p1 = new Panel();
    CardLayout c;
    public void init() {
        c = new CardLayout();
        p1.setLayout(c);
        for(String name : names) {
            p1.add(name, new Button(name));
        }
        Panel p = new Panel();
        ActionListener actionListener = (e) -> {
            switch (e.getActionCommand()) {
                case "pre":
                    c.previous(p1);
                    break;
                case "next":
                    c.next(p1);
                    break;
                case "first":
                    c.first(p1);
                    break;
                case "last":
                    c.last(p1);
                    break;
                case "third":
                    c.show(p1, "third");
                    break;
                default:
                    break;
            }
        };
        Button previous = new Button("pre");
        previous.addActionListener(actionListener);
        Button next = new Button("next");
        next.addActionListener(actionListener);
        Button first = new Button("first");
        first.addActionListener(actionListener);
        Button last = new Button("last");
        last.addActionListener(actionListener);
        Button third = new Button("third");
        third.addActionListener(actionListener);
        p.add(previous);
        p.add(next);
        p.add(first);
        p.add(last);
        p.add(third);
        f.add(p1);
        f.add(p, BorderLayout.SOUTH);
        f.pack();
        f.setVisible(true);
    }

    public void loop() {
        while (true) {
            c.next(p1);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        CardLayoutExam exam = new CardLayoutExam();
        exam.init();
        exam.loop();
    }
}
