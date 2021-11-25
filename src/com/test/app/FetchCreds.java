package com.test.app;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.LinkedList;
import java.util.List;

import com.model.been.Creds;

public class FetchCreds {

	public static List<Creds> fetchCreds(Creds cred) {
		List<Creds> credList = new LinkedList<Creds>();
		try {
			File f = new File(cred.getUserName() + "lockme-db-creds.txt");
			if (f.exists()) {
				FileInputStream file = new FileInputStream(cred.getUserName() + "lockme-db-creds.txt");
				ObjectInputStream input = new ObjectInputStream(file);
				credList = (List<Creds>) input.readObject();

				int match = 0;
				for (Creds userCreds : credList) {
					System.out.println(userCreds);
					System.out.println("Site Name :" + userCreds.getSiteName());
					System.out.println("Site  UserName :" + userCreds.getUserName());
					System.out.println("Site password :" + userCreds.getPassword());
					match++;

				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return credList;
	}

}
