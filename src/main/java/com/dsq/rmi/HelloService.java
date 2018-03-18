package com.dsq.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by DELL on 2018/3/18.
 */
public interface HelloService extends Remote{

    String service(String data) throws RemoteException;

    A service(A a) throws RemoteException;
}
