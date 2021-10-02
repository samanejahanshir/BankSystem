package com.jahanshir;

public class Transaction {
    private String type;
    private double amount;
    private MyDate date;

    public void setType(String type) {
        this.type = type;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setDate(MyDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "typeTransaction : " + type
                + "  amount : " + amount +" R "
                + "  Date : " + date.toString();

    }
}
