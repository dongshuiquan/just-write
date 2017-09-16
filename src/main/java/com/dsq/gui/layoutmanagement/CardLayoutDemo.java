package com.dsq.gui.layoutmanagement;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;


public class CardLayoutDemo {

    private static JPanel p;
    public static void main(String[] args) {
        JFrame f=new JFrame("CardLayout");
        p=new JPanel();
        //将JPanel p的LayoutManager设置为CardLayout
        p.setLayout(new CardLayout());

        //新建两个JPanel
        JPanel p1=new JPanel();
        JPanel p2=new JPanel();
        JLabel lb=new JLabel("first panel");
        p1.add(lb);
        lb=new JLabel("second panel");
        p2.add(lb);

        //将新建的两个JPanel p1,p2添加到p中
        p.add(p1,"frist");
        p.add(p2,"second");

        //设置默认显示first所对应的JPanel p1
        ((CardLayout)p.getLayout()).show(p, "frist");

        JButton cbtn=new JButton("Change");
        cbtn.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent e) {
                //当按下Change按钮时，显示second 对应的JPanel p2
                ((CardLayout)p.getLayout()).show(p, "second");
            }

        });
        f.add(cbtn,BorderLayout.NORTH);
        f.add(p,BorderLayout.CENTER);
        f.setSize(400,150);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}