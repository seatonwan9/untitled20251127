package org.example;

public class Demo_Overload {
    public static void main(String[] args) {

        Parent parent = new Child();
        Child child = new Child();
//        Demo_Overload.test(parent);
        Demo_Overload.test(child);
    }

    static public void test(Parent p) {
        p.show();
    }

    static public void test(Child c) {
        c.show("1");
    }
}

class Parent {
    public void show() {
        System.out.println("Parent.show(int a)");
    }
}

class Child extends Parent {
    public void show(String s) {
        System.out.println("Child.show(int a)");
    }
}
