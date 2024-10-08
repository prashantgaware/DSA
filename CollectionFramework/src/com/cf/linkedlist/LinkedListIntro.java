package com.cf.linkedlist;

import java.util.LinkedList;
import java.util.List;

public class LinkedListIntro {
    public static void main(String[] args) {

        CustomLinkedList cll = new CustomLinkedList();
        cll.insert(10);
        cll.insert(20);
        cll.insert(30);
        cll.insert(40);
        cll.insertAtFirst(50);
        cll.insertAtSpecifiedIndex(60,30);
        cll.remove(40);

        cll.display();
        String customLl = cll.toString();
        System.out.println(customLl);
        System.out.println(cll.get(2));
        System.out.println();







        List<Integer> ll = new LinkedList<>();
        ll.add(10);
        ll.add(20);
        ll.add(30);
        ll.add(40);
        ll.add(50);
        System.out.println(ll);
    }
}
