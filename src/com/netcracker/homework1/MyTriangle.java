package com.netcracker.homework1;


public class MyTriangle {
    private MyPoint v1;
    private MyPoint v2;
    private MyPoint v3;

    private final double EPS = 0.01d; // Переменная, задающая точность для сравнения расстояний

    public MyTriangle(MyPoint v1, MyPoint v2, MyPoint v3) {
        this.v1 = v1;
        this.v2 = v2;
        this.v3 = v3;
    }


    public MyTriangle(int x1, int y1,
                      int x2, int y2,
                      int x3, int y3){
        this.v1 = new MyPoint(x1,y1);
        this.v2 = new MyPoint(x2,y2);
        this.v3 = new MyPoint(x3,y3);
    }

    @Override
    public String toString() {
        return "MyTriangle{" +
                "v1=" + v1 +
                ", v2=" + v2 +
                ", v3=" + v3 +
                '}';
    }

    public double getPerimeter(){
        return v1.distance(v2)+v2.distance(v3)+ v1.distance(v3);
    }

    public String getType(){
        double first = v1.distance(v2);
        double second = v1.distance(v3);
        double third = v2.distance(v3);

        boolean equalsFirstSecond, equalsSecondThird, equalsThirdFirst;

        equalsFirstSecond = Math.abs(first - second) <=EPS;
        equalsSecondThird = Math.abs(second - third) <=EPS;
        equalsThirdFirst = Math.abs(first - third) <=EPS;

        if(equalsFirstSecond && equalsSecondThird && equalsThirdFirst)
            return "Equilateral";
        if(equalsFirstSecond || equalsSecondThird || equalsThirdFirst)
            return "Isosceles";
        return "Scalene";
    }

}
