package com.netcracker.homework2;

import java.util.Arrays;

public class MyPolynomial {
    private double[] coeffs;

    public MyPolynomial(double[] coeffs) {
        this.coeffs = coeffs;
    }

    public int getDegree(){
        return coeffs.length-1;
    }

    @Override
    public String toString() {
        String str="";
        for(int i=coeffs.length-1;i>=0;i--){
            if(coeffs[i]==0)
                continue;
            if(i>0) {
                str = str + coeffs[i] + "x^" + i;
                str += '+';
            }
            if(i == 0)
                str+= coeffs[i];
        }
        return str;
    }

    public MyPolynomial add(MyPolynomial  right){
        int len = 0;
        if (this.coeffs.length > right.coeffs.length)
            len = this.coeffs.length;
        else
            len = right.coeffs.length;

        MyPolynomial result = new MyPolynomial(new double[len]);
        for(int i=0;i<len;i++){
            result.coeffs[i] = this.coeffs[i] + right.coeffs[i];

            if(i+1==this.coeffs.length || i+1==right.coeffs.length)
                break;
        }

        return result;
    }

    public MyPolynomial multiply(MyPolynomial right){
        int len = this.coeffs.length+right.coeffs.length;

        MyPolynomial result = new MyPolynomial(new double[len]);

        /* TODO: realisation! */

        return result;
    }

    public double evaluate(double x){
        /* TODO: what is it?! And realisation! */
        return 0.0d;
    }

}
