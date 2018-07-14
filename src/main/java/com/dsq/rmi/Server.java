package com.dsq.rmi;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Arrays;

/**
 * Created by DELL on 2018/3/18.
 */
public class Server {

    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.createRegistry(1099);
            System.out.println(Arrays.asList(registry.list()));

            HelloService service1 = new HelloServiceImpl("service1");
            Context namingContext = new InitialContext();
            namingContext.rebind("rmi://localhost:1099/HelloService1", service1);
            System.out.println(Arrays.asList(registry.list()));

        }
        catch (RemoteException | NamingException e) {
            e.printStackTrace();
        }
        System.out.println("Successfully register a remote object.");

    }
}