package com.netcracker.homework2.chapter1;

import java.math.BigInteger;

public class Exercise6 {

    /*
    Write a program that computes the factorial n! = 1 × 2 × . . . × n,
    using BigInteger. Compute the factorial of 1000.
     */

    public static String factorial(int val){

        if(val<=0){
            return "Wrong number";
        }

        BigInteger bigInteger = BigInteger.valueOf(1);

        for(int i=2; i<=val;i++){
            bigInteger = bigInteger.multiply(BigInteger.valueOf(i));
        }

        return bigInteger.toString();

    }

}
