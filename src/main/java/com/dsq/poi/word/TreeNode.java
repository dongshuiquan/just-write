package com.dsq.poi.word;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DELL on 2018/9/26.
 */
public class TreeNode {

    String title;

    int level;

    int style;

    List<TreeNode> child = new ArrayList<>();


    @Override
    public String toString() {
        return "TreeNode{" +
                "title='" + title + '\'' +
                ", level=" + level +
                ", style=" + style +
                '}';
    }
}
