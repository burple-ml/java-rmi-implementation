package com.raghav.rmi.server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ApplicationServer {
	public static void main(String[] args) throws RemoteException {
		// Registry Creation and Binding here
		Registry registry = LocateRegistry.createRegistry(4020);
		registry.rebind("authenticate", new ServiceClass());

	}

}