package com.jahanshir;

public class Customer {
    private String firstName;
    private String lastName;
    Account[] accounts=new Account[10];

    int indexAccount=0;

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public boolean withDraw(long amount,int accountNumber) {
        for(int i=0;i<indexAccount;i++){
            if(accounts[i].getAccountNumber()==accountNumber){
                if(accounts[i].getBalance()>amount){
                    accounts[i].setBalance(accounts[i].getBalance()-amount);
                    return true;
                }else {
                    return false;
                }
            }
        }
        return false;
    }

    public boolean deposit(long amount,int accountNumber) {

        for(int i=0;i<indexAccount;i++){
            if(accounts[i].getAccountNumber()==accountNumber){
                    accounts[i].setBalance(accounts[i].getBalance()+amount);
                    return true;
            }
        }
        return false;
    }

    public double gettingInventory(long accountNumber) {
         for(int i=0;i<indexAccount;i++){
             if(accounts[i].getAccountNumber()==accountNumber){
                 return accounts[i].getBalance();
             }
         }
        return -1;
    }
    public void printInformationAccounts(){
        for(int i=0;i<indexAccount;i++){
            System.out.println(accounts[i].toString());
        }
    }
    public void printTransactions(int indexAccount){
        for(int i=0;i<accounts[indexAccount].indexTransaction;i++) {
            System.out.println(accounts[indexAccount].transactions[i].toString());
        }
    }
    public  int checkAccountNumber(int accountNumber){
        for(int i=0;i<indexAccount;i++){
            if(accounts[i].getAccountNumber()==accountNumber){
                return  i;
            }
        }
        return  -1;
    }
}
