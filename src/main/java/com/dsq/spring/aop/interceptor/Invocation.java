package com.dsq.spring.aop.interceptor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DELL on 2018/7/21.
 */
public class Invocation {

    List<Interceptor> interceptors = new ArrayList<>();

    Target target;

    public Invocation(Target target) {
        this.target = target;

    }

    public boolean addInterceptor(Interceptor interceptor) {
       return interceptors.add(interceptor);
    }



    int index = 0;
    public Object process() {
        int size = interceptors.size();

        if(index == size) {
            return target.execute();
        }
        Interceptor filter = interceptors.get(index++);


        return  filter.invoke(this);
    }


}
