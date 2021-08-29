package com.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class Account {
	static String name = "Nivya";
	double amountBalance;
	double withdrawAmount;
	double depositAmount;

	static {
		System.out.println("Welcome CITI Account");
		System.out.println("-------------------------------------");

	}

	public Account() {
		// System.out.println("Create CITI Account");
	}

	public Account(String name, double amountBalance) {
		this.name = name;
		this.amountBalance = amountBalance;
		System.out.println("Account created with "+ amountBalance +" INR..!!");
		System.out.println("Hello " + name + " how can we help you?");
		System.out.println("------------------------------------------------------");
	}

	public double balance() {

		System.out.println("Balance is " + this.amountBalance + " INR");
		return amountBalance;
	}

	public void deposit(double depositAmount) throws AmountException {

		if (depositAmount < 0) {
			throw new AmountException();
		} else {

			this.amountBalance += depositAmount;

			System.out.println(
					"Total balance Amount " + this.amountBalance + " after depositing " + depositAmount + " INR");
		}

	}

	public void withdraw(double withdrawAmount) throws AmountException, BalanceException {
		if (withdrawAmount < 0) {

			throw new AmountException();
		} else if (withdrawAmount > this.amountBalance) {

			throw new BalanceException();
		} else {

			this.amountBalance -= withdrawAmount;

			System.out.println(
					"Balance remaining " + this.amountBalance + " after withdrawing " + withdrawAmount + " INR");
		}

	}

}
