package com.dsq.awt;

import java.awt.*;
import java.awt.event.*;

/**
 * Created by DELL on 2017/10/4.
 */
public class PopuMenuExam {
    private Frame f = new Frame();
    private MenuBar menuBar = new MenuBar();
    Menu file = new Menu("file");
    Menu edit = new Menu("edit");
    MenuItem newItem = new MenuItem("new");
    MenuItem saveItem = new MenuItem("save");
    MenuItem exitItem = new MenuItem("exit", new MenuShortcut(KeyEvent.VK_X));
    CheckboxMenuItem autoWrap = new CheckboxMenuItem("autoWrap");
    MenuItem copyItem = new MenuItem("copy");
    MenuItem pasteItem = new MenuItem("paste");
    Menu format = new Menu("format");
    MenuItem commenItem = new MenuItem("commen", new MenuShortcut(KeyEvent.VK_SLASH, true));
    MenuItem cancelItem = new MenuItem("cancel comment");
    private TextArea textArea = new TextArea(6, 40);
    PopupMenu pop = new PopupMenu();


    public void init() {
        ActionListener menuListener = e -> {
            String cmd = e.getActionCommand();
            textArea.append("单击" + cmd + "菜单\n");
            if(cmd.equals("退出")) {
                System.exit(0);
            }
        };
        commenItem.addActionListener(menuListener);
        exitItem.addActionListener(menuListener);
        file.add(newItem);
        file.add(saveItem);
        file.add(exitItem);

        edit.add(autoWrap);
        edit.addSeparator();
        edit.add(copyItem);
        edit.add(pasteItem);
        format.add(commenItem);
        format.add(cancelItem);
        edit.add(new MenuItem("-"));
        edit.add(format);
        menuBar.add(file);
        menuBar.add(edit);

        pop.add(autoWrap);
        pop.addSeparator();
        pop.add(copyItem);
        pop.add(pasteItem);
        pop.add(format);

        Panel p = new Panel();
        p.setPreferredSize(new Dimension(300, 160));
        p.add(pop);
        p.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                if(e.isPopupTrigger()) {
                    pop.show(p, e.getX(), e.getY());
                }
            }
        });
        f.add(p);
        f.setMenuBar(menuBar);
        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        f.add(textArea, BorderLayout.SOUTH);
        f.pack();
        f.setVisible(true);
    }

    public static void main(String[] args) {
        new PopuMenuExam().init();
    }
}
