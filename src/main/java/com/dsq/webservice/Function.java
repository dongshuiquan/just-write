package com.dsq.webservice;

import javax.jws.WebService;
import javax.xml.ws.Endpoint;

/**
 * Created by DELL on 2018/3/18.
 */

@WebService
public class Function {
    public String transWords(String words){
        String res="";
        for(char ch : words.toCharArray()){
            res+="\t"+ch+"\t";
        }
        return res;
    }

    //这里我们使用main方法来发布我们的service
    // wsimport -s .  -p com.dsq.webservice -keep http://localhost:9001/Service/Function?wsdl
    public static void main(String[] args){
        Endpoint.publish("http://localhost:9001/Service/Function",new Function());
        System.out.println("Publish Success~");
    }

}
