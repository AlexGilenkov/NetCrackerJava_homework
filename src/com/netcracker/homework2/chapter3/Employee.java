package com.netcracker.homework2.chapter3;

public class Employee implements Measurable{
    private int salary;
    private String name;

    public Employee(int salary, String name) {
        this.salary = salary;
        this.name = name;
    }

    @Override
    public double getMeasure() {
        return salary;
    }

    public static double average(Measurable[] objects){
        double avg =0;

        for(Measurable o: objects){
            avg += o.getMeasure();
        }

        return avg/ objects.length;
    }

    public static int largest(Measurable[] objects){
        int larg =0;

        for(Measurable o: objects){
            if(larg < o.getMeasure())
                larg = (int) o.getMeasure();
        }

        return larg;
    }
}
