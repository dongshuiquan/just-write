package com.dsq.gui.layoutmanagement;

import javax.swing.*;
import java.awt.*;
import java.util.Date;

/**
 * Created by DELL on 2017/7/22.
 */
public class OptionDialogFrame extends JFrame {
    private ButtonPanel typePanel;
    private ButtonPanel messagePanel;
    private ButtonPanel messageTypePanel;
    private ButtonPanel optionTypePanel;
    private ButtonPanel optionsPanel;
    private ButtonPanel inputPanel;
    private String messageString = "Message";
    private Icon messageIcon = new ImageIcon("none");
    private Object messageObject = new Date();
    private Component messageComponent = new SampleComponent();

    public static void main(String[] args) {
        new OptionDialogFrame();
    }
    public OptionDialogFrame() throws HeadlessException {
        JPanel gridPanel = new JPanel();
        gridPanel.setLayout(new GridLayout(2, 3));

        typePanel = new ButtonPanel("Type", "Message", "Confirm", "Option", "Input");
        messageTypePanel = new ButtonPanel("Message Type", "Error_MESSAGE", "INFORMATION_MESSAGE",
                "WARNING_MESSAGE", "QUESTION_MESSAGE", "PLAIN_MESSAGE");
        messagePanel = new ButtonPanel("Message", "String", "Icon", "Component", "Other", "Object[]");
        optionTypePanel = new ButtonPanel("Confirm", "DEFAULT_OPTION", "YES_NO_OPTION",
                "YES_NO_CANCEL_OPTION", "OK_CANCEL_OPTION");
        optionsPanel = new ButtonPanel("Option", "String[]", "Icon", "Object[]");
        inputPanel = new ButtonPanel("Input", "Text field", "Combo box");

        gridPanel.add(typePanel);
        gridPanel.add(messageTypePanel);
        gridPanel.add(messagePanel);
        gridPanel.add(optionTypePanel);
        gridPanel.add(optionsPanel);
        gridPanel.add(inputPanel);

        JPanel showPanel = new JPanel();
        JButton showButton = new JButton("Show");
        //showButton.addActionListener(new ShowAction());
        showPanel.add(showButton);
        add(gridPanel, BorderLayout.CENTER);
        add(showPanel, BorderLayout.SOUTH);
        pack();
        setVisible(true);
    }

    public Object getMessage(){
        String s = messagePanel.getSelection();
        if(s.equals("String")) return messageString;
        else if(s.equals("Icon")) return messageIcon;
        else if(s.equals("Component")) return messageComponent;
        else if(s.equals("Object[]")) return new Object[]{messageString, messageIcon, messageComponent, messageObject};
        else if(s.equals("Other")) return messageObject;
        else return null;
    }
}

class ButtonPanel extends JPanel{
    private ButtonGroup group;

    public ButtonPanel(String title, String... options){
        setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), title));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        group = new ButtonGroup();
        for(String option : options){
            JRadioButton b = new JRadioButton(option);
            b.setActionCommand(option);
            add(b);
            group.add(b);
            b.setSelected(option == options[0]);
        }
    }

    public String getSelection(){
        return group.getSelection().getActionCommand();
    }
}

class SampleComponent extends JComponent{

}