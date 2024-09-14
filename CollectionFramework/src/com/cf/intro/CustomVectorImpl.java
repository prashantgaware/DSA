package com.cf.intro;

import java.util.Arrays;

public class CustomVectorImpl {

    Object[] obj;
    int index = 0;

    public CustomVectorImpl(int size) {
        obj = new Object[size];
    }

    public CustomVectorImpl() {
        obj = new Object[10];
    }

    public synchronized void add(Object o) {
        if (index >= obj.length) {
            int newSize = obj.length * 2;
            obj = Arrays.copyOf(obj, newSize);

            /*Object[] newObj = new Object[newSize];
            for (int i=0; i<obj.length; i++) {
                newObj[i] = obj[i];
            }

            obj = newObj;*/
        }

        obj[index] = o;
        index++;
    }

    public Object get(int index) {
        if (index >= obj.length || index < 0)
            throw new IllegalArgumentException("Invalid index.");

        return obj[index];
    }

    public int size() {
        int l = 0;
        for (Object o : obj) {
            l++;
        }

        return l;
    }

    public synchronized Object remove(int index) {
        int size = size();
        if (index >= size || index < 0)
            throw new IllegalArgumentException("Invalid index.");

        Object o = obj[index];
        for (int i=index; i<size-1; i++) {
            obj[i] = obj[i+1];
        }

        obj[size-1] = null;
        return o;
    }

    @Override
    public String toString() {
        return "CustomVectorImpl{" +
                "obj=" + Arrays.toString(obj) +
                '}';
    }
}
