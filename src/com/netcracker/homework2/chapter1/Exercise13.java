package com.netcracker.homework2.chapter1;

import java.util.Arrays;
import java.util.Random;

public class Exercise13 {
    /*
    Write a program that prints a lottery combination, picking six distinct
    numbers between 1 and 49. To pick six distinct numbers, start with an
    array list filled with 1...49. Pick a random index and remove the element.
    Repeat six times. Print the result in sorted order.
     */

    public static void getLotteryCombination(){

        int[] table = new int[50];

        for(int i=0;i<table.length;i++)
            table[i] = i;

        Random random = new Random();

        int[] result = new int[6];
        int temp = 0;
        for(int i = 0; i < result.length; temp = 0, i++){
             while(temp == 0 || table[temp] == 0){
                 temp = random.nextInt(table.length);
             }
             result[i] = temp;
             table[temp] = 0;
        }

        Arrays.sort(result);

        System.out.println(Arrays.toString(result));

    }



}
