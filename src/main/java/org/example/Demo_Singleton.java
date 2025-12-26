package org.example;

public class Demo_Singleton {
    public static void main(String[] args) {
        Demo_Singleton_Test instance1 = Demo_Singleton_Test.getInstance();
        Demo_Singleton_Test instance2 = Demo_Singleton_Test.getInstance();

        System.out.println(instance1 == instance2);
    }
}

class Demo_Singleton_Test {
    private static final Demo_Singleton_Test instance = new Demo_Singleton_Test();

    private Demo_Singleton_Test() {

    }

    public static Demo_Singleton_Test getInstance() {
        return instance;
    }
}
