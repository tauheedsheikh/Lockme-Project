package com.test.app;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.util.List;

import com.model.been.User;

public class Registration {

	public static boolean register(User user) {
		List<User> userList = ReadUser.getUser();
		if (!userList.isEmpty()) {
			userList = ReadUser.getUser();
		} else {

			userList = new LinkedList<User>();
			System.out.println("First Regisrtration");
		}
		userList.add(user);
		try {
			FileOutputStream file = new FileOutputStream("lockme-db-users.txt");
			ObjectOutputStream out = new ObjectOutputStream(file);
			out.writeObject(userList);
			file.close();
			out.close();
			System.out.println("Registration Sucessfuly");
		} catch (Exception e) {
			System.out.println("Registration Failed");
		}
		return true;

	}
}
