package com.netcracker.homework3.cclock;

import java.time.LocalTime;

public class Clock {

    private String alarm;

    public void setAlarm(int hours, int minutes){
        String str = hours+":"+minutes;

        this.alarm = str;
    }

    public String getTime(){
        String time = getHours()+":"+getMinutes();

        if(time.equals(alarm))
            System.out.println("ALARM!");
        else
            if(alarm != null)
                System.out.println("Alarm in: " + this.alarm);

        return time;
    }

    protected int getHours(){
        String str = LocalTime.now().toString();

        str = str.substring(0, 2);

        return Integer.parseInt(str);
    }

    protected int getMinutes(){
        String str = LocalTime.now().toString();

        str = str.substring(3, 5);

        return Integer.parseInt(str);
    }

}
