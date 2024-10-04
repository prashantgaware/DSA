package com.cf.linkedlist;

public class LinkedListTest {
    public static void main(String[] args) {
        CustomLLExample cle = new CustomLLExample();
        cle.insert(10);
        cle.insert(20);
        cle.insertAtFirst(5);
        cle.insertAtSpecifiedPosition(15, 2);
        cle.remove(20);
        System.out.println(cle);

    }
}
