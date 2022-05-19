package com.netcracker.homework4;

public interface ILinkedList<E> extends Iterable {

    void add(E element);

    void add(int index, E element);

    void clear();

    E get(int index);

    int indexOf(E element);

    E remove(int index);

    E set(int index, E element);

    int size();

    Object[] toArray();

    String toString();
}
