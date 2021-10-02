package com.jahanshir;

public enum TypeAccount {
    CHECKINGACCOUNT("CheckingAccount"),
    LOANACCOUNT("LoanAccount"),
    SAVINGACCOUNT("SavingAccount");
    private String name;

    TypeAccount(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
