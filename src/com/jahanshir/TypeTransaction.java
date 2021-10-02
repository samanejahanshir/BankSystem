package com.jahanshir;

public enum TypeTransaction {
    WITHDRAW("WithDraw"),
    DEPOSIT("Deposit"),
    INTEREST("Interest"),
    FEES("Fees");
    private String name;

    TypeTransaction(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
