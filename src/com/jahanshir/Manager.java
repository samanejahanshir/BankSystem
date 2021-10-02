package com.jahanshir;

import java.util.Random;
import java.util.Scanner;

public class Manager {
    private final String userName = "admin";
    private final String password = "admin";

    public boolean CheckUserAndPassword(String userName, String password) {
        if (this.userName.equals(userName) && this.password.equals(password)) {
            return true;
        }
        return false;
    }

    public boolean addNewAccount(int index) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1.checking account\n2.saving account\n3.loan account :");
        String typeAccount = scanner.next();
        if (CheckValidation.checkInt(typeAccount)) {
            System.out.println("enter amount money for create account :");
            String amount = scanner.next();
            Random random = new Random();
            int numAccount = random.nextInt(1000000) + 100000;
            MyDate myDate = Bank.getDate();
            if (CheckValidation.checkInt(amount) && myDate != null) {
                if (Integer.parseInt(typeAccount) == 1) {
                    Bank.customers[index].accounts[Bank.customers[index].indexAccount] = new CheckingAccount(TypeAccount.CHECKINGACCOUNT.getName(), numAccount, Integer.parseInt(amount), myDate);
                    Bank.customers[index].indexAccount++;
                    return  true;
                } else if (Integer.parseInt(typeAccount) == 2) {
                    Bank.customers[index].accounts[Bank.customers[index].indexAccount] = new SavingAccount(TypeAccount.SAVINGACCOUNT.getName(), numAccount, Integer.parseInt(amount), myDate);
                    Bank.customers[index].indexAccount++;
                    return  true;
                } else if (Integer.parseInt(typeAccount) == 3) {
                    System.out.println("enter amount loan : ");
                    String loan = scanner.next();
                    System.out.println("enter interest : ");
                    String interest = scanner.next();
                    System.out.println("enter loan duration : ");
                    String loanDuration = scanner.next();
                    if (CheckValidation.checkInt(loan) && CheckValidation.checkInt(interest) && CheckValidation.checkInt(loanDuration)) {
                        Bank.customers[index].accounts[Bank.customers[index].indexAccount] = new LoanAccount(TypeAccount.LOANACCOUNT.getName(), numAccount, Integer.parseInt(amount), myDate, Double.parseDouble(loan), Double.parseDouble(interest), Integer.parseInt(loanDuration));
                        Bank.customers[index].indexAccount++;
                        return  true;
                    } else {
                        System.out.println("enter valid please ! ");

                    }

                }

            }
        }
        return false;
    }

    public void viewAccount() {
        String[] name = Bank.getCustomerName();
        int index = Bank.checkCustomerExist(name[0], name[1]);
        if (index != -1) {
            Bank.customers[index].printInformationAccounts();
        } else {
            System.out.println("this customer not found !");

        }
    }

    public boolean withDraw(int index, int accountNumber, long amount, MyDate myDate) {
        int indexAccount = Bank.customers[index].checkAccountNumber(accountNumber);
        if (indexAccount != -1) {
            Bank.customers[index].accounts[indexAccount].setBalance(Bank.customers[index].accounts[indexAccount].getBalance() - amount);
            return true;
        }
        return false;
    }

    public boolean deposit(int index, int accountNumber, long amount, MyDate myDate) {
        int indexAccount = Bank.customers[index].checkAccountNumber(accountNumber);
        if (indexAccount != -1) {
            Bank.customers[index].accounts[indexAccount].setBalance(Bank.customers[index].accounts[indexAccount].getBalance() + amount);
            return true;
        }
        return false;
    }

    public boolean calculateInterests(int accountNumber) {
        int index = -1, indexAccount = -1;
        String nameAccount = "";
        MyDate myDate = Bank.getDate();
        for (int i = 0; i < Bank.indexCustomer; i++) {
            indexAccount = Bank.customers[i].checkAccountNumber(accountNumber);
            if (indexAccount != -1) {
                nameAccount = Bank.customers[i].accounts[indexAccount].getName();
                index = i;
                break;
            }
        }
        if (index != -1 && indexAccount != -1 && myDate!=null) {
            if (nameAccount.equals(TypeAccount.LOANACCOUNT.getName()) || nameAccount.equals(TypeAccount.SAVINGACCOUNT.getName())) {
                double amount = Bank.customers[index].accounts[indexAccount].calculateInterest(Bank.customers[index].accounts[indexAccount].getBalance());
                Bank.addTransaction(index,indexAccount,TypeTransaction.INTEREST.getName(),amount,myDate);

                return true;
            }
        }

        return false;
    }

    public void viewTransaction(int index, int indexAccount) {
        Bank.customers[index].printTransactions(indexAccount);

    }


}
