package com.raghav.rmi.server;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

import org.mindrot.jbcrypt.BCrypt;

import com.raghav.rmi.ServiceInterface;

public class ServiceClass extends UnicastRemoteObject implements ServiceInterface{
	
	public ServiceClass() throws RemoteException {
		super();
	}

	@Override
	public String echo(String input) throws RemoteException{		
		return "From Server:" + input;		
	}
	
	public int authenticate(String username, String password) throws RemoteException,IOException, FileNotFoundException{
		
		//System.out.println("inside authenticate function");
		int authenticationBit = 0;
		File passwordsFile = new File("Passwords.txt");

		    	try(Scanner scanner = new Scanner(passwordsFile);) {	
					// Reading the Passwords file
					while (scanner.hasNextLine()) {

						String line = scanner.nextLine();
			
						if (line.substring(0, line.indexOf(";")).equals(username)) {

							String hashed = line.substring(line.indexOf(";") + 1);
							if (BCrypt.checkpw(password, hashed)) {

								scanner.close();
								authenticationBit = 1;
								return authenticationBit;
							}
						}
					}
					scanner.close();
					return authenticationBit;
		    	}
				catch (FileNotFoundException e) {
					return authenticationBit;
				} 			
		}	
	
	public int[] permissionList(String username) throws RemoteException,IOException {
		
		// scans the userroles and rolesPermissions to extract the relevant permissions
		int[] permits = {0,0,0,0,0,0,0,0,0};
		File userRolesFile = new File("UserRoles.txt");

		try(Scanner scanner = new Scanner(userRolesFile);) {

			int i = 0;

			// Reading User roles file
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				
				if (line.substring(0, line.indexOf(";")).equals(username)) {
					scanner.close();
					String role = line.substring(line.indexOf(";") + 1);

					System.out.print("You are a " + role);
					
					File rolePermissions = new File("RolesPermissions.txt");
					Scanner scanner = new Scanner(rolePermissions);
					while(scanner.hasNextLine()){
						String line = scanner.nextLine();
						if(line.substring(0, line.indexOf(";")).equals(role)){
							String permissions = line.substring(line.indexOf(";") + 1);
							if (permissions.contains("1")) {
								permits[i] = 1;
								i = i+1;
								}
							if (permissions.contains("2")) {
								permits[i] = 2;
								i = i+1;
						
								}
							if (permissions.contains("3")) {
								permits[i] = 3;
								i = i+1;
								}
							if (permissions.contains("4")) {
								permits[i] = 4;
								i = i+1;
								}
							if (permissions.contains("5")) {
								permits[i] = 5;
								i = i+1;
								}
							if (permissions.contains("6")) {
								permits[i] = 6;
								i = i+1;
								}
							if (permissions.contains("7")) {
								permits[i] = 7;
								i = i+1;
								}
							if (permissions.contains("8")) {
								permits[i] = 8;
								i = i+1;
								}
							if (permissions.contains("9")){
								permits[i] = 9;
								i=i+1;
								}
							
							}
					
						}
					scanner.close();
					return permits;
					}
				}
			scanner.close();
			}
		
		catch (Exception e)  {
			return permits;
		}
		return permits;
	}

	public String echo2(String username) throws RemoteException,IOException{
		String rs = "";
		File userRoles = new File("UserRoles.txt");
		Scanner scanner = new Scanner(userRoles);
		while(scanner.hasNextLine()){
			String line5 = scanner.nextLine();
			if (line5.substring(0, line5.indexOf(";")).equals(username)){
				String rs1 = line5.substring(line5.indexOf(";")+1);
				return rs1;
			}			
		}
		scanner.close();
		return rs;
	}
	
}