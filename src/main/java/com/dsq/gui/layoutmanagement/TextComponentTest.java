package com.dsq.gui.layoutmanagement;

import javax.swing.*;
import java.awt.*;

/**
 * Created by DELL on 2017/7/2.
 */
public class TextComponentTest extends JFrame{

    public static final int TEXTAREA_ROWS = 8;
    public static final int TEXTAREA_COLUMNS = 20;

    public static void main(String[] args){
        TextComponentTest textComponentTest = new TextComponentTest();
        textComponentTest.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        textComponentTest.pack();
        textComponentTest.setVisible(true);
    }
    public TextComponentTest() {
        JTextField textField = new JTextField();
        JPasswordField passwordField = new JPasswordField();

        JPanel northPanel = new JPanel();
        northPanel.setLayout(new GridLayout(2, 2));
        northPanel.add(new JLabel("User name: ", SwingConstants.RIGHT ));
        northPanel.add(textField);
        northPanel.add(new JLabel("Password: ", SwingConstants.RIGHT));
        northPanel.add(passwordField);
        add(northPanel, BorderLayout.NORTH);

        JTextArea textArea = new JTextArea(TEXTAREA_ROWS, TEXTAREA_COLUMNS);
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);

        JPanel southPanel = new JPanel();
        JButton insertButton = new JButton("Insert");
        southPanel.add(insertButton);
        insertButton.addActionListener(event ->{
            textArea.append("User name: " + textField.getText() + "  Password: " + new String(passwordField.getPassword()) + "\n");
        });
        add(southPanel, BorderLayout.SOUTH);
    }
}
