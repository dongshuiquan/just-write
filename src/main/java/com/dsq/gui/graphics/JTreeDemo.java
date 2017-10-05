package com.dsq.gui.graphics;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;

/**
 * Created by DELL on 2017/7/6.
 */
public class JTreeDemo {
    public static void main(String[] args){
        // 创建没有父节点和子节点、但允许有子节点的树节点，并使用指定的用户对象对它进行初始化。
        DefaultMutableTreeNode node1 = new DefaultMutableTreeNode("软件部");
        node1.add(new DefaultMutableTreeNode(new User("小花")));
        node1.add(new DefaultMutableTreeNode(new User("小虎")));
        node1.add(new DefaultMutableTreeNode(new User("小龙")));

        DefaultMutableTreeNode node2 = new DefaultMutableTreeNode("销售部");
        node2.add(new DefaultMutableTreeNode(new User("小叶")));
        node2.add(new DefaultMutableTreeNode(new User("小雯")));
        node2.add(new DefaultMutableTreeNode(new User("小夏")));

        DefaultMutableTreeNode top = new DefaultMutableTreeNode("职员管理");

        top.add(new DefaultMutableTreeNode(new User("总经理")));
        top.add(node1);
        top.add(node2);

        JTree tree = new JTree(top);
        JFrame f = new JFrame("JTreeDemo");
        f.add(tree);
        f.setSize(300, 300);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        tree.addTreeSelectionListener(e -> {
           DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
           if(node == null) return;
           Object object = node.getUserObject();
           if(node.isLeaf()){
               User user = (User) object;
               System.out.println("你选择了： " + user.toString());
           }
        });

        JPanel buttonPanel = new JPanel();
        JButton expandButton = new JButton("展开");
        expandButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Enumeration enumeration = top.preorderEnumeration();
                while(enumeration.hasMoreElements()){
                    DefaultMutableTreeNode node = (DefaultMutableTreeNode) enumeration.nextElement();
                    tree.expandPath(new TreePath(node.getPath()));
                }
            }
        });
        JButton closeButton = new JButton("关闭");
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
        buttonPanel.add(expandButton);
        buttonPanel.add(closeButton);
        f.add(buttonPanel, BorderLayout.SOUTH);
        f.setVisible(true);
    }
}

class User{
    private String name;

    public User(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}
