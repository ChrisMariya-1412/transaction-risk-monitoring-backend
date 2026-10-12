package org.example;

public class Account {

    private int id;
    private String accountNumber;
    private String name;
    private double spendingLimit;

    public Account(int id, String accountNumber, String name, double spendingLimit) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.name = name;
        this.spendingLimit = spendingLimit;
    }

    public int getId() {
        return id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getName() {
        return name;
    }

    public double getSpendingLimit() {
        return spendingLimit;
    }
}