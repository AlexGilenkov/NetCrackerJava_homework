package com.netcracker.homework1;

public class Circle {
    private float radius = 1.0f;
    private String color = "red";

    public Circle(){}
    public Circle(float radius) {
        this.radius = radius;
    }
    public Circle(float radius, String color){
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Circle circle = (Circle) o;
        return Double.compare(circle.radius, radius) == 0 && this.color.equals(circle.color);
    }

    @Override
    public int hashCode() {
        int result = 17;

        result = 31*result + Float.floatToIntBits(radius);
        result = 31*result + this.color.hashCode();

        return result;
    }

    //===================================================================
    public float getRadius() {
        return radius;
    }
    public void setRadius(float radius) {
        this.radius = radius;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
}
