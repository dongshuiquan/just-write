package com.dsq.gui.layoutmanagement;

import javax.swing.*;
import java.awt.*;


public class GridBagLayoutDemo02 {

    public static void main(String[] args) {
        JFrame f=new JFrame("GridBagLayout");

        JPanel panel = new JPanel();

        panel.setLayout(new GridBagLayout());
        JLabel label =new JLabel("first : ", JLabel.RIGHT);
        GridBagConstraints gbc=new GridBagConstraints();
        //设定第一个单元格的属性值
        gbc.gridx=0;
        gbc.gridy=0;
        gbc.gridwidth=1;
        gbc.gridheight=1;
        gbc.weightx=0;
        gbc.weighty=0;
        gbc.anchor=GridBagConstraints.CENTER;
        gbc.fill=GridBagConstraints.BOTH;
        gbc.insets=new Insets(20,50,0,0);
        gbc.ipadx=0;
        gbc.ipady=0;
        panel.add(label,gbc);

        //设定第二个单元格属性值
        gbc.gridx=1;
        gbc.gridy=0;
        gbc.gridwidth=GridBagConstraints.REMAINDER;
        gbc.gridheight=1;
        gbc.weightx=1;
        gbc.weighty=0;
        gbc.anchor=GridBagConstraints.CENTER;
        gbc.fill=GridBagConstraints.BOTH;
        gbc.insets=new Insets(20,0,0,0);
        gbc.ipadx=0;
        gbc.ipady=0;
        JTextField text=new JTextField(20);
        panel.add(text,gbc);

        //设定第三个单元格属性值
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        JButton btn=new JButton("three");
        buttonPanel.add(btn,gbc);


       f.setSize(400, 120);
       f.add(panel, BorderLayout.CENTER);
       f.add(buttonPanel, BorderLayout.SOUTH);
       f.setVisible(true);

       Toolkit toolkit = Toolkit.getDefaultToolkit();
       Dimension demension =  toolkit.getScreenSize();
       f.setLocation(demension.width / 2 - 200, demension.height / 2 - 100);

       f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}