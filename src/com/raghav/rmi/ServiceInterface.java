package com.raghav.rmi;
import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServiceInterface extends Remote{
	public String echo(String input) throws RemoteException;
	public int authenticate(String username, String password) throws RemoteException,IOException;
	public int[] permissionList(String username) throws RemoteException,IOException;
	public String echo2(String username) throws RemoteException,IOException;
}
