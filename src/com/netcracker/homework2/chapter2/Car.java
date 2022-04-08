package com.netcracker.homework2.chapter2;

public final class Car {
    private float x = 0.0f;
    private float efficiency = 0.0f;
    private float gas = 0.0f;

    public Car(float x, float efficiency, float gas) {
        this.x = x;
        this.efficiency = efficiency;
        this.gas = gas;
    }
    // TODO: Спросить что это и с чем едят
    public void drive(){}


    public float getX() {
        return x;
    }

    public float getEfficiency() {
        return efficiency;
    }

    public float getGas() {
        return gas;
    }
}
