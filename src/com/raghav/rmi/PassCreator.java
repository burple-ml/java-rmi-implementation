package com.raghav.rmi;

import java.io.IOException;
import java.util.Scanner;

import org.mindrot.jbcrypt.BCrypt;

public class PassCreator {
    public static String generateHash(String passwordPlain) {
        return BCrypt.hashpw(passwordPlain, BCrypt.gensalt());
    }

	public static void main(String[] args) throws IOException {	
		try {
			System.out.println("Enter your password: ");
			Scanner scanner = new Scanner(System.in);
			String password = scanner.nextLine();
			System.out.println("The hash is : " + generateHash(password));
			scanner.close();
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
}
