package org.example;

public class Demo_Construct {
    public static void main(String[] args) {
        // 演示静态代码块、代码块、构造方法的先后顺序
        System.out.println("hello world");
        new Demo_Construct_Test().test();
    }

}

class Demo_Construct_Test {
    static String a;
    static String b;
    static String c;

    // 静态代码块最先完成在类信息加载时
    static {
        a = "a";
        b = "b";
        c = "c";
        System.out.println("static...");
    }

    // 代码块完成在 new 对象的“构造方法”之前
    {
        System.out.println("init...");
    }

    // 构造方法完成在 new 对象的时刻
    Demo_Construct_Test() {
        System.out.println("constructor...");
    }

    public void test() {
        System.out.println("输出：" + a + b + c);
    }
}
