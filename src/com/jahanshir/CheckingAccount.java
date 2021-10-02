package com.jahanshir;

public class CheckingAccount extends Account{
    private final int fees=7000;

    public CheckingAccount(String name, int accountNumber, double balance, MyDate createDate) {
        super(name, accountNumber, balance, createDate);
    }


    @Override
    public double calculateWithDraw(double amount) {
        if(amount+fees<=20000000) {
            return amount + fees;
        }
        else {
            return -1;
        }
    }

    @Override
    public double calculateInterest(double amount) {
        return  0;
    }

    @Override
    public String toString() {
        return super.toString()+"  fees: "+fees;
    }
}
