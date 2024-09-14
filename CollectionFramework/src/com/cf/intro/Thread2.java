package com.cf.intro;

import java.util.List;

public class Thread2 extends Thread {

    List<Integer> l;

    public Thread2(List<Integer> l, String threadName) {
        super(threadName);
        this.l = l;
    }

    @Override
    public void run() {
        l.add(20);
    }
}
