package entities;

import java.util.ArrayList;
import java.util.List;

public class Account {
	private static List<Account> accounts = new ArrayList<>();
	private static int nextAccountNumber = 1; 
	
	private int accountNumber;
	private String accountHolder;
	private double value;
	
	public Account(String accountHolder) {
		this.accountNumber = nextAccountNumber++;
		this.accountHolder = accountHolder;
		accounts.add(this);
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public String getAccountHolder() {
		return accountHolder;
	}

	public void setAccountHolder(String accountHolder) {
		this.accountHolder = accountHolder;
	}
	
	public double getValue() {
		return value;
	}

	public void deposit(double value) {
		this.value += value;
	}
	
	public void withdraw(double value) {
		this.value -= value;
	}
	
	public int transferTo(double value, int numberCount) {
		int result = -1;
		
		Account account = Account.findAccount(accounts, numberCount);
		
		if (account != null) {
			withdraw(value);

			account.deposit(value);
			
			result = numberCount;
		}
		
		return result;
	}
	
	public static Account findAccount(List<Account> list, int numberCount) {
		return list.stream().filter(x -> x.getAccountNumber() == numberCount).findFirst().orElse(null);
	}
	
}
