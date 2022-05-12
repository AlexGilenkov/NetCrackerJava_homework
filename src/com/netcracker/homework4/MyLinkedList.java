package com.netcracker.homework4;

import java.util.Arrays;
import java.util.Iterator;

public class MyLinkedList<E> implements ILinkedList<E> {

    private Node<E> first;
    private Node<E> last;
    private int size;


    @Override
    public void add(Object element) {
        Node<E> temp = new Node<>();
        temp.setElement((E)element);
        if(first == null && last == null && size == 0){
            first = temp;
            last = temp;
        }
        if(first == last && first != null && size == 1){
            first.setNextNode(temp);
            last = temp;
        }
        if(first != last && size > 1){
            last.setNextNode(temp);
            last = temp;
        }
        ++size;
    }

    @Override
    public void add(int index, Object element) throws ArrayIndexOutOfBoundsException {
        if(index > (size - 1) && size != 0){
            throw new ArrayIndexOutOfBoundsException("index > size");
        }
        if(index < 0){
            throw new ArrayIndexOutOfBoundsException("index < 0");
        }
        if(index > 0 && size == 0){
            throw new ArrayIndexOutOfBoundsException("List is empty");
        }
        if(index == 0 && size == 0) {
            add(element);
            return;
        }
        if(index == (size-1)){
            add(element);
            return;
        }

        Node<E> cur = first;
        Node<E> prev = first;
        for(int i = 0; i<index; ++i){
            cur = cur.getNextNode();
            if(i>0){
                prev = prev.getNextNode();
            }
        }

        Node<E> temp = new Node<>();
        temp.setElement((E)element);
        if(cur == first){
            temp.setNextNode(first);
            first = temp;
        } else {
            prev.setNextNode(temp);
            temp.setNextNode(cur);
        }

        ++size;
    }

    @Override
    public void clear() {
        first = null;
        last = null;
        size = 0;
    }

    @Override
    public E get(int index) {
        Node<E> cur = first;
        for(int i = 0; i<index; ++i){
            cur = cur.getNextNode();
        }
        return cur.getElement();
    }

    @Override
    public int indexOf(Object element) throws NullPointerException{
        Node<E> cur = first;

        for(int i = 0; i<size; ++i){
            if(cur.getElement().equals(element))
                return i;
            cur = cur.getNextNode();
        }
        throw new NullPointerException("element not found");
    }

    @Override
    public E remove(int index) {
        Node<E> cur = first;
        Node<E> prev = first;
        for(int i = 0; i<index; ++i){
            cur = cur.getNextNode();
            if(i>0){
                prev = prev.getNextNode();
            }
        }
        if(cur == first){
            first = cur.getNextNode();
            return cur.getElement();
        }

        prev.setNextNode(cur.getNextNode());

        return cur.getElement();
    }

    @Override
    public E set(int index, Object element) {
        Node<E> cur = first;
        for(int i = 0; i<index; ++i){
            cur = cur.getNextNode();
        }
        cur.setElement((E) element);
        return cur.getElement();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public E[] toArray() {
        E[] arr = (E[]) new Object[size];
        for(int i=0; i<size; ++i){
            arr[i] = this.get(i);
        }
        return arr;
    }


    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public E next() {
                return null;
            }
        };
    }

    @Override
    public String toString() {
        return Arrays.toString(this.toArray());
    }
}
