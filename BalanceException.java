package com.account;

public class BalanceException extends RuntimeException {
	public BalanceException() {
		
		System.out.println("Insufficient Balance.");

	}
}
