package com.dsq.jmx;

/**
 * Created by DELL on 2017/9/28.
 */
public interface HelloMBean {
    public String getName();

     public void setName(String name);

     public String getAge();

     public void setAge(String age);

     public void helloWorld();

     public void helloWorld(String str);

     public void getTelephone();
}
