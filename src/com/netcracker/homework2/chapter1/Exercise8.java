package com.netcracker.homework2.chapter1;

public class Exercise8 {
    /*
    Write a program that reads a string and prints all of its non-empty substrings.
     */

    public static void substrings (String str){
        if(str == null) {
            System.out.println("String is null");
            return;
        }
        if(str.equals("")) {
            System.out.println("Empty string");
            return;
        }
        for(int i = 1; i <= str.length(); i++){
            for(int j = 0; j + i <= str.length(); j++){
                System.out.println(str.substring(j, j+i));
            }
        }
    }
}
