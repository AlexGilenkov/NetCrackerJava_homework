package com.netcracker.homework3.workedexample;

public class Manager extends SalariedEmployee{

    private double weeklyBonus;

    public Manager(String name, double salary, double bonus) {
        super(name, salary);
        this.weeklyBonus = bonus;
    }

    @Override
    public double weeklyPay(int hoursWorked) {
        return super.weeklyPay(hoursWorked) + weeklyBonus;
    }
}
