package com.netcracker.homework1;

import java.util.Objects;

public class Employee {
    private int id;
    private String firstname;
    private String lastName;
    private int salary;

    public Employee(int id, String firstname, String lastName,
                    int salary) {
        this.id = id;
        this.firstname = firstname;
        this.lastName = lastName;
        this.salary = salary;
    }

    public String getName(){
        return firstname+" "+lastName;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastName() {
        return lastName;
    }

    public int getSalary() {
        return salary;
    }

    public int getAnnualSalary(){
        return salary*12;
    }

    public int raiseSalary(int percent){
        salary += salary/100*percent;
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salary=" + salary +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id && salary == employee.salary && Objects.equals(firstname, employee.firstname)
                && Objects.equals(lastName, employee.lastName);
    }

    @Override
    public int hashCode() {
        int result = 17;

        result = 31*result + id;
        result = 31*result + salary;
        result = 31*result + firstname.hashCode();
        result = 31*result + lastName.hashCode();

        return result;
    }
}
