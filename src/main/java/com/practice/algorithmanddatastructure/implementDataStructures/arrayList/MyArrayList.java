package com.practice.algorithmanddatastructure.implementDataStructures.arrayList;

import java.util.Arrays;

public class MyArrayList<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] data;
    private int size;

    public MyArrayList(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("illegal capacity <=0");
        }
        this.data = new Object[capacity];
        this.size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(T element) {
        if (size == data.length) {
            ensureCapacity();
        }
        data[size++] = element;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return (T) data[index];
    }

    public void remove(int index){
        if (index<0||index>=size){
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        size--;
        //shift all elements after the specified index one position to the left.
        // This is done to fill the gap created by the removed element and ensure that there are no "holes" in the list
        for (int i=index;i<size;i++){
            data[i]=data[i+1];
        }
    }

    private void ensureCapacity(){
        int newCapacity=(data.length*3)/2+1;
        data= Arrays.copyOf(data,newCapacity);
    }
}
