package org.example;


import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MyRemoteService extends Remote {

    String hello() throws RemoteException;
    String menu() throws RemoteException;

}
