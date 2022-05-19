package com.netcracker.homework4;

import com.netcracker.homework1.Circle;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        /*
        MyLinkedList<String> list = new MyLinkedList<>();
        list.add("Hello");
        list.add("World");
        list.add("!");
        System.out.println(list);
        System.out.println(list.size());
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
        System.out.println(list.indexOf("World"));
        Object[] array = list.toArray();
        System.out.println(Arrays.toString(array));
        list.set(2, "?");
        System.out.println(list);

        for (Object o: list){
            System.out.println(o);
        }
        */

        /*
        MyLinkedList<Circle> list = new MyLinkedList<>();
        list.add(new Circle(2, "green"));
        list.add(new Circle(5, "blue"));
        list.add(new Circle(3, "red"));
        list.add(new Circle(10, "Aqua"));
        list.add(new Circle(7, "white"));
        list.add(new Circle(4, "black"));
        System.out.println(list);
        System.out.println(list.size());
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
        System.out.println(list.indexOf(new Circle(10, "Aqua")));
        Object[] array = list.toArray();
        System.out.println(Arrays.toString(array));
        list.set(2, new Circle(1 , "Brown"));
        System.out.println(list);

        for (Object o: list){
            System.out.println(o);
        }
        */

        myLinkedListVSjavaLinkedList();
    }

    static void myLinkedListVSjavaLinkedList(){
        LinkedList<Circle> linkedList = new LinkedList<>();
        MyLinkedList<Circle> myLinkedList = new MyLinkedList<>();

        for(int i=0; i<1000000; i++){
            linkedList.add(new Circle(i, i+"-"+i));
            myLinkedList.add(new Circle(i, i+"-"+i));
        }

        addTest(linkedList, myLinkedList);
        System.out.println("#########################################");
        searchTest(linkedList, myLinkedList);
        System.out.println("#########################################");
        removeTest(linkedList, myLinkedList);
    }

    static void addTest(LinkedList<Circle> java, MyLinkedList<Circle> custom){
        System.out.println("AddTest started...");
        final int PLACE = 4265;
        Circle circle = new Circle(12, "something");
        long start, finish, res;

        start = System.nanoTime();
        java.add(PLACE, circle);
        finish = System.nanoTime();
        res = (finish - start)/1000000;
        System.out.println("Java LinkedList finished in " + res + " millis");

        start = System.nanoTime();
        custom.add(PLACE, circle);
        finish = System.nanoTime();
        res = (finish - start)/1000000;
        System.out.println("Custom LinkedList finished in " + res + " millis");
        System.out.println("AddTest finished!");
    }

    static void searchTest(LinkedList<Circle> java, MyLinkedList<Circle> custom) {
        System.out.println("SearchTest started...");
        Circle circle = new Circle(12, "something");
        long start, finish, res;

        start = System.nanoTime();
        java.indexOf(circle);
        finish = System.nanoTime();
        res = (finish - start)/1000000;
        System.out.println("Java LinkedList finished in " + res + " millis");

        start = System.nanoTime();
        custom.indexOf(circle);
        finish = System.nanoTime();
        res = (finish - start)/1000000;
        System.out.println("Custom LinkedList finished in " + res + " millis");
        System.out.println("SearchTest finished!");
    }

    static void removeTest(LinkedList<Circle> java, MyLinkedList<Circle> custom) {
        System.out.println("RemoveTest started...");
        final int PLACE = 4265;
        Circle circle = new Circle(12, "something");
        long start, finish, res;

        start = System.nanoTime();
        java.remove(4265);
        finish = System.nanoTime();
        res = (finish - start)/1000000;
        System.out.println("Java LinkedList finished in " + res + " millis");

        start = System.nanoTime();
        custom.remove(4265);
        finish = System.nanoTime();
        res = (finish - start)/1000000;
        System.out.println("Custom LinkedList finished in " + res + " millis");
        System.out.println("RemoveTest finished!");
    }

}
