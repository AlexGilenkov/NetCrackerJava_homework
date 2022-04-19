package com.netcracker.homework3;

public class Battery {
    private double capacity;
    private double currentCapacity;

    public Battery(double capacity) {
        this.capacity = capacity;
        this.currentCapacity = capacity;
    }

    public void drain(double amount){
        if(this.currentCapacity<amount) {
            this.currentCapacity = 0;
            return;
        }
        this.currentCapacity -= amount;
    }

    public void charge(){
        this.currentCapacity = capacity;
    }

    public double getRemainingCapacity(){
        return this.currentCapacity;
    }

}
