package com.cf.intro;

import java.util.List;

public class Thread1 extends Thread {

    List<Integer> l;

    public Thread1(List<Integer> l, String threadName) {
        super(threadName);
        this.l = l;
    }

    @Override
    public void run() {
        l.add(10);
    }
}
