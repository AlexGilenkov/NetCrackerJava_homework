package com.netcracker.homework3;

/*
    Programming project 3.6 , 3.7
 */


public class Person {
    private String name;
    private String friendNames = "";
    private int friendCount = 0;

    public Person(String name) {
        this.name = name;
    }

    public void befriend(Person p){
        this.friendNames = this.friendNames + p.name + " ";
        this.friendCount++;
    }

    public void unfriend(Person p){
        if(friendNames.equals("")){
            System.out.println("I'm haven't friends =(");
            return;
        }

        String[] friends = friendNames.split(" ");
        for(int i=0; i<friends.length;i++){
            if(friends[i].equals(p.name)){
                friends[i] = "";
                friendCount--;
            }
        }
        this.friendNames = "";
        for(String s: friends){
            friendNames = friendNames + s + " ";
        }
    }

    public String getFriendNames(){
        return friendNames;
    }

    public int getFriendCount() {
        return friendCount;
    }
}
