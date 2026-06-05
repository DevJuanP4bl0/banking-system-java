package entities;

import java.util.ArrayList;
import java.util.List;

import services.DateTimeUtils;

public class Account {
	private static int nextAccountNumber = 1; 
	
	private int accountNumber;
	private String accountHolder;
	private double value;
	
	private List<String> extract = new ArrayList<>();
	
	public Account(String accountHolder) {
		this.accountNumber = nextAccountNumber++;
		this.accountHolder = accountHolder;
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
	
	public List<String> getExtract() {
		return extract;
	}

	public void deposit(double value) {
		this.value += value;
		
		String moment = DateTimeUtils.toLocal();
		
		extract.add(moment + ": foi depositado R$ " + String.format("%.2f", value));
	}
	
	public void withdraw(double value) {
		this.value -= value;
		
		String moment = DateTimeUtils.toLocal();
		
		extract.add(moment + ": foi sacado R$ " + String.format("%.2f", value));
	}
	
	public int transferTo(double value, List<Account> accounts, int numberCount) {
		int result = -1;
		
		Account account = Account.findAccount(accounts, numberCount);
		
		if (account != null) {
			this.value -= value;

			account.deposit(value);
			
			String moment = DateTimeUtils.toLocal();
			
			extract.add(moment + ": foi transferido R$ " + 
					String.format("%.2f", value) + " para " + account.getAccountHolder());
			
			result = numberCount;
		}
		
		return result;
	}
	
	public static Account findAccount(List<Account> list, int numberCount) {
		return list.stream().filter(x -> x.getAccountNumber() == numberCount).findFirst().orElse(null);
	}
	
}
