package com.netcracker.homework1;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        testCircle();
        System.out.println("======================================");
        testRectangle();
        System.out.println("======================================");
        testEmployee();
        System.out.println("======================================");
        testBook();
        System.out.println("======================================");
        testMyPoint();
        System.out.println("======================================");
        testMyTriangle();
        System.out.println("======================================");
        testMyComplex();
        System.out.println("========================================");
        testMyPolinomial();
        System.out.println("========================================");
        testBall();
        System.out.println("========================================");
        testContainer();
        System.out.println("========================================");
        System.out.println("THE END");
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
                new Author[]{new Author("John L Hennessy", 'M'),
                             new Author("David A Patterson", 'M')},
                2500);

        System.out.println(book);
        System.out.println("Name:"+book.getName());
        System.out.println("Authors:"+book.getAuthorNames());
        System.out.println("Price ="+book.getPrice());
        System.out.println();
        System.out.println(book1);
        System.out.println("Name:"+book1.getName());
        System.out.println("Authors:"+book1.getAuthorNames());
        System.out.println("Price ="+book1.getPrice());
    }

    public static void testMyPoint(){
        System.out.println("*****************");
        System.out.println("***testMyPoint***");
        System.out.println("*****************");

        MyPoint point1 = new MyPoint(0,0);
        MyPoint point2 = new MyPoint(3,4);

        System.out.println("First point: "+point1);
        System.out.println(Arrays.toString(point1.getXY()));
        System.out.println("Second point: "+point2);
        System.out.println(Arrays.toString(point2.getXY()));

        System.out.println("Distance1 =" + point1.distance(point2));
        System.out.println("Distance2 =" + point1.distance(point2.getX(), point2.getY()));
        System.out.println("Distance3 =" + point2.distance());
    }

    public static void testMyTriangle(){
        System.out.println("********************");
        System.out.println("***testMyTriangle***");
        System.out.println("********************");

        MyTriangle triangle1 = new MyTriangle(
                0,0,0,3,4,0);
        MyTriangle triangle2 = new MyTriangle(
                new MyPoint(0,0), new MyPoint(0,4), new MyPoint(4,0));

        System.out.println(triangle1);
        System.out.println("Perimeter ="+triangle1.getPerimeter());
        System.out.println("Type of triangle: "+ triangle1.getType());

        System.out.println(triangle2);
        System.out.println("Perimeter ="+triangle2.getPerimeter());
        System.out.println("Type of triangle: "+ triangle2.getType());


    }

    public static void testMyComplex(){
        System.out.println("*******************");
        System.out.println("***TestMyComplex***");
        System.out.println("*******************");

        MyComplex complex1 = new MyComplex(3,9);
        MyComplex complex2 = new MyComplex(2, 7);

        System.out.println("Первое число: "+ complex1);
        System.out.println("Второе число: "+ complex2);
        System.out.println("Сумма ="+ complex1.addNew(complex2));
        System.out.println("Разность =" + complex1.substractNew(complex2));
        // Так как в функциях возвращается this, создаем копию
        MyComplex temp = new MyComplex(complex1.getReal(), complex1.getImag());
        System.out.println("Произведение ="+ temp.multiply(complex2));
        temp = new MyComplex(complex1.getReal(), complex1.getImag());
        System.out.println("Частное =" + complex1.divide(complex2));

    }

    public static void testMyPolinomial(){
        System.out.println("**********************");
        System.out.println("***TestMyPolinomial***");
        System.out.println("**********************");

        MyPolynomial polynomial1 = new MyPolynomial(new double[]{3, 0, 8, 0,5});
        MyPolynomial polynomial2 = new MyPolynomial(new double[]{0,9, 0, 3, 0,5});

        System.out.println("Первый полином: "+polynomial1);
        System.out.println("Степень полинома = "+ polynomial1.getDegree());
        System.out.println("Значение при х=1: "+polynomial1.evaluate(1));
        System.out.println("Второй полином: "+polynomial2);
        System.out.println("Степень полинома = "+ polynomial2.getDegree());
        System.out.println("Значение при х=1: "+polynomial2.evaluate(1));
        System.out.println("Сумма полиномов: " +polynomial1.add(polynomial2));
        MyPolynomial polynomial3 = polynomial1.multiply(polynomial2);
        System.out.println("Произведение полиномов: "+polynomial3);
    }

    public static void testBall(){
        System.out.println("**************");
        System.out.println("***TestBall***");
        System.out.println("**************");

        Ball ball = new Ball(0,0,1,1,45);

        System.out.println(ball);
        System.out.println("Мяч делает ход...");
        ball.move();
        System.out.println(ball);
        System.out.println("Мяч делает ход...");
        ball.move();
        System.out.println(ball);
        System.out.println("Мяч поменял направление по горизонтали и делает ход...");
        ball.reflectHorizontal();
        ball.move();
        System.out.println(ball);
        System.out.println("Мяч поменял направление по вертикали и делает ход...");
        ball.reflectVertical();
        ball.move();
        System.out.println(ball);


    }

    public static void testContainer(){
        System.out.println("*******************");
        System.out.println("***TestContainer***");
        System.out.println("*******************");

        Container container = new Container(0,0, 5, 5);
        Ball ball = new Ball(2.5f,2.5f,2,0,0);
        Ball ball1 = new Ball(2.5f,2.5f,3,0,0);
        Ball ball2 = new Ball(2.5f,2.5f,2,1, 45);

        System.out.println(container);
        System.out.println(ball);
        System.out.println("Мяч в контейнере? = " + container.collides(ball));

        System.out.println("---------------------------------------------");

        System.out.println(container);
        System.out.println(ball1);
        System.out.println("Мяч в контейнере? = " + container.collides(ball1));

        System.out.println("---------------------------------------------");

        System.out.println(container);
        System.out.println(ball2);
        System.out.println("Мяч в контейнере? = " + container.collides(ball2));
        System.out.println("Мяч делает ход...");
        ball2.move();
        System.out.println(ball2);
        System.out.println("Мяч в контейнере? = " + container.collides(ball2));

    }
}
