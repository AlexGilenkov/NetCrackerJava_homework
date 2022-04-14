package com.netcracker.homework2.chapter2;

public final class Car {
    private float x = 0.0f; //miles
    private float efficiency = 0.0f; // gallons/mile
    private float gas = 0.0f; // gallons

    public Car(float efficiency) {
        this.x = x;
        this.efficiency = efficiency;
        this.gas = gas;
    }

    public Car(float x, float efficiency, float gas) {
        this.x = x;
        this.efficiency = efficiency;
        this.gas = gas;
    }

    public void drive(float miles){
        if(this.gas < this.efficiency*miles) {
            System.out.println("Need charging!");
            chargeGas(Math.abs(miles));
        }
        this.gas = this.gas - this.efficiency * Math.abs(miles);
        this.x += miles;
    }

    private void chargeGas(float miles){
        System.out.println("Gas before charging:" + gas);
        this.gas = this.gas + this.efficiency * miles;
        System.out.println("Gas after charging" + gas);
    }

    public float getX() {
        return x;
    }

    public float getEfficiency() {
        return efficiency;
    }

    public float getGas() {
        return gas;
    }

    @Override
    public String toString() {
        return "Car{" +
                "x=" + x +
                ", efficiency=" + efficiency +
                ", gas=" + gas +
                '}';
    }
}
