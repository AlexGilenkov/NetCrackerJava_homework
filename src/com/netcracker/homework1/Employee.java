package com.netcracker.homework1;

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
}
