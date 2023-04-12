package com.exercise1;

public class Transaction implements Runnable {
    Account account;
    String typeOfTransaction;
    int money;

    public Transaction(Account account, String typeOfTransaction, int money) {
        this.account = account;
        this.typeOfTransaction = typeOfTransaction;
        this.money = money;
    }

    @Override
    public void run() {
        if(typeOfTransaction.equals("withdraw")){
            this.account.withdraw(money);
        }
        else if (typeOfTransaction.equals("deposit")){
            this.account.deposit(money);
        }
        else{
            this.account.getBalance();
        }
    }
}
