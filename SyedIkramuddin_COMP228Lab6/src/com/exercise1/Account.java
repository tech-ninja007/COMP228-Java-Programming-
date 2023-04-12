package com.exercise1;

public class Account {
    int balance;
    String name;
    final int accountNumber;

    public Account(int accountNumber,String name, int initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.name = name;
    }

    public synchronized void deposit(int money){
        System.out.println("Processing the transaction ....");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.balance += money;
        System.out.println("Deposited Money:"+ money);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Your transaction is "+balance);
        System.out.println("Transaction completed.\n");
    }

    public synchronized void withdraw(int money){
        System.out.println("Processing the transaction ....");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(money > this.balance){
            System.out.println("Cannot withdraw, Balance is low!\n");
            return;
        }
        this.balance -= money;
        System.out.println("Withdraw Money:"+money);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Your transaction is "+balance);
        System.out.println("Transaction completed.\n");
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAccountNumber() {
        return accountNumber;
    }
}
