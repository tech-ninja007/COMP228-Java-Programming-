package com.exercise1;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AccountTest {
    public static void main(String[] args){
        Account myAccount = new Account(11090717, "Syed",5000);
        //Transactions
        ArrayList<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction(myAccount,"withdraw",10000));
        transactions.add(new Transaction(myAccount,"deposit",7000));
        transactions.add(new Transaction(myAccount,"withdraw",1000));
        transactions.add(new Transaction(myAccount,"deposit",11000));
        //Executor Service
        ExecutorService executorService = Executors.newCachedThreadPool();
        for(int i = 0; i < transactions.size(); i++){
            executorService.execute(transactions.get(i));
        }
        executorService.shutdown();
    }
}
