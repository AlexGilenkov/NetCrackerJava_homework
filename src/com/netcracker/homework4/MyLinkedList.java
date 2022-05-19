package com.netcracker.homework4;

import java.util.*;

public class MyLinkedList<E> implements ILinkedList<E> {

    private Node<E> first;
    private Node<E> last;
    private int size;

    public boolean isEmpty(){
        return size == 0;
    }

    public boolean contains(Object element) {
        return indexOf(element) >= 0;
    }

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
    public E remove(int index) throws ArrayIndexOutOfBoundsException{
        if((size-1) < index){
            throw new ArrayIndexOutOfBoundsException("index > size");
        }

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
        size--;
        return cur.getElement();
    }

    @Override
    public E set(int index, Object element) throws ArrayIndexOutOfBoundsException   {
        if((size-1) < index){
            throw new ArrayIndexOutOfBoundsException("index > size");
        }

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
    public Object[] toArray() {
        Object[] result = new Object[size];
        int i = 0;
        for (Node<E> x = first; x != null; x = x.getNextNode())
            result[i++] = x.getElement();
        return result;
    }

    public <E> E[] toArray(E[] a) {
        if (a.length < size)
            a = (E[])java.lang.reflect.Array.newInstance(
                    a.getClass().getComponentType(), size);
        int i = 0;
        Object[] result = a;
        for (Node x = first; x != null; x = x.getNextNode()) {
            result[i++] = x.getElement();
        }

        if (a.length > size)
            a[size] = null;

        return a;
    }


    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {

            private int curIndex=0;

            @Override
            public boolean hasNext() {
                return curIndex<size;
            }

            @Override
            public E next() {
                return get(curIndex++);
            }
        };
    }

    @Override
    public String toString() {
        return Arrays.toString(this.toArray());
    }

}
