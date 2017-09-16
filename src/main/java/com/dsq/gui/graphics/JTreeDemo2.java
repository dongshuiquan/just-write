package com.dsq.gui.graphics;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import java.awt.*;
import java.util.Enumeration;

/**
 * Created by DELL on 2017/7/6.
 */
public class JTreeDemo2 extends JFrame {

    public JTreeDemo2() {
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("倾城爱家");
        DefaultMutableTreeNode nodeA = new DefaultMutableTreeNode("经理办公室");
        DefaultMutableTreeNode nodeB = new DefaultMutableTreeNode("人事部");
        DefaultMutableTreeNode nodeC = new DefaultMutableTreeNode("技术部");
        DefaultMutableTreeNode nodeD = new DefaultMutableTreeNode("服务部");
        DefaultMutableTreeNode nodeE = new DefaultMutableTreeNode("推广部");

        DefaultMutableTreeNode nodeCA = new DefaultMutableTreeNode("网络维护部");
        DefaultMutableTreeNode nodeCB = new DefaultMutableTreeNode("应用开发部");

        DefaultMutableTreeNode nodeDA = new DefaultMutableTreeNode(("网络服务部"));
        DefaultMutableTreeNode nodeDB = new DefaultMutableTreeNode("内勤开发部");

        root.add(nodeA);
        root.add(nodeB);
        root.add(nodeC);
        root.add(nodeD);
        root.add(nodeE);
        nodeC.add(nodeCA);
        nodeC.add(nodeCB);
        nodeD.add(nodeDA);
        nodeD.add(nodeDB);

        DefaultTreeModel treeModel = new DefaultTreeModel(root, true);
        JTree tree = new JTree(treeModel);

        Container container = getContentPane();
        container.add(tree, BorderLayout.CENTER);

        Enumeration enumeration = root.preorderEnumeration();
       /* while(enumeration.hasMoreElements()){
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) enumeration.nextElement();
            tree.expandPath(new TreePath(node.getPath()));
        }*/

        JPanel panel = new JPanel((new GridLayout(1, 5, 10, 10)));
        container.add(panel, BorderLayout.SOUTH);
        JLabel label = new JLabel("名称： ");
        JTextField textField = new JTextField("测试");
        JButton addButton = new JButton("添加");
        JButton modButton = new JButton("修改");
        JButton delButton = new JButton("删除");
        panel.add(label);
        panel.add(textField);
        panel.add(addButton);
        panel.add(modButton);
        panel.add(delButton);

        addButton.addActionListener(e -> {
            DefaultMutableTreeNode node = new DefaultMutableTreeNode(textField.getText());
            TreePath path = tree.getSelectionPath();
            DefaultMutableTreeNode parent = (DefaultMutableTreeNode) path.getLastPathComponent();
            treeModel.insertNodeInto(node, parent, parent.getChildCount());
            TreePath newNodePath = path.pathByAddingChild(node);
            if(!tree.isVisible(newNodePath)){
                tree.makeVisible(newNodePath);
            }
            tree.setSelectionPath(newNodePath);
        });

        modButton.addActionListener( e -> {
            TreePath path = tree.getSelectionPath();
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) path.getLastPathComponent();
            node.setUserObject(textField.getText());
            treeModel.nodeChanged(node);
        });

        delButton.addActionListener(e -> {
            TreePath path = tree.getSelectionPath();
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) path.getLastPathComponent();
            if(!node.isRoot()){
                DefaultMutableTreeNode nextSelectedNode = node.getNextSibling();
                if(nextSelectedNode == null){
                    nextSelectedNode = (DefaultMutableTreeNode) node.getParent();
                }
                tree.setSelectionPath(new TreePath(nextSelectedNode.getPath()));
                treeModel.removeNodeFromParent(node);
            }
        });
    }

    public static void main(String[] args){
        JTreeDemo2 instance = new JTreeDemo2();
        instance.setTitle("企业维护架构");
        instance.setVisible(true);
        instance.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        instance.pack();
    }
}
























