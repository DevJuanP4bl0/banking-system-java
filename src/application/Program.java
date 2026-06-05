package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Account;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner scanner = new Scanner(System.in);
		List<Account> accounts = new ArrayList<>();
		
		int option = 0;
		
		do {
			System.out.println("1 - Criar Conta");
			System.out.println("2 - Depositar");
			System.out.println("3 - Sacar");
			System.out.println("4 - Transferir");
			System.out.println("5 - Ver Extrato");
			System.out.println("0 - Sair");
			
			System.out.println();
			System.out.print("Digite sua opção: ");
			option = scanner.nextInt();
			scanner.nextLine();
			System.out.println();
			
			
			switch (option) {
			case 1: 
				System.out.print("Insira o nome do titular: ");
				String name = scanner.nextLine();
			
				accounts.add(new Account(name));	
				break;
			case 2:
				System.out.print("Insira o número da conta: ");
				int number = scanner.nextInt();
				System.out.print("Insira a quantia que deseja depositar: ");
				double amount = scanner.nextDouble();
				
				Account.findAccount(accounts, number).deposit(amount);;
				break;
			case 3:
				System.out.print("Insira o número da conta: ");
				number = scanner.nextInt();
				System.out.print("Insira a quantia que deseja sacar: ");
				amount = scanner.nextDouble();
				
				Account.findAccount(accounts, number).withdraw(amount);;
				break;
			case 4:
				System.out.print("Insira o numero da conta para o qual deseja transferir: ");
				int numberAccount = scanner.nextInt();
				System.out.print("Insira o valor que deseja transferir: ");
				amount = scanner.nextDouble();
				
				accounts.get(accounts.size() - 1).transferTo(amount, accounts, numberAccount);
				break;
			case 5:
				for (String entry : accounts.get(accounts.size() - 1).getExtract()) {
					System.out.println(entry);
				}
			}
			
			System.out.println();
			
		} while (option != 0);
		
		System.out.println("Sessão finalizada.");
		scanner.close();
	}

}
