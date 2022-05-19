package com.netcracker.homework4;

import com.netcracker.homework1.Circle;

import java.util.*;

public class TestJavaCollections {
    public static void main(String[] args) {
        System.out.println("ArrayList vs. LinkedList");
        arrayListVSlinkedList();
        System.out.println("##############################################");
        System.out.println("HashSet vs. LinkedHashSet vs. TreeSet");
        hashSetVSlinkedHashSetVStreeSet();
        System.out.println("##############################################");
        hashMapVSlinkedHashMapVStreeMap();

    }


    static void arrayListVSlinkedList(){
        LinkedList<Circle> linkedList = new LinkedList<>();
        ArrayList<Circle> arrayList = new ArrayList<>();

        for(int i=0; i<1000000; i++){
            Circle cir = new Circle(i, i+"-"+i);
            linkedList.add(cir);
            arrayList.add(cir);
        }

        long start, finish, result1, result2;
        Circle circle = new Circle(12, "color");

        start = System.nanoTime();
        arrayList.add(45678, circle);
        finish = System.nanoTime();
        result1 = finish-start;

        start = System.nanoTime();
        linkedList.add(45678, circle);
        finish = System.nanoTime();
        result2 = finish-start;

        System.out.println("Add: ArrayList's time = " + result1/1000000 + "; "
                + "LinkedList's time = " + result2/1000000 + "    (in millisecond)");

        start = System.nanoTime();
        arrayList.indexOf(circle);
        finish = System.nanoTime();
        result1 = finish-start;

        start = System.nanoTime();
        linkedList.indexOf(circle);
        finish = System.nanoTime();
        result2 = finish-start;

        System.out.println("IndexOf: ArrayList's time = " + result1/1000000 + "; "
                + "LinkedList's time = " + result2/1000000 + "    (in millisecond)");

        start = System.nanoTime();
        arrayList.remove(circle);
        finish = System.nanoTime();
        result1 = finish-start;

        start = System.nanoTime();
        linkedList.remove(circle);
        finish = System.nanoTime();
        result2 = finish-start;

        System.out.println("Remove: ArrayList's time = " + result1/1000000 + "; "
                + "LinkedList's time = " + result2/1000000 + "    (in millisecond)");
    }

    static void hashSetVSlinkedHashSetVStreeSet(){
        HashSet<Circle> hashSet = new HashSet<>();
        LinkedHashSet<Circle> linkedHashSet = new LinkedHashSet<>();
        TreeSet<Circle> treeSet = new TreeSet<>();

        for(int i=0; i<1000000; i++){
            Circle cir = new Circle(i, i+"-"+i);
            hashSet.add(cir);
            linkedHashSet.add(cir);
            treeSet.add(cir);
        }

        long start, finish, result1, result2, result3;
        Circle circle = new Circle(12, "color");

        start = System.nanoTime();
        hashSet.add(circle);
        finish = System.nanoTime();
        result1 = finish-start;

        start = System.nanoTime();
        linkedHashSet.add(circle);
        finish = System.nanoTime();
        result2 = finish-start;

        start = System.nanoTime();
        treeSet.add(circle);
        finish = System.nanoTime();
        result3 = finish-start;

        System.out.println("Add: HashSet's time = " + result1 + "; "
                + "LinkedHashSet's time = " + result2 + "; "+ "TreeSet's time = " + result3
                + "    (in nanosecond)");


        start = System.nanoTime();
        hashSet.contains(circle);
        finish = System.nanoTime();
        result1 = finish-start;

        start = System.nanoTime();
        linkedHashSet.contains(circle);
        finish = System.nanoTime();
        result2 = finish-start;

        start = System.nanoTime();
        treeSet.contains(circle);
        finish = System.nanoTime();
        result3 = finish-start;

        System.out.println("Contains: HashSet's time = " + result1 + "; "
                + "LinkedHashSet's time = " + result2 + "; "+ "TreeSet's time = " + result3
                + "    (in nanosecond)");

        start = System.nanoTime();
        hashSet.remove(circle);
        finish = System.nanoTime();
        result1 = finish-start;

        start = System.nanoTime();
        linkedHashSet.remove(circle);
        finish = System.nanoTime();
        result2 = finish-start;

        start = System.nanoTime();
        treeSet.remove(circle);
        finish = System.nanoTime();
        result3 = finish-start;

        System.out.println("Remove: HashSet's time = " + result1 + "; "
                + "LinkedHashSet's time = " + result2 + "; "+ "TreeSet's time = " + result3
                + "    (in nanosecond)");
    }

    static void hashMapVSlinkedHashMapVStreeMap() {
        HashMap<Integer, Circle> hashMap = new HashMap<>();
        LinkedHashMap<Integer, Circle> linkedHashMap = new LinkedHashMap<>();
        TreeMap<Integer, Circle> treeMap = new TreeMap<>();


        for(int i=0; i<1000000; i++){
            Circle cir = new Circle(i, i+"-"+i);
            hashMap.put(i, cir);
            linkedHashMap.put(i, cir);
            treeMap.put(i, cir);
        }

        long start, finish, result1, result2, result3;
        Circle circle = new Circle(1232, "color");

        start = System.nanoTime();
        hashMap.put((int) circle.getRadius(), circle);
        finish = System.nanoTime();
        result1 = finish-start;

        start = System.nanoTime();
        linkedHashMap.put((int) circle.getRadius(), circle);
        finish = System.nanoTime();
        result2 = finish-start;

        start = System.nanoTime();
        treeMap.put((int) circle.getRadius(), circle);
        finish = System.nanoTime();
        result3 = finish-start;

        System.out.println("Put: HashMap's time = " + result1 + "; "
                + "LinkedHashMap's time = " + result2 + "; "+ "TreeMap's time = " + result3
                + "    (in nanosecond)");

        start = System.nanoTime();
        hashMap.containsValue(circle);
        finish = System.nanoTime();
        result1 = finish-start;

        start = System.nanoTime();
        linkedHashMap.containsValue(circle);
        finish = System.nanoTime();
        result2 = finish-start;

        start = System.nanoTime();
        treeMap.containsValue(circle);
        finish = System.nanoTime();
        result3 = finish-start;

        System.out.println("Contains Value: HashMap's time = " + result1 + "; "
                + "LinkedHashMap's time = " + result2 + "; "+ "TreeMap's time = " + result3
                + "    (in nanosecond)");


        start = System.nanoTime();
        hashMap.remove((int) circle.getRadius(), circle);
        finish = System.nanoTime();
        result1 = finish-start;

        start = System.nanoTime();
        linkedHashMap.remove((int) circle.getRadius(), circle);
        finish = System.nanoTime();
        result2 = finish-start;

        start = System.nanoTime();
        treeMap.remove((int) circle.getRadius(), circle);
        finish = System.nanoTime();
        result3 = finish-start;

        System.out.println("Remove: HashMap's time = " + result1 + "; "
                + "LinkedHashMap's time = " + result2 + "; "+ "TreeMap's time = " + result3
                + "    (in nanosecond)");

    }
}
