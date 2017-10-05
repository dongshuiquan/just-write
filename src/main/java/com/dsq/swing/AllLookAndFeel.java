package com.dsq.swing;

import javax.swing.*;

/**
 * Created by DELL on 2017/10/4.
 */
public class AllLookAndFeel {
    public static void main(String[] args) {
        for(UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
            System.out.println(info.getName() + "--->" + info);
        }
    }
}
