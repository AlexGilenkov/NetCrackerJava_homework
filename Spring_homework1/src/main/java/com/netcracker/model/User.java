package com.netcracker.model;

import java.util.Objects;

public class User {
    private String firstName;
    private String lastName;
    private String patronymic;
    private int age;
    private double salary;
    private String email;
    private String workPlace;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWorkPlace() {
        return workPlace;
    }

    public void setWorkPlace(String workPlace) {
        this.workPlace = workPlace;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age && firstName.equals(user.firstName) && lastName.equals(user.lastName) && Objects.equals(patronymic, user.patronymic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, patronymic, age);
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", email='" + email + '\'' +
                ", workPlace='" + workPlace + '\'' +
                '}';
    }

    public String toWritingInFile() {
        return firstName+","+lastName+","+patronymic+","+age+","
                +salary+","+email+","+workPlace+";";
    }

    public User parseUser(String str){
        String[] strings = str.split(",");
        this.firstName = strings[0];
        this.lastName = strings[1];
        this.patronymic = strings[2];
        this.age = Integer.parseInt(strings[3]);
        this.salary = Double.parseDouble(strings[4]);
        this.email = strings[5];
        this.workPlace = strings[6].substring(0, strings[6].length()-1);
        return this;
    }
}
