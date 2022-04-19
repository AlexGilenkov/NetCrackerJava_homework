package com.netcracker.homework3;

public class ComboLock {
    private final int limit = 39;
    private int secret1, secret2, secret3;
    private boolean tick1, tick2, tick3;
    private int cur;

    public ComboLock(int secret1, int secret2, int secret3) {
        this.secret1 = secret1;
        this.secret2 = secret2;
        this.secret3 = secret3;
        this.cur = 0;
        tick1 = tick2 = tick3 = false;
    }

    public void reset(){
        this.cur = 0;
    }

    public void turnLeft(int ticks){
        if(ticks>cur){
            ticks %= limit;
        }
        this.cur -= ticks;


        if(this.tick1 && !this.tick2 && !this.tick3
                && this.cur == this.secret2){
            this.tick2 = true;
        }
    }

    public void turnRight(int ticks){
        this.cur += ticks;
        this.cur %= limit;

        if(!this.tick1 && !this.tick2 && !this.tick3 &&
                this.cur == this.secret1){
            this.tick1 = true;
        }
        if(this.tick2 && this.tick1 && !this.tick3 &&
                this.cur == this.secret3){
            this.tick3 = true;
        }
    }

    public boolean open(){
        return this.tick1 && this.tick2 && this.tick3;
    }
}
