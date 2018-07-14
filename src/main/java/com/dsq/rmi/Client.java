package com.dsq.rmi;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.rmi.RemoteException;
import java.util.List;

/**
 * Created by DELL on 2018/3/18.
 */
public class Client {
    public static void main(String[] args) {
        String url = "rmi://localhost:1099/";
        try {
            Context namingContext = new InitialContext();
            HelloService serv = (HelloService) namingContext.lookup(url + "HelloService1");
            String data = "This is RMI Client.";
            System.out.println(serv.service(data));

            A a = new A();
            a.setName("a");
            A a1 = serv.service(a);
            List<A> as = a1.getAs();
            System.out.println(as.size());
            System.out.println(a1);
        }
        catch (NamingException | RemoteException e) {
            e.printStackTrace();
        }
    }
}