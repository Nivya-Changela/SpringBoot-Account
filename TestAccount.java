package com.account;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAccount {

	ApplicationContext appCtx = new ClassPathXmlApplicationContext("accountCtx.xml");
	Account tc = (Account) appCtx.getBean("acc");

	@Test
	void testMethods() {
		testInvalidDeposit();
		testValidDeposit();
		testValidWithdraw();
		testInvalidWithdraw();
		testInsufficientWithdraw();
	}

	void testInvalidDeposit() {

		System.out.println("1) Test Invalid Deposit: ");
		try {
			tc.deposit(-10);
		} catch (AmountException e) {

		}

	}

	void testValidDeposit() {
		System.out.println("2) Test valid Deposit: "); // 210
		try {
			tc.deposit(10);
		} catch (AmountException e) {

		}
	}

	void testValidWithdraw() {

		System.out.println("3) Test valid Withdraw: "); // 200
		try {
			tc.withdraw(10);
		} catch (AmountException | BalanceException e) {

		}
	}

	void testInvalidWithdraw() {
		System.out.println("4) Test Invalid Withdraw: "); // 200
		try {
			tc.withdraw(-10);
		} catch (AmountException | BalanceException e) {
		}

	}

	void testInsufficientWithdraw() {
		System.out.println("5) Test Insufficient Withdraw: "); // 200
		try {
			tc.withdraw(1000);
		} catch (AmountException | BalanceException e) {

		}
	}
}
