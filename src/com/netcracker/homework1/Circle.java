package com.netcracker.homework1;

public class Circle {
    private double radius = 1.0d;
    private String color = "red";

    public Circle(){}
    public Circle(double radius) {
        this.radius = radius;
    }
    public Circle(double radius, String color){
        this.color = color;
        this.radius = radius;
    }

    public double getArea() {
        return Math.pow(radius,2)*Math.PI;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                ", color='" + color + '\'' +
                '}';
    }
    //===================================================================
    public double getRadius() {
        return radius;
    }
    public void setRadius(double radius) {
        this.radius = radius;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
}
