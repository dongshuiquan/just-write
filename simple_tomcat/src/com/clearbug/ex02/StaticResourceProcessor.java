package com.clearbug.ex02;

import java.io.IOException;

/**
 * Created by clearbug on 2017/4/30.
 */
public class StaticResourceProcessor {

    public void process(Request request, Response response) {
        try {
            response.sendStaticResource();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
