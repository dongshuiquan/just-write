package com.dsq.rmi.zk;

import com.dsq.rmi.A;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by DELL on 2018/3/18.
 */
public class HelloServiceImpl extends UnicastRemoteObject
        implements HelloService {

    private static final long serialVersionUID = 1L;

    public HelloServiceImpl() throws RemoteException {
        super();
        // UnicastRemoteObject.exportObject(this, 0);
    }

    @Override
    public String service(String data) throws RemoteException {
        return "Hello : " + data;
    }

    @Override
    public A service(A a) throws RemoteException {
        List<A> as = new ArrayList<A>();
        A a1 = new A();
        a1.setName("a1");
        as.add(a1);
        A a2 = new A();
        a2.setName("a2");
        a.setAs(as);
        System.out.println(a);
        return a;
    }
}