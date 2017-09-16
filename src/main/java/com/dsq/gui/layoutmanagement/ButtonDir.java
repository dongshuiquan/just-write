package com.dsq.gui.layoutmanagement;

import javax.swing.*;
import java.applet.Applet;
import java.awt.*;

/**
 * Created by DELL on 2017/7/20.
 */
public class ButtonDir extends JFrame {

    public static void main(String[] args) {
        ButtonDir buttonDir =  new ButtonDir();
        buttonDir.setSize(400, 400);
        buttonDir.init();
        //buttonDir.pack();
        buttonDir.setVisible(true);
    }

    public void init() {
        setLayout(new BorderLayout());
        add(new Button("North"), BorderLayout.NORTH);
        add(new Button("South"), BorderLayout.SOUTH);
        add(new Button("East"), BorderLayout.EAST);
        add(new Button("West"), BorderLayout.WEST);
        add(new Button("Center"), BorderLayout.CENTER);
    }
}
