package com.dsq.gui.graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by DELL on 2017/9/17.
 */
public class JTabbelTest {

    public static void main(String[] args) {
        JFrame jFrame = new JFrame("test");

        MouseListener mouseListener = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
                System.out.println(e.getSource());
                try {
                    Robot robot = new Robot();

                    robot.mouseMove(e.getXOnScreen(), e.getYOnScreen() - 100);
                } catch (AWTException e1) {
                    e1.printStackTrace();
                }

                System.out.println(e);
            }
        };

        JTabbedPane jTabbedPane = new JTabbedPane();
        jTabbedPane.setTabPlacement(JTabbedPane.TOP);
        JPanel panel = new JPanel();
        JPanel panel2 = new JPanel();
        panel.addMouseListener(mouseListener);
        panel2.addMouseListener(mouseListener);

        jTabbedPane.addTab("1", panel);
        jTabbedPane.addTab("2", panel2);

        jFrame.add(jTabbedPane);
        jFrame.setVisible(true);
        jFrame.setSize(400, 300);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLocationRelativeTo(null);
    }
}
