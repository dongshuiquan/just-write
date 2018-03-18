package com.dsq.webservice.client;

import com.dsq.webservice.Function;
import com.dsq.webservice.FunctionService;

/**
 * Created by DELL on 2018/3/18.
 */
public class App {

    public static void main(String[] args){
        Function fu =new FunctionService().getFunctionPort();
        String str=fu.transWords("Let's Get Heck Out Of Here!");
        //最后str就是在Trans项目下的transWords方法处理后的字符串咯!
        System.out.println(str);
    }
}
