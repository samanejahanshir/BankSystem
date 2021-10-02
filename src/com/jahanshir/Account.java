package com.jahanshir;

public class Account {
    Transaction[] transactions=new Transaction[100];
    int indexTransaction=0;
    private  String name;
    private int accountNumber;
    private  double balance;
    private MyDate createDate;

    public Account(String name, int accountNumber, double balance, MyDate createDate) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.createDate = createDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public MyDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(MyDate createDate) {
        this.createDate = createDate;
    }

    public double calculateWithDraw(double amount){
        return amount;
    }
    public  double calculateInterest(double amount){
        return 0;
    }

    @Override
    public String toString() {
        return  "accountType: "+name
                +"  accountNumber: "+accountNumber
                +"  accountInventory: "+ balance+" R "
                +"  createDate: "+createDate.toString();
    }
}
