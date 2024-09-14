package com.cf.intro;

public class CustomVectorExample {
    public static void main(String[] args) {
        CustomVectorImpl v = new CustomVectorImpl(5);
        v.add(10);
        v.add(20);
        v.add(30);
        v.add(40);
        v.add(50);
        System.out.println(v);
        System.out.println(v.size());
        System.out.println(v.remove(2));
        System.out.println(v);
        v.add(60);
        v.add(70);
        v.add(70);
        v.add(70);
        v.add(70);
        v.add(70);
        v.add(70);
        v.add(70);
        System.out.println(v.size());
        System.out.println(v);
    }
}
