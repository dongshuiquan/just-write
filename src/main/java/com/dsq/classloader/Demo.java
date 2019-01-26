package com.dsq.classloader;

/**
 * Created by DELL on 2018/8/25.
 */
public class Demo {


    static int tmp = 1;

    static  {
        tmp = 2;
        System.out.println(tmp);
    }



    public static void main(String[] args) {
        System.out.println(tmp);
    }


}
