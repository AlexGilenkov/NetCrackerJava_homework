package com.netcracker.homework2;

public class MyComplex {
    private double real = 0.0d;
    private double imag = 0.0d;

    final double EPS = 0.01d;

    public MyComplex() {
    }

    public MyComplex(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public double getImag() {
        return imag;
    }

    public void setImag(double imag) {
        this.imag = imag;
    }

    public void setValue(double real, double imag){
        this.real = real;
        this.imag = imag;
    }

    @Override
    public String toString() {
        if (imag < 0) {
            return "(" + real +  imag + "i)";
        }
        return "(" + real + '+' + imag + "i)";
    }

    public boolean isReal(){
        return (real!=0.0d);
    }

    public boolean isImaginary(){
        return (imag!=0.0d);
    }

    public boolean equals(MyComplex another) {
        return (Math.abs(this.real- another.real)<EPS &&
                Math.abs(this.imag- another.imag)<EPS);
    }

    public boolean equals(double real, double imag) {
        return (Math.abs(this.real- real)<EPS &&
                Math.abs(this.imag- imag)<EPS);
    }

    public double magnitude(){
        return Math.sqrt(Math.pow(real,2)+Math.pow(imag,2));
    }

    public double argument(){
        if(!isReal()&&!isImaginary()) {
            System.out.println("Argument not defined!");
            return -1;
        }
        return Math.toRadians(Math.atan2(real, imag));
    }

    public MyComplex add(MyComplex right){
        this.setReal(this.real+right.real);
        this.setImag(this.imag+right.imag);
        return this;
    }

    public MyComplex addNew(MyComplex right){
        MyComplex result = new MyComplex(
                this.real+right.real, this.imag+right.imag);
        return result;
    }

    public MyComplex substract(MyComplex right){
        this.setReal(this.real-right.real);
        this.setImag(this.imag-right.imag);
        return this;
    }

    public MyComplex substractNew(MyComplex right){
        MyComplex result = new MyComplex(
                this.real-right.real, this.imag-right.imag);
        return result;
    }

    public MyComplex multiply(MyComplex right){
        double newReal, newImag;

        newReal = this.real* right.real - this.imag*right.imag;
        newImag = this.real* right.imag + right.real*this.imag;

        this.setValue(newReal,newImag);
        return this;
    }

    public MyComplex divide(MyComplex right){
        double newReal, newImag;

        newReal = (this.real* right.real+ this.imag*right.imag)
                /(Math.pow(right.real, 2) + Math.pow(right.imag, 2));
        newImag = (this.imag* right.real - this.real* right.imag)
                /(Math.pow(right.real, 2) + Math.pow(right.imag, 2));

        this.setValue(newReal, newImag);
        return this;
    }

    public MyComplex conjugate(){
        return new MyComplex(this.real, this.imag*-1);
    }
}
