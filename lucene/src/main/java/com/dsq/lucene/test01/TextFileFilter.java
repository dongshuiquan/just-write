package com.dsq.lucene.test01;

/**
 * Created by DELL on 2018/11/7.
 */
import java.io.File;
import java.io.FileFilter;

public class TextFileFilter implements FileFilter {

    @Override
    public boolean accept(File pathname) {
        return pathname.getName().toLowerCase().endsWith(".txt");
    }
}
