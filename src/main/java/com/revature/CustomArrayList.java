package com.revature;

import java.util.Iterator;

public class CustomArrayList<E> implements CustomList<E> {
    float growFactor = 1.5f;
    int size = 4;
    int currentSize = 0;
    Object[] array = new Object[size];


    @Override
    public void add(E e) {
        if(currentSize >= size) {
            growArray();
        }
        array[currentSize] = e;
        currentSize++;
    }

    @Override
    public E get(int index) {
        return (E)array[index];
    }

    @Override
    public void remove(int index) {
        array[index] = null;
        //need to shift everything after the index to the left


        currentSize--;
    }

    @Override
    public void remove(E e) {
        boolean complete = false;
        for(int i = 0; i < array.length; i++) {
            if(complete) {
                //we've already removed the element, now we need to shift.

            } else if (array[i].equals(e)) {
                complete = true;
                remove(i);
            }

        }
        currentSize--;
    }

    @Override
    public void clear() {
        size = 4;
        currentSize = 0;
        array = new Object[size];
    }


    private void growArray() {

        size = (int)(size * growFactor);
        Object[] temp = new Object[size];
        for(int i = 0; i < array.length; i++) {
            temp[i] = array[i];
        }
        array = temp;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int index = 0;


            @Override
            public boolean hasNext() {
                if(array[index] != null || index > size) {
                    return true;
                }
                return false;
            }

            @Override public E next() {
                E temp = (E)array[index];
                index++;
                return temp;
            }
        };
    }
}
