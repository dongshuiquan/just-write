package com.dsq.gui.graphics;

import org.junit.Test;

import javax.swing.*;
import javax.swing.tree.TreeModel;
import java.util.Hashtable;

/**
 * Created by DELL on 2017/10/3.
 */
public class JTreeExam3  extends JTree{
    public static void main(String[] args) {
        test00();
        //        test02();
    }
    public static void test00() {
        JFrame jFrame = new JFrame();
        JTree tree = new JTree();
        jFrame.add(tree);
        jFrame.pack();
        jFrame.setVisible(true);
    }
    public static void test01() {
        JFrame jFrame = new JFrame();
        TreeModel treeModel = getDefaultTreeModel();
        JTree tree = new JTree(treeModel);
        jFrame.add(tree);
        jFrame.pack();
        jFrame.setVisible(true);
    }
    public static void test02() {
        JFrame jFrame = new JFrame();
//        Object value =new String[] {"1", "2", "3", "4"};
        Hashtable value =new Hashtable<String, String>();
        value.put("1", "a");
        value.put("2", "b");
        value.put("3", "c");
        TreeModel treeModel = createTreeModel(value);
        JTree tree = new JTree(treeModel);
        jFrame.add(tree);
        jFrame.pack();
        jFrame.setVisible(true);
    }
}
