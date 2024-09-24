package com.cf.intro;

class A {
    public void m1(){
        System.out.println("A.m1");
    }

    public void m3() {
        System.out.println("A.m3");
    }
}

class B extends A {
    @Override
    public void m1() {
        System.out.println("B.m1");
    }

    public void m2() {
        System.out.println("B.m2");
    }
}

public class InheritanceExample {
    public static void main(String[] args) {
        A a = new A();
        a.m1();
        a.m3();
        System.out.println();
        A ao = new B();
        ao.m1();
        ao.m3();
        System.out.println();
        B b = new B();
        b.m1();
        b.m2();
        b.m3();
    }
}
