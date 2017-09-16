package com.dsq.gui.layoutmanagement;

import javax.swing.*;
import java.awt.*;


public class GridBagLayoutDemo03 extends JFrame{

    JLabel label;
    JTextField textField;
    JButton button;
    public static void main(String[] args) {
        new GridBagLayoutDemo03();
    }

    public GridBagLayoutDemo03() throws HeadlessException {
          setLayout(new GridBagLayout());

          this.label = new JLabel("aaaaaaaaaaa :", JLabel.RIGHT);
          //label.setSize(30, 20);
          this.textField = new JTextField(15);
          //textField.
          this.button = new JButton("确定");
          add(new JLabel("  "), new GBC(0, 0));
          add(label, new GBC(0, 1).setAnchor(GBC.EAST).setInsets(1).setWeight(100, 0).setFill(GBC.BOTH));
          add(textField, new GBC(1, 1).setAnchor(GBC.WEST).setInsets(1).setWeight(100, 100).setFill(GBC.HORIZONTAL));
          add(button, new GBC(0, 2, 2, 1).setAnchor(GBC.CENTER).setWeight(100, 100));

          setSize(300, 130);
          setVisible(true);
          setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}