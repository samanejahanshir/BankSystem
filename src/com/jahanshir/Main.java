package com.jahanshir;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Bank bank = new Bank();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int userSelect = bank.userMenu();
            if (userSelect != -1) {
                if (userSelect == 1) {
                    if (Bank.getUserNameAndPass()) {
                        bank.managerMenu();
                    } else {
                        System.out.println("userName or password is wrong !");
                    }
                } else if (userSelect == 2) {
                    String[] name=Bank.getCustomerName();
                    int index=Bank.checkCustomerExist(name[0],name[1]);
                    if (index!=-1) {
                        bank.customerMenu(index);
                    } else {
                        System.out.println("user with this name not found !");

                    }
                }
                else if(userSelect==3){
                    break;
                }
            }
        }
    }



}
