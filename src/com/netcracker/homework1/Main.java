package com.netcracker.homework1;

import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {
        testCircle();
        System.out.println("======================================");
        testRectangle();
        System.out.println("======================================");
        testEmployee();
        System.out.println("======================================");
    }

    public static void testCircle(){
        System.out.println("****************");
        System.out.println("***testCircle***");
        System.out.println("****************");

        Circle circle = new Circle();
        Circle circle1 = new Circle(32);
        Circle circle2 = new Circle(12, "white");

        System.out.println(circle);
        System.out.println("Area of circle=" + circle.getArea());

        System.out.println(circle1);
        System.out.println("Area of circle=" + circle1.getArea());

        System.out.println(circle2);
        System.out.println("Area of circle=" + circle2.getArea());
    }

    public static void testRectangle() {
        System.out.println("*******************");
        System.out.println("***testRectangle***");
        System.out.println("*******************");

        Rectangle rectangle = new Rectangle();
        Rectangle rectangle1 = new Rectangle(5, 3);

        System.out.println(rectangle);
        System.out.println("Perimeter =" + rectangle.getPerimeter());
        System.out.println("Area=" + rectangle.getArea());

        System.out.println(rectangle1);
        System.out.println("Perimeter=" + rectangle1.getPerimeter());
        System.out.println("Area=" + rectangle1.getArea());
    }

    public static void testEmployee(){
        System.out.println("******************");
        System.out.println("***testEmployee***");
        System.out.println("******************");

        Employee employee = new Employee(
                1, "Ivan", "Ivanov", 30000);
        System.out.println(employee);
        System.out.println("Name: "+employee.getName());
        System.out.println("Salary ="+employee.getSalary());
        System.out.println("Annual salary ="+employee.getAnnualSalary());
        System.out.println("Raising salary on 30%");
        System.out.println("New salary =" + employee.raiseSalary(30));
        System.out.println("New annual salary =" + employee.getAnnualSalary());
    }

    public static void testBook(){
        System.out.println("**************");
        System.out.println("***testBook***");
        System.out.println("**************");

        Book book = new Book("Thinking in Java",
                new Author[]{new Author("Bruce Ekkel", 'M')},
                1000 );
        Book book1 = new Book("Computer architecture",
                new Author[]{new Author()})
    }
}
