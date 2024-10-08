package org.example;


import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface MyRemoteService extends Remote {

    String hello() throws RemoteException;
    List<Livre> getBooks() throws RemoteException;
    Boolean addBook(Livre livre) throws RemoteException;
    Livre findBook(String titre) throws RemoteException;

    StringBuilder menu() throws RemoteException;

}
