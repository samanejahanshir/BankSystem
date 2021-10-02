package com.jahanshir;

import java.util.Scanner;

public class Bank {
    static Manager manager = new Manager();
    static Customer[] customers = new Customer[100];
    static int indexCustomer = 0;

    public int userMenu() {
        System.out.println("1.manager \n2.customer\n3.exit");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.next();
        if (CheckValidation.checkInt(userInput)) {
            if (Integer.parseInt(userInput) == 1) {
                return 1;
            } else if (Integer.parseInt(userInput) == 2) {
                return 2;
            } else if (Integer.parseInt(userInput) == 3) {
                return 3;
            } else {
                System.out.println("please enter number between 1 - 3 !!");
                return -1;
            }
        } else {
            System.out.println("please enter a number !");
            return -1;
        }
    }

    public void managerMenu() {
        MyDate myDate;
        while (true) {
            System.out.println("1.add new account\n2.view account\n3.with draw\n4.deposit\n5.calculate interests\n6.view transaction\n7.exit");
            Scanner scanner = new Scanner(System.in);
            String itemMenu = scanner.next();
            if (CheckValidation.checkInt(itemMenu)) {

                if (Integer.parseInt(itemMenu) == 1) {
                    String[] name = getCustomerName();
                    int index = checkCustomerExist(name[0], name[1]);
                    if (index != -1) {
                        manager.addNewAccount(index);

                    } else {
                        customers[indexCustomer] = new Customer(name[0], name[1]);
                        manager.addNewAccount(indexCustomer);
                        indexCustomer++;
                    }
                } else if (Integer.parseInt(itemMenu) == 2) {
                    manager.viewAccount();
                } else if (Integer.parseInt(itemMenu) == 3) {
                    System.out.println("enter account number :");
                    String accountNumber = scanner.next();
                    if (CheckValidation.checkInt(accountNumber)) {
                        System.out.println("enter amount :");
                        String amount = scanner.next();
                        String[] name = getCustomerName();
                        int index = checkCustomerExist(name[0], name[1]);
                        myDate = getDate();
                        int indexAccount = customers[index].checkAccountNumber(Integer.parseInt(accountNumber));
                        if (index != -1 && CheckValidation.checkInt(amount) && myDate != null && indexAccount != -1) {
                            if (manager.withDraw(index, Integer.parseInt(accountNumber), Integer.parseInt(amount), myDate)) {
                                System.out.println("withdraw was successfully ! ");
                                addTransaction(index,indexAccount,TypeTransaction.WITHDRAW.getName(),Integer.parseInt(amount),myDate);

                            } else {
                                System.out.println("withdraw was failed ! ");
                            }
                        } else {
                            System.out.println("customer not found ! ");
                        }
                    } else {
                        System.out.println("enter number please !! ");
                    }


                } else if (Integer.parseInt(itemMenu) == 4) {
                    System.out.println("enter account number :");
                    String accountNumber = scanner.next();
                    if (CheckValidation.checkInt(accountNumber)) {
                        System.out.println("enter amount :");
                        String amount = scanner.next();
                        String[] name = getCustomerName();
                        int index = checkCustomerExist(name[0], name[1]);
                        myDate = getDate();
                        int indexAccount = customers[index].checkAccountNumber(Integer.parseInt(accountNumber));
                        if (index != -1 && CheckValidation.checkInt(amount) && myDate != null && indexAccount != -1) {
                            if (manager.deposit(index, Integer.parseInt(accountNumber), Integer.parseInt(amount), myDate)) {
                                System.out.println("deposit was successfully ! ");
                                addTransaction(index,indexAccount,TypeTransaction.DEPOSIT.getName(),Integer.parseInt(amount),myDate);

                            } else {
                                System.out.println("deposit was failed ! ");
                            }
                        } else {
                            System.out.println("customer not found ! ");
                        }
                    } else {
                        System.out.println("enter number please !! ");
                    }

                } else if (Integer.parseInt(itemMenu) == 5) {
                    System.out.println("enter account number :");
                    String accountNumber = scanner.next();
                    if (CheckValidation.checkInt(accountNumber)) {
                        boolean checkCalInterest = manager.calculateInterests(Integer.parseInt(accountNumber));
                        if (checkCalInterest) {
                            System.out.println("calculate interest was successfully.");

                        } else {
                            System.out.println("calculate interest was failed.");

                        }
                    }
                } else if (Integer.parseInt(itemMenu) == 6) {
                    System.out.println("enter account number :");
                    String accountNumber = scanner.next();
                    int indexAccount = -1;
                    for (int i = 0; i < indexCustomer; i++) {
                        indexAccount = customers[i].checkAccountNumber(Integer.parseInt(accountNumber));
                        if (indexAccount != -1) {
                            manager.viewTransaction(i, indexAccount);
                            break;
                        }
                    }
                } else if (Integer.parseInt(itemMenu) == 7) {
                    break;
                }

            } else {
                System.out.println("enter number please !");
            }
        }
    }

