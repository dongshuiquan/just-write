package com.dsq.annotation;

/**
 * Created by DELL on 2017/10/5.
 */
public class DogImpl implements AnimalInterface {
    @Seven(value = "Lumia")
    private String name;

    private String Property;

    public DogImpl() {
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void getProperty() {
        System.out.println(this.name + this.Property);
    }
    @Seven(Property = "水陆两栖战士")
    @Override
    public void setProperty(String property) {
        Property = property;
    }

    @Override
    public void say() {
        System.out.println("小狗：汪汪汪汪......");
    }
}
