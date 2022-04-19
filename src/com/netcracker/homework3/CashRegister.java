package com.netcracker.homework3;

/*
    programming project 3.1 and 3.2
*/

public class CashRegister {
    private double purchase;
    private double payment;
    private double taxRate;
    private double totalTax = 0.0d;
    private int itemCount;


    public CashRegister(double taxRate) {
        this.taxRate = taxRate;
        this.itemCount = 0;
    }

    public void recordPurchase(double amount){
        this.purchase += amount;
        this.itemCount++;
    }

    public void receivePayment(double amount){
        this.payment += amount;
    }

    public double giveChange(){
        if(payment >= (purchase+totalTax)) {
            double change = payment - purchase - totalTax;
            purchase = 0;
            payment = 0;
            itemCount = 0;
            return change;
        }
        System.out.println("GIVE ME YOUR MONEY!!!");
        return -1;
    }

    public void recordTaxablePurchase(double amount){
        this.purchase = purchase + amount;
        this.totalTax += amount * taxRate/100;
        this.itemCount++;
    }

    public int getItemCount() {
        return itemCount;
    }

    public double getTotalTax() {
        return totalTax;
    }
}
