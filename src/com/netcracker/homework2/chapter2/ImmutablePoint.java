package com.netcracker.homework2.chapter2;

public final class ImmutablePoint {
    private final float x;
    private final float y;

    public ImmutablePoint(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public ImmutablePoint translate(float x, float y){
        float newX, newY;
        newX = this.getX() +x;
        newY = this.getY() +y;
        ImmutablePoint temp = new ImmutablePoint(newX, newY);

        return temp;
    }

    public ImmutablePoint scale (float coeff){
        float newX, newY;
        newX = this.getX() * coeff;
        newY = this.getY() * coeff;
        ImmutablePoint temp = new ImmutablePoint(newX, newY);

        return temp;
    }

    @Override
    public String toString() {
        return "ImmutablePoint{" + x +"," + y +
                '}';
    }
}
