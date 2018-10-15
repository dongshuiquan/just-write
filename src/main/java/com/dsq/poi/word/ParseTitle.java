package com.dsq.poi.word;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.junit.Test;
import sun.reflect.generics.tree.Tree;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by DELL on 2018/9/26.
 */
public class ParseTitle {

    public static void main(String[] args) {
        ParseTitle parseTitle = new ParseTitle();
        parseTitle.readDataDocx();
    }


    @Test
    public void readDataDocx() {
        //String filePath = "C:\\Users\\DELL\\Desktop\\导入2.docx";
        String filePath = "C:\\Users\\DELL\\Desktop\\德赛西威公司PLM一期优化项目开发需求规格书V0.92.docx";
        InputStream istream=null;
        try {
            istream = new FileInputStream(filePath);
            XWPFDocument document=new XWPFDocument(istream);
            List<XWPFParagraph> paras = document.getParagraphs();
            List<TreeNode> list = new ArrayList<>();

            for(XWPFParagraph p : paras) {
                String text = p.getText();
                String style = p.getStyle();
                if(style != null && NumberUtils.isNumber(style)) {
                    int intStyle = Integer.parseInt(style);
                    if(intStyle > 0 && intStyle < 10) {
                        TreeNode treeNode = new TreeNode();
                        treeNode.title = text;
                        treeNode.style = intStyle;

                        list.add(treeNode);
                    }
                }
            }
            System.out.println(StringUtils.join(list, "\r\n"));
            fixStyle(list);
            System.out.println(StringUtils.join(list, "\r\n"));
            System.out.println();
            System.out.println();
            List<TreeNode> topLevel = parseChild(list);

            CheckBoxTreeNode  root = new CheckBoxTreeNode ("我是你爹");
            for(TreeNode node : topLevel) {
                show(node, root);
            }
            JTree tree = new JTree(root);
            tree.addMouseListener(new CheckBoxTreeNodeSelectionListener());
            tree.setCellRenderer(new CheckBoxTreeCellRenderer());

            JPanel panel = new JPanel(new BorderLayout());
            panel.setPreferredSize(new Dimension(800, 800));
            panel.add(new JScrollPane(tree));
            JOptionPane.showConfirmDialog(null, panel);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if(istream!=null)
                try {
                    istream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }

    private void fixStyle(List<TreeNode> list) {
        for(int i = 0; i < list.size(); i++) {
            TreeNode node = list.get(i);
            int style = node.style;
            if(0 == i) {
                node.level = 1;
            } else {
                boolean find = false;
                for(int j = i - 1; j >=0; j--) {
                    TreeNode node2 = list.get(j);
                    if(j == i - 1) {
                        if(style > node2.style) {
                            node.level = node2.level + 1;
                            find = true;
                            break;
                        } else if(style == node2.style) {
                            node.level = node2.level;
                            find = true;
                            break;
                        }
                    }
                    if(style == node2.style) {
                        node.level = node2.level;
                        find = true;
                        break;
                    } else if(style > node2.style) {
                        node.level = node2.level + 1;
                        find = true;
                        break;
                    }
                }
                if(!find) {
                    node.level = 1;
                }
            }
        }
    }

    private List<TreeNode> parseChild(List<TreeNode> list) {
        List<TreeNode> topLevel = new ArrayList<>();
        for(TreeNode node : list) {
            if(node.level == 1) {
                topLevel.add(node);
            }
        }

        mark:
        for(int i = list.size() - 1; i >= 0; i--) {
            TreeNode treeNode = list.get(i);
            int level = treeNode.level;
            if(level == 1) {
                continue;
            } else {
                for(int j = i - 1; j >= 0; j--) {
                    TreeNode treeNode2 = list.get(j);
                    if(treeNode2.level == level - 1) {
                        treeNode2.child.add(0, treeNode);
                        continue mark;
                    }
                }
            }
        }
        for(TreeNode node : topLevel) {
            print(node, "");
        }


        return topLevel;
    }

    void print(TreeNode node, String str) {
        System.out.println(str + node.title + "==" + node.level);
        if(node.child.size() > 0) {
            for(TreeNode child : node.child) {
                print(child, str + "    ");
            }
        }
    }


    void show(TreeNode treeNode, CheckBoxTreeNode  parent) {
        CheckBoxTreeNode  childNode = new CheckBoxTreeNode (treeNode.title);
        parent.add(childNode);
        if(treeNode.child.size() > 0) {
            for(TreeNode child : treeNode.child) {
                show(child, childNode);
            }
        }
    }

}
