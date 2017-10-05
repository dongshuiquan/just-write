package com.dsq.awt;

import java.awt.*;

/**
 * Created by DELL on 2017/10/4.
 */
public class GridBagExam {
    private Frame f = new Frame("测试窗口");
    private GridBagLayout gb = new GridBagLayout();
    private GridBagConstraints gbc = new GridBagConstraints();
    private Button[] buttons = new Button[10];

    public void init() {
        f.setLayout(gb);
        for(int i = 0; i < buttons.length; i++) {
            buttons[i] = new Button("button" + i);
        }
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1;
        addButton(buttons[0]);
        addButton(buttons[1]);
        addButton(buttons[2]);
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        addButton(buttons[3]);
        gbc.weightx = 0;
        addButton(buttons[4]);
        gbc.gridwidth = 2;
        addButton(buttons[5]);
        gbc.gridwidth = 1;
        gbc.gridheight = 2;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        addButton(buttons[6]);
        gbc.gridwidth = 1;
        gbc.gridheight = 2;
        gbc.weighty = 1;
        addButton(buttons[7]);
        gbc.weighty = 1;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.gridheight = 1;
        addButton(buttons[8]);
        addButton(buttons[9]);
        gbc.gridheight = 1;
        addButton(new Button("10"));
        f.pack();
        f.setVisible(true);
    }

    private void addButton(Button button) {
        gb.setConstraints(button, gbc);
        f.add(button);
    }

    public static void main(String[] args) {
        new GridBagExam().init();
    }
}
