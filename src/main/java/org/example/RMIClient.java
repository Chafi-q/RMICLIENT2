package org.example;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIClient {
    public static void main(String[] args) throws RemoteException {


        try {
            Registry registry = LocateRegistry.getRegistry("localhost",1099);
            MyRemoteService service=(MyRemoteService)registry.lookup("MyRemoteService");
            String response= service.hello();
            String menu= service.menu();
            registry.rebind("MyRemoteService", service);
            System.out.println("Response from server: "+response);
            System.out.println("\t #### MENU ###: "+menu);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}