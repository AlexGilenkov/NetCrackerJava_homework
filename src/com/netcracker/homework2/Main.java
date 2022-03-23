package com.netcracker.homework2;

import com.netcracker.homework1.MyTriangle;

public class Main {
    public static void main(String[] args) {
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
