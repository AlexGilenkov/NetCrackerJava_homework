package com.netcracker.homework3.workedexample;

public class SalariedEmployee extends Employee{
    private double annualSalary;

    public SalariedEmployee(String name, double salary) {
        super(name);
        this.annualSalary = salary;
    }

    @Override
    public double weeklyPay(int hoursWorked) {
        final int WEEKS_PER_YEAR = 52;
        return annualSalary / WEEKS_PER_YEAR;
    }
}
