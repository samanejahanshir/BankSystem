package com.jahanshir;

public class SavingAccount extends Account{
    private final double interest=0.10;

    public SavingAccount(String name, int accountNumber, double balance, MyDate createDate) {
        super(name, accountNumber, balance, createDate);
    }


    @Override
    public double calculateInterest(double amount) {
        return  getBalance()+getBalance()*interest;
    }

    @Override
    public String toString() {
        return super.toString()+"  interest : "+interest;
    }
}
