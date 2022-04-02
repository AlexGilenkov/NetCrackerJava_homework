package com.netcracker.homework1;

import java.util.Objects;

public class Rectangle {
    private float length = 1.0f;
    private float width = 1.0f;

    public Rectangle(){}
    public Rectangle(float length, float width) {
        this.length = length;
        this.width = width;
    }

    public double getArea(){
        return length*width;
    }
    public double getPerimeter(){
        return (length+width)*2;
    }

    @Override
    public String toString() {
        return "Rectangle[length="+ length+ ",width="+ width+ "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle rectangle = (Rectangle) o;
        return Float.compare(rectangle.length, length) == 0 && Float.compare(rectangle.width, width) == 0;
    }

    @Override
    public int hashCode() {
        int result = 17;

        result = 31*result + Float.floatToIntBits(length);
        result = 31*result + Float.floatToIntBits(width);

        return result;
    }

    //=====SETTERS=AND=GETTERS================

    public float getLength() {
        return length;
    }
    public void setLength(float length) {
        this.length = length;
    }
    public float getWidth() {
        return width;
    }
    public void setWidth(float width) {
        this.width = width;
    }
}
