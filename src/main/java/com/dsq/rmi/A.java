package com.dsq.rmi;

import java.io.Serializable;
import java.util.List;

/**
 * Created by DELL on 2018/3/18.
 */
public class A  implements Serializable {

    private String name;

    private List<A> as;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<A> getAs() {
        return as;
    }

    public void setAs(List<A> as) {
        this.as = as;
    }

    @Override
    public String toString() {
        return "A{" +
                "name='" + name + '\'' +
                ", as=" + as +
                '}';
    }
}
