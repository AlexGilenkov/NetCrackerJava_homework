package com.netcracker.homework3.cclock;

import java.time.LocalTime;

public class WorldClock extends Clock{

    private int timeOffset = 0;

    public WorldClock(int offset) {
        this.timeOffset = offset;
    }

    @Override
    protected int getHours() {
        String str = LocalTime.now().toString();

        str = str.substring(0, 2);

        return Integer.parseInt(str) + timeOffset;
    }

//    @Override
//    protected int getMinutes() {
//        String str = LocalTime.now().toString();
//
//        str = str.substring(3, 5);
//
//        return Integer.parseInt(str);
//    }
}
