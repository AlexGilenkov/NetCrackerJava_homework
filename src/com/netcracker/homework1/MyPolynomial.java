package com.netcracker.homework1;

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
            if(i>1) {
                str = str + coeffs[i] + "x^" + i;
                str += '+';
            }
            if(i==1){
                str = str + coeffs[i] + "x";
                str += '+';
            }
            if(i == 0)
                str += coeffs[i];
        }
        if(str.charAt(str.length()-1)=='+'){
            String res = str.substring(0, str.length()-1);
            return res;
        }
        return str;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyPolynomial that = (MyPolynomial) o;
        return Arrays.equals(coeffs, that.coeffs);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(coeffs);
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

            if(i+1==this.coeffs.length) {
                for(int j=i+1;j<len;j++){
                    result.coeffs[j] = right.coeffs[j];
                }
                break;
            }
            if(i+1==right.coeffs.length){
                for(int j=i+1;j<len;j++){
                    result.coeffs[j] = this.coeffs[j];
                }
                break;
            }
        }

        return result;
    }

    public MyPolynomial multiply(MyPolynomial right){
        int len = this.coeffs.length+right.coeffs.length;
        double tempCoeff = 0;

        MyPolynomial result = new MyPolynomial(new double[len]);

        for(int i=0; i<this.coeffs.length; i++){
            for(int j=0; j<right.coeffs.length; j++){
                tempCoeff = this.coeffs[i] * right.coeffs[j];
                result.coeffs[i+j] += tempCoeff;
            }
        }

        return result;
    }

    public double evaluate(double x){
        double result=0;

        for(int i=0;i<this.coeffs.length;i++){
            result += this.coeffs[i]*Math.pow(x, i);
        }

        return result;
    }

}
