package com.dsq.swing;

import javax.swing.*;
import java.awt.*;

/**
 * Created by DELL on 2017/10/4.
 */
public class SwingDndSupport {
    JFrame f = new JFrame();
    JTextField textField = new JTextField(34);
    JTextArea srcTextArea = new JTextArea(8, 30);

    public void init() {
        srcTextArea.append("Swing 的拖放支持");
        textField.setDragEnabled(true);
        f.add(new JScrollPane(srcTextArea));
        f.add(textField, BorderLayout.SOUTH);
        f.pack();
        f.setVisible(true);
    }

    public static void main(String[] args) {
        new SwingDndSupport().init();
    }
}
