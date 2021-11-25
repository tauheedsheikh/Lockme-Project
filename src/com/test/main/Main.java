package com.test.main;

import java.util.List;
import java.util.Scanner;

import com.model.been.Creds;
import com.model.been.User;
import com.test.app.FetchbySiteName;
import com.test.app.LoginUser;
import com.test.app.ReadCreds;
import com.test.app.Registration;
import com.test.app.StoreCreds;

public class Main {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("=========================");
		System.out.println("WELCOME TO LOCK ME APP");
		System.out.println("========================");
		System.out.println("----Please Select Your Option----");
		System.out.println("---1)Registration 2)Login ----");
		int option = scanner.nextInt();

		switch (option) {
		case 1:
			User userRg = registar();
			Registration.register(userRg);
			break;
		case 2:
			User userLog = login();
			LoginUser.login(userLog);
			boolean response = LoginUser.login(userLog);
			if (response) {
				chooseOptionAfterLogin(userLog);
			}

			break;
		default:
		}

	}

	public static User registar() {
		User user = new User();
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to Registration Page");
		System.out.println("Enter id ");
		user.setId(sc.nextLine());
		System.out.println("Enter user Name ");
		user.setUserName(sc.nextLine());
		System.out.println("Enter Email");
		user.setEmail(sc.nextLine());
		System.out.println("Password");
		user.setPassword(sc.nextLine());
		System.out.println("Confirm Password");
		user.setCnfpassword(sc.nextLine());
		return user;
	}

	public static User login() {
		User login = new User();
		Scanner scan = new Scanner(System.in);
		System.out.println("-----Welcome To Login");
		System.out.println("Enter Id");
		login.setId(scan.nextLine());
		System.out.println("Ener User Name");
		login.setUserName(scan.nextLine());
		System.out.println("Enter Email");
		login.setEmail(scan.nextLine());
		System.out.println("Enter Password");
		login.setPassword(scan.nextLine());
		System.out.println("Enter Confirm Password");
		login.setCnfpassword(scan.nextLine());
		return login;
	}

	public static Creds stordata() {
		Creds cred = new Creds();
		Scanner scan = new Scanner(System.in);
		System.out.println("Welcome to Store Data ");
		System.out.println("Enter Id");
		cred.setId(scan.next());
		System.out.println("Enter SiteName");
		cred.setSiteName(scan.nextLine());
		System.out.println("Enter userName");
		cred.setUserName(scan.nextLine());
		System.out.println("Enter Password ");
		cred.setPassword(scan.nextLine());
		return cred;

	}

	public static String fetchBysiteName() {
		Scanner scane = new Scanner(System.in);
		System.out.println("Enter Site Name");
		return scane.nextLine();
	}

	public static void chooseOptionAfterLogin(User userLog) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("== Please select 1) Store Creds 2) Fetch Creds   ==");
		int option = scanner.nextInt();
		switch (option) {
		case 1:
			Creds userCreds = stordata();
			StoreCreds.store(userCreds, userLog);

			break;

		case 2:
			List<Creds> creditList = ReadCreds.getCreds(userLog);
			System.out.println(creditList);
			break;

		default:
			throw new IllegalArgumentException("Unexpected value: " + option);
		}
	}

	public static void chooseOptionAfterFetch(User userLog) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("== Please select 1) Store Creds 2) Fetch Creds 3)Fetch By SiteName  ==");
		int option = scanner.nextInt();
		switch (option) {
		case 1:
			ReadCreds.getCreds(userLog);
			break;

		case 2:
			String sitename = fetchBysiteName();
			List<Creds> creditList = ReadCreds.getCreds(userLog);
			FetchbySiteName.siteName(creditList, sitename);
			break;

		default:
			throw new IllegalArgumentException("Unexpected value: " + option);

		}
	}
}