package com.netcracker.homework1;


import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyTriangle triangle = (MyTriangle) o;
        return Objects.equals(v1, triangle.v1) && Objects.equals(v2, triangle.v2) && Objects.equals(v3, triangle.v3);
    }

    @Override
    public int hashCode() {
        int result = 17;

        result = 31*result + v1.hashCode();
        result = 31*result + v2.hashCode();
        result = 31*result + v3.hashCode();

        return result;
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
