package com.test.app;

import java.util.List;

import com.model.been.Creds;

public class FetchbySiteName {
	public static void siteName(List<Creds> credlist, String siteName) {
		try {
			int match = 0;

			for (Creds list : credlist) {
				if (list.getSiteName().equals(siteName)) {
					System.out.println("Site Name :" + list.getSiteName());
					System.out.println("Site Name :" + list.getUserName());
					System.out.println("Site Name :" + list.getPassword());
					match++;

				}
				if (match == 0) {

					System.out.println("Invalid site Name");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();

		}

	}

}
