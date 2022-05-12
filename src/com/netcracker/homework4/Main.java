package com.netcracker.homework4;

public class Main {
    public static void main(String[] args) {
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
        String[] array = list.toArray();
        System.out.println(array);
        list.set(2, "?");
        System.out.println(list);
    }
}
