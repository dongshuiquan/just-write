package com.clearbug.ex03.startup;

import com.clearbug.ex03.connector.http.HttpConnector;

/**
 * Created by clearbug on 2017/5/7.
 */
public class Bootstrap {

    public static void main(String[] args) {
        HttpConnector connector = new HttpConnector();
        connector.start();
    }
}
