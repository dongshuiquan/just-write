package com.dsq.gui.layoutmanagement;

import javax.swing.*;

/**
 * Created by DELL on 2017/7/2.
 */
public class CircleLayoutFrame extends JFrame{
    public CircleLayoutFrame(){
        setLayout(new CircleLayout());
        add(new JButton("Yellow"));
        add(new JButton("Blue"));
        add(new JButton("Red"));
        add(new JButton("Green"));
        add(new JButton("Orange"));
        add(new JButton("Fuchsia"));
        add(new JButton("Indigo"));

        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
//        pack();
    }

    public static void main(String[] args){
        new CircleLayoutFrame();
    }
}
