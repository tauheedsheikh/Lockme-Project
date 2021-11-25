package com.test.app;

import java.util.List;

import com.model.been.User;

public class LoginUser {

	public static boolean login(User user) {
		List<User> userList = ReadUser.getUser();

		int match = 0;
		for (User userInfo : userList) {
			if (user.getUserName().equals(userInfo.getUserName())
					&& user.getPassword().equals(userInfo.getPassword())) {
				System.out.println("Login SuccessFully");
				return true;
			}
		}
		if (match == 0) {
			System.out.println("Login Faild");
		}
		return false;
	}
}
