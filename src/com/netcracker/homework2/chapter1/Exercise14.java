package com.netcracker.homework2.chapter1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Exercise14 {
    /*
    Write a program that reads a two-dimensional array of integers and determines
    whether it is a magic square (that is, whether the sum of all
    rows, all columns, and the diagonals is the same). Accept lines of input
    that you break up into individual integers, and stop when the user enters
    a blank line. For example, with the input
    16 3 2 13
    5 10 11 8
    9 6 7 12
    4 15 14 1
    (Blank line)
    your program should respond affirmatively.
     */

    public static void magicSquare(){

        List<String> list = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        String buf;
        while(true){
            buf = scanner.nextLine();
            if(buf.equals("")) break;
            list.add(buf);
        }
        scanner.close();

        int[][] square = new int[list.size()][];

        {
            int i = 0;
            for (String s : list) {
                scanner = new Scanner(s);
                String strArr[] = s.split(" ");
                square[i] = new int[strArr.length];
                for (int j = 0; j < strArr.length; j++) {
                    square[i][j] = Integer.parseInt(strArr[j]);
                }
                ++i;
            }
            scanner.close();
        }

        {
            // is square?!
            for(int i=0;i< square.length;i++){
                if(square[i].length != square.length){
                    System.out.println("Is not square! Is shit!");
                    return;
                }
            }
        }

        int sum = Arrays.stream(square[0]).sum();
        int sumDiag = 0;

        for(int i = 0; i < square.length;i++){
            if(Arrays.stream(square[i]).sum() != sum){
                System.out.println("Is not magic square!");
                return;
            }
            int temp = 0;
            for(int j = 0; j < square.length;temp += square[i][j], j++)
                if(i == j)
                    sumDiag = sumDiag+square[i][j];
            if(temp != sum){
                System.out.println("Is not magic square!");
                return;
            }
        }

        if(sum != sumDiag){
            System.out.println("Is not magic square!");
            return;
        }

        for(int k =0; k<square.length;k++){
            System.out.println(Arrays.toString(square[k]));
        }

        System.out.println("IS MAGIC SQUARE!!! SUCCESS!!!");

    }
}
