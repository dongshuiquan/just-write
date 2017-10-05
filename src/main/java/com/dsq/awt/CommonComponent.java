package com.dsq.awt;

import javax.swing.*;
import java.awt.*;

/**
 * Created by DELL on 2017/10/4.
 */
public class CommonComponent {
    Frame f = new Frame();
    Button ok = new Button("ok");
    CheckboxGroup checkboxGroup = new CheckboxGroup();
    Checkbox male = new Checkbox("male", checkboxGroup, true);
    Checkbox female = new Checkbox("female", checkboxGroup, false);
    Checkbox married = new Checkbox("married", false);
    Choice colorChooser = new Choice();
    List colorList = new List(6, false);
    TextArea textArea = new TextArea(6, 20);
    TextField name = new TextField(50);

    public void init() {
        colorChooser.add("red");
        colorChooser.add("green");
        colorChooser.add("blue");
        colorList.add("red");
        colorList.add("green");
        colorList.add("blue");
        Panel bottom = new Panel();
        bottom.add(name);
        bottom.add(ok);
        f.add(bottom, BorderLayout.SOUTH);
        Panel checkPanel = new Panel();
        checkPanel.add(colorChooser);
        checkPanel.add(male);
        checkPanel.add(female);
        checkPanel.add(married);

        Box topLeft = Box.createVerticalBox();
        topLeft.add(textArea);
        topLeft.add(checkPanel);

        Box top = Box.createHorizontalBox();
        top.add(topLeft);
        top.add(colorList);

        f.add(top);
        f.pack();
        f.setVisible(true);
    }

    public static void main(String[] args) {
        new CommonComponent().init();
    }
}
