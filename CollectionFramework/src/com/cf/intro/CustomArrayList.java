package com.cf.intro;

import java.util.Arrays;

public class CustomArrayList {

    Object[] a;
    int index = 0;

    public CustomArrayList(int size) {
        a = new Object[size];
    }

    public CustomArrayList() {
        a = new Object[10];
    }

    /**
     * Implementation of Add() of Arraylist
     * @param o object to be added in arraylist
     */
    public void add(Object o) {

        // this block will be executed only when arraylist is full and adding data beyond its size.
        if (index >= a.length) {
            int newSize = a.length + (a.length/2);
            a = Arrays.copyOf(a, newSize);      // pre-build method of Arrays class

            // implementation for copying new array in to old array.
            /*Object[] newArr = new Object[newSize];
            for (int i=0; i<a.length; i++) {
                newArr[i] = a[i];
            }

            a = newArr;*/
        }

        a[index] = o;
        index++;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("[");
        for (int i = 0; i < a.length; i++) {
            if (i == (a.length-1))
                s.append(a[i]);         // this to remove last comma.
            else {
                if (null != a[i])       // this to not add null
                    s.append(a[i]).append(", ");
            }
        }
        s.append("]");

        return s.toString();
    }
}
