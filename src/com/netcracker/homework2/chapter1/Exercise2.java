package com.netcracker.homework2.chapter1;

public class Exercise2 {
     /*
    Write a program that reads an integer angle (which may be positive or negative)
    and normalizes it to a value between 0 and 359 degrees.
    Try it first with the % operator, then with floorMod.
     */
    private static final int PI2 = 360;

    public static int normalizesAngle (int angle) {

        int result;

        result = angle % PI2;

        return (result<0)? result+360 : result;
    }

    public static int normalizesAngleWithFloorMod (int angle) {

        int result;

        result = Math.floorMod(angle, PI2);

        return (result<0)? result+360 : result;
    }
}