    public void customerMenu(int index) {
        MyDate myDate;
        while (true) {
            System.out.println("1.with draw\n2.deposit\n3.getting Inventory\n4.exit");
            Scanner scanner = new Scanner(System.in);
            String itemMenu = scanner.next();
            if (CheckValidation.checkInt(itemMenu)) {

                if (Integer.parseInt(itemMenu) == 1) {
                    System.out.println("enter account number : ");
                    String accountNumber = scanner.next();
                    if (CheckValidation.checkInt(accountNumber)) {
                        if (customers[index].checkAccountNumber(Integer.parseInt(accountNumber)) != -1) {
                            System.out.println("enter amount : ");
                            String amount = scanner.next();
                            int indexAccount = customers[index].checkAccountNumber(Integer.parseInt(accountNumber));
                            if (CheckValidation.checkInt(amount) && indexAccount != -1) {
                                myDate = getDate();
                                if (customers[index].withDraw(Integer.parseInt(amount), Integer.parseInt(accountNumber))) {
                                    System.out.println("withDraw is successfully ");

                                    if (myDate != null) {
                                        addTransaction(index,indexAccount,TypeTransaction.WITHDRAW.getName(),Integer.parseInt(amount),myDate);

                                    } else {
                                        System.out.println("this date is not valid ! ");

                                    }


                                }
                            } else {
                                System.out.println("enter number please !! ");
                            }
                        } else {
                            System.out.println("account not found ! ");

                        }

                    }
                } else if (Integer.parseInt(itemMenu) == 2) {
                    System.out.println("enter account number : ");
                    String accountNumber = scanner.next();
                    if (CheckValidation.checkInt(accountNumber)) {
                        int indexAccount = customers[index].checkAccountNumber(Integer.parseInt(accountNumber));
                        if (indexAccount != -1) {
                            System.out.println("enter amount : ");
                            String amount = scanner.next();
                            if (CheckValidation.checkInt(amount)) {
                                myDate = getDate();
                                if (myDate != null) {
                                    if (customers[index].deposit(Integer.parseInt(amount), Integer.parseInt(accountNumber))) {
                                        System.out.println("deposit is successfully ");
                                        addTransaction(index,indexAccount,TypeTransaction.DEPOSIT.getName(),Integer.parseInt(amount),myDate);

                                    }
                                }
                            } else {
                                System.out.println("enter number please !! ");
                            }
                        } else {
                            System.out.println("account not found ! ");

                        }
                    }else {
                        System.out.println("enter number please !! ");

                    }
                } else if (Integer.parseInt(itemMenu) == 3) {
                    System.out.println("enter account number : ");
                    String accountNumber = scanner.next();
                    int indexAccount=customers[index].checkAccountNumber(Integer.parseInt(accountNumber));
                    myDate=getDate();
                    if (CheckValidation.checkInt(accountNumber) && indexAccount!=-1 && myDate!=null) {
                        System.out.println("balance : " + customers[index].gettingInventory(Integer.parseInt(accountNumber)));
                        addTransaction(index,indexAccount,TypeTransaction.FEES.getName(),7000,myDate);

                    } else {
                        System.out.println("enter number please !! ");

                    }
                } else if (Integer.parseInt(itemMenu) == 4) {
                    break;
                }
            }

        }

    }

    public static String[] getCustomerName() {
        String[] name = new String[2];
        Scanner scanner = new Scanner(System.in);
        System.out.println("first name :");
        name[0] = scanner.next();
        System.out.println("last name :");
        name[1] = scanner.next();
        return name;
    }

    public static int checkCustomerExist(String firstName, String lastName) {
        for (int i = 0; i < Bank.indexCustomer; i++) {
            if (customers[i].getFirstName().equals(firstName) && customers[i].getLastName().equals(lastName)) {
                return i;
            }
        }
        return -1;

    }

    public static boolean getUserNameAndPass() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("userName :");
        String userName = scanner.next();
        System.out.println("password :");
        String password = scanner.next();
        return manager.CheckUserAndPassword(userName, password);
    }

    public static MyDate getDate() {
        MyDate date;
        Scanner scanner = new Scanner(System.in);
        System.out.println("year: ");
        String year = scanner.next();
        System.out.println("month : ");
        String month = scanner.next();
        System.out.println("day : ");
        String day = scanner.next();
        if (CheckValidation.checkInt(year) && CheckValidation.checkInt(month) && CheckValidation.checkInt(day)) {
            date = new MyDate(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
            if (date.isValidDate(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day))) {
                return date;
            }
        } else {
            System.out.println("enter valid date please !! ");
        }
        return null;
    }
    public static void addTransaction(int index,int indexAccount,String typeName,double amount,MyDate myDate){
        customers[index].accounts[indexAccount].transactions[customers[index].accounts[indexAccount].indexTransaction] = new Transaction();
        customers[index].accounts[indexAccount].transactions[customers[index].accounts[indexAccount].indexTransaction].setType(typeName);
        customers[index].accounts[indexAccount].transactions[customers[index].accounts[indexAccount].indexTransaction].setAmount(amount);
        customers[index].accounts[indexAccount].transactions[customers[index].accounts[indexAccount].indexTransaction].setDate(myDate);
        customers[index].accounts[indexAccount].indexTransaction++;
    }

}
