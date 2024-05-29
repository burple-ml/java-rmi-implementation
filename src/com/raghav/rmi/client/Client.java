package com.raghav.rmi.client;

import java.io.IOException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.util.Scanner;

import com.raghav.rmi.ServiceInterface;

public class Client {

	public static void main(String[] args) throws NotBoundException, IOException{
		
		ServiceInterface service = (ServiceInterface) Naming.lookup("rmi://localhost:4020/authenticate");
		
		System.out.println("---- " + service.echo("Hey Client! How Can I Help? :-)") + " ----"); 
		System.out.println("Enter your username: ");
		
		Scanner scanner = new Scanner(System.in);
		String username = scanner.nextLine();

		System.out.println("Enter your Password: ");
		String password = scanner.nextLine();

		scanner.close();
		
		int authenticationBit = service.authenticate(username, password);
		
		if (authenticationBit == 1) {
			
			int[] result = service.permissionList(username);
			String rs = service.echo2(username);

			System.out.println("YOU ARE AUTHENTICATED BY THE SERVER.PICK AN OPTION FOR THE PRINTER");
			System.out.println("------------------------------------------------------");
			System.out.println("BUT YOU ARE ONLY ALLOWED THE FOLLOWING OPTIONS");
			System.out.println("------------------------------------------------------");
			System.out.println("YOUR ROLE IS :" + rs);
			System.out.println("------------------------------------------------------");
			
			if(contains(result, 1)){
				System.out.println("1.print(String filename, String printer);   // prints file filename on the specified printer");
			}

			if(contains(result, 2)){
				System.out.println("2.queue();   // lists the print queue on the user's display in lines of the form <job number>   <file name>");
			}

			if(contains(result, 3)){
				System.out.println("3.topQueue(int job);   // moves job to the top of the queue");
			}

			if(contains(result, 4)){
				System.out.println("4.start();   // starts the print server ");
			}

			if(contains(result, 5)){
				System.out.println("5.stop();   // stops the print server);");
			}

			if(contains(result, 6)){
				System.out.println("6.restart();   // stops the print server, clears the print queue and starts the print server again");
			}

			if(contains(result, 7)){
				System.out.println("7.status();  // prints status of printer on the user's display);");
			}

			if(contains(result, 8)){	
				System.out.println("8.readConfig(String parameter);   // prints the value of the parameter on the user's display");
			}

			if(contains(result, 9)){
				System.out.println("9.setConfig(String parameter, String value) // sets the parameter to value");
			}
			System.out.println("------------------------------------------------------");
	}
	else {
		System.out.println("------------------------------------");
		System.out.println("    YOU ARE NOT AUTHENTICATED       ");
		System.out.println("------------------------------------");
	}

	}
    public static boolean contains(final int[] array, final int v) {
        boolean result1 = false;
        for(int i : array){
            if(i == v){
                result1 = true;
                break;
            }
        }
        return result1;
    }	
}