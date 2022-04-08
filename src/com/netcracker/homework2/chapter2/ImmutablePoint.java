package com.netcracker.homework2.chapter2;

public final class ImmutablePoint {
    private float x = 0.0f;
    private float y = 0.0f;

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
        return new ImmutablePoint(this.x += x, this.y += y);
    }

    public ImmutablePoint scale (float coeff){
        return new ImmutablePoint(this.x *= coeff, this.y *= coeff);
    }
}
