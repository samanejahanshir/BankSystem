package com.jahanshir;

public class LoanAccount extends Account{
    private double loan;
    private final double interest;
    private int loanDuration;
private int numberOfInstallment=0;

    public LoanAccount(String name, int accountNumber, double balance, MyDate createDate, double loan, double interest, int loanDuration) {
        super(name, accountNumber, balance, createDate);
        this.loan = loan;
        this.interest = interest;
        this.loanDuration = loanDuration;
    }

    @Override
    public double calculateInterest(double amount) {
        if (numberOfInstallment<= loanDuration) {
            double gains=(loan*interest*(loanDuration+1))/2400;
            double installment =(loan+(gains))/loanDuration;
            numberOfInstallment++;
            return installment;

        }else {
            return -1;
        }    }

    @Override
    public String toString() {
        return super.toString()+"  loan: "+loan
                +"  interest: "+interest
                +"  loanDuration: "+loanDuration;
    }
}
