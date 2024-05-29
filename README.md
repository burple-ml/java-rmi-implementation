# About
This implementation was done as part of coursework at my school. Hence the scope of the RMI implementation is limited.  
This is a RMI (Remote Method Invocation) implementation in Java, with server side authentication, using password hashing,
and access control. 

# Task
The resource being shared is that of a printer, which is trying to be accessed remotely. But different User Roles
have different permissions, and also passwords must be stored in a safe and secure manner than readable verbatim passwords.
Moreover, the roles of different users should be maintained using text files, so that it is easy to edit, and maintain. 

For this task, I have made this implementation in java. I am storing only hashed passwords and only hashed passwords are passed for authentication. The Passwords, the user roles and the Permissions for each role are saved in their respective `.txt` files 

# How to run
Use the following steps
* Compile the java files to get the .class files for the JVMs using the command - `javac rmiimplementation/*.java`
* Compile the stub and skeleton using the command `rmic rmiimplementation.ServiceClass`
* Initialise the lookup registry using the command `rmiregistry &` 
* Now start a server instance and client instance using the `java ApplicationServer.class` and `java Client.class` respectively on their seperate prompts
* Use the Usernames provided in the `Passwords.txt` file as usernames, and just append the phrase `pass` for password.
For example; Password for Alice is `Alicepass`


# TODO
* New User creation logic can also be included in this setup, and for that i have included the `PassCreator.java` files. Although, this file doesnt serve much purpose as of now in the working of the system, so 
* Please ignore the `PassCreator.java` files

# Credits 
The package used for password hashing is taken from - [jBCrypt](https://github.com/djmdjm/jBCrypt/) and is included in the maven dependency,
which is an implementation of the OpenBSD Blowfish Hashing algorithm. 
