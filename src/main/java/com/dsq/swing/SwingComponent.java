package com.dsq.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;

/**
 * Created by DELL on 2017/10/4.
 */
public class SwingComponent {
    JFrame f = new JFrame();
    Icon okIcon = new ImageIcon("icon.gif");
    JButton ok = new JButton("确认");
    JRadioButton male = new JRadioButton("男",true);
    JRadioButton female = new JRadioButton("女",false);
    ButtonGroup buttonGroup = new ButtonGroup();
    JCheckBox married = new JCheckBox("是否已婚", false);
    String[] colors = new String[]{"红色", "绿色", "蓝色"};
    JComboBox<String> colorChooser = new JComboBox<>(colors);
    JList<String> colorList = new JList<>(colors);
    JTextArea textArea = new JTextArea(8, 20);
    JTextField name = new JTextField(40);
    JMenuBar menuBar = new JMenuBar();
    JMenu file = new JMenu("文件");
    JMenu edit = new JMenu("编辑");
    Icon newIcon = new ImageIcon("icon.gif");
    JMenuItem newItem = new JMenuItem("新建", newIcon);
    JMenuItem saveItem = new JMenuItem("保存", newIcon);
    JMenuItem exitItem = new JMenuItem("退出", newIcon);
    JCheckBoxMenuItem autoWrap = new JCheckBoxMenuItem("自动换行");
    JMenuItem copyItem = new JMenuItem("复制");
    JMenuItem pasteItem = new JMenuItem("粘贴");
    JMenu format = new JMenu("格式");
    JMenuItem commenItem = new JMenuItem("注释");
    JMenuItem cancelItem = new JMenuItem("取消注释");
    JPopupMenu pop = new JPopupMenu();
    ButtonGroup flavorGroup = new ButtonGroup();
    JRadioButtonMenuItem metalItem = new JRadioButtonMenuItem("Metal 风格", true);
    JRadioButtonMenuItem nimbusItem = new JRadioButtonMenuItem("Nimbus 风格");
    JRadioButtonMenuItem windowsItem = new JRadioButtonMenuItem("Windows 风格");
    JRadioButtonMenuItem classicItem = new JRadioButtonMenuItem("Windows 经典风格");
    JRadioButtonMenuItem motifItem = new JRadioButtonMenuItem("Motif 风格");

    public void init() {
        JPanel bottom = new JPanel();
        bottom.add(name);
        bottom.add(ok);
        f.add(bottom, BorderLayout.SOUTH);

        JPanel checkPanel = new JPanel();
        checkPanel.add(colorChooser);
        buttonGroup.add(male);
        buttonGroup.add(female);
        checkPanel.add(male);
        checkPanel.add(female);
        checkPanel.add(married);

        Box topLeft = Box.createVerticalBox();
        JScrollPane taJsp = new JScrollPane(textArea);
        topLeft.add(taJsp);
        topLeft.add(checkPanel);

        Box top =  Box.createHorizontalBox();
        top.add(topLeft);
        top.add(colorList);
        f.add(top);

        newItem.setAccelerator(KeyStroke.getKeyStroke('N', InputEvent.CTRL_MASK));
        newItem.addActionListener(e -> textArea.append("用户单击了\"新建\"菜单\n"));
        file.add(newItem);
        file.add(saveItem);
        file.add(exitItem);

        edit.add(autoWrap);
        edit.addSeparator();
        edit.add(copyItem);
        edit.add(pasteItem);
        commenItem.setToolTipText("将程序代码注释起来!");
        format.add(commenItem);
        format.add(cancelItem);
        edit.add(new JMenuItem("-"));
        edit.add(format);
        menuBar.add(file);
        menuBar.add(edit);

        f.setJMenuBar(menuBar);

        flavorGroup.add(metalItem);
        flavorGroup.add(nimbusItem);
        flavorGroup.add(windowsItem);
        flavorGroup.add(classicItem);
        flavorGroup.add(motifItem);
        pop.add(metalItem);
        pop.add(nimbusItem);
        pop.add(windowsItem);
        pop.add(classicItem);
        pop.add(motifItem);
        ActionListener flavorListener = e -> {
          switch (e.getActionCommand()) {
              case "Metal 风格":
                  changeFlavor(1);
                  break;
              case "Nimbus 风格":
                  changeFlavor(2);
                  break;
              case "Windows 风格":
                  changeFlavor(3);
                  break;
              case "Windows 经典风格":
                  changeFlavor(4);
                  break;
              case "Motif 风格":
                  changeFlavor(5);
                  break;
          }
        };
        metalItem.addActionListener(flavorListener);
        nimbusItem.addActionListener(flavorListener);
        windowsItem.addActionListener(flavorListener);
        classicItem.addActionListener(flavorListener);
        motifItem.addActionListener(flavorListener);

        textArea.setComponentPopupMenu(pop);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setVisible(true);
    }

    private void changeFlavor(int i) {
        try {
            switch (i) {
                case 1:
                    UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
                    break;
                case 2:
                    UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
                    break;
                case 3:
                    UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
                    break;
                case 4:
                    UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
                    break;
                case 5:
                    UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
                    break;
            }
            SwingUtilities.updateComponentTreeUI(f.getContentPane());
            SwingUtilities.updateComponentTreeUI(menuBar);
            SwingUtilities.updateComponentTreeUI(pop);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new SwingComponent().init();
    }
}
