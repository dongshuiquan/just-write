package com.dsq.gui.layoutmanagement;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

/**
 * Created by DELL on 2017/7/7.
 */
public class MigLayoutTest {
    public static void main(String[] args){
        JPanel panel = new JPanel(new MigLayout("debug", "[right]"));
        panel.add(new JLabel("General"), "split, span, gaptop 10");
        panel.add(new JSeparator(), "growx, wrap, gaptop 10");

        panel.add(new JLabel("Company"), "gap 10");
        panel.add(new JTextField(""), "span, growx");
        panel.add(new JLabel("Contact"), "gap 10");
        panel.add(new JTextField(""), "span, growx, wrap");

        panel.add(new JLabel("Propeller"), "split, span, gaptop 10");
        panel.add(new JSeparator(), "growx, wrap, gaptop 10");

        panel.add(new JLabel("PTI/kW"), "gap 10");
        panel.add(new JTextField(10), "");
        panel.add(new JLabel("Power/kW"), "gap 10");
        panel.add(new JTextField(10), "wrap");
        panel.add(new JLabel("R/mm"), "gap 10");
        panel.add(new TextField(10), "");
        panel.add(new JLabel("D/mm"), "gap 10");
        panel.add(new JTextField(10), "");

        JFrame frame = new JFrame("MigLayouTest");
        frame.add(panel);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
