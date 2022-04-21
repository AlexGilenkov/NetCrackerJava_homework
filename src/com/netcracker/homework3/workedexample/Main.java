package com.netcracker.homework3.workedexample;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Employee[] staff = new Employee[3];
        staff[0] = new HourlyEmployee("Morgan, Harry", 30);
        staff[1] = new SalariedEmployee("Lin, Sally", 52000);
        staff[2] = new Manager("Smith, Mary", 104000, 50);

        Scanner in = new Scanner(System.in);
        for(Employee e : staff){
            System.out.println("Hours worked by "+ e.getName() + ":");
            int hours = in.nextInt();
            System.out.println("Salary: "+e.weeklyPay(hours));

        }

    }
}
