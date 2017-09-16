package com.dsq.gui.layoutmanagement;

import javax.swing.*;
import java.awt.*;

/**
 * Created by DELL on 2017/7/20.
 */
public class BorderFrame02 extends JFrame{

    public static void main(String[] args) {
        new BorderFrame02();
    }
    public BorderFrame02() throws HeadlessException {
        super("BoderLayout");
        init();
        pack();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void init(){
        setLayout(new BorderLayout(10, 10));
        JButton btn=new JButton("BorderLayout.NORTH");
        add(btn,BorderLayout.NORTH);
        btn=new JButton("BorderLayout.SOUTH");
        add(btn, BorderLayout.SOUTH);
        btn=new JButton("BorderLayout.EAST");
        add(btn,BorderLayout.EAST);
        btn=new JButton("BorderLayout.West");
        add(btn,BorderLayout.WEST);
        btn=new JButton("BorderLayout.CENTER");
        add(btn,BorderLayout.CENTER);
    }
}
