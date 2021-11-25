package com.test.app;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.util.List;

import com.model.been.Creds;
import com.model.been.User;

public class StoreCreds {

	public static boolean store(Creds cred, User user) {
		List<Creds> credlist = ReadCreds.getCreds(user);
		if (!credlist.isEmpty()) {
			credlist = ReadCreds.getCreds(user);

		} else {
			credlist = new LinkedList<Creds>();
			System.out.println("First Creds Store");
		}
		credlist.add(cred);

		try {
			FileOutputStream file = new FileOutputStream("lockme-db-creds.txt");
			ObjectOutputStream out = new ObjectOutputStream(file);
			out.writeObject(credlist);
			file.close();
			out.close();

		} catch (Exception e) {
			System.out.println("Store Faild");

		}
		return true;

	}
}