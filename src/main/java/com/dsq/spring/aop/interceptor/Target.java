package com.dsq.spring.aop.interceptor;

/**
 * Created by DELL on 2018/7/21.
 */
public class Target {

    StringBuilder request;

    StringBuilder response;

    public StringBuilder getRequest() {
        return request;
    }

    public void setRequest(StringBuilder request) {
        this.request = request;
    }

    public StringBuilder getResponse() {
        return response;
    }

    public void setResponse(StringBuilder response) {
        this.response = response;
    }

    public Object execute() {
        System.out.println("execute target method!");
    /*    if( true) {
            throw new RuntimeException("ex");
        }*/

        return "aabb";
    }


}
