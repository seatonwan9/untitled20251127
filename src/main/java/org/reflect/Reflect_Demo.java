package org.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Reflect_Demo {

    public static void main(String[] args) throws Exception {

        Animal animal = new Cat();
        animal.animalTest01();
//        animal.catTest01(); // 多态，由于引用对象的限制，此对象只能调用animalTest01()方法

        // 获取类对象
        System.out.println("---------获取类对象---------");
        Class<? extends Animal> aClass = animal.getClass();
        System.out.println(aClass.getName()); // 获取类的完整名称（含包名）
        System.out.println(aClass.getSimpleName()); // 获取类的名称
        System.out.println(aClass.getPackageName()); // 获取类的包的名称

        //获取类的父类
        System.out.println("---------获取类的父类---------");
        Class<?> superclass = aClass.getSuperclass();
        System.out.println(superclass);

        //获取类的接口
        System.out.println("---------获取类的接口---------");
        Class<?>[] interfaces = aClass.getInterfaces();

        //获取类的属性
        System.out.println("---------获取类的属性---------");
        Field field1 = aClass.getField("name"); // 获取public属性（注意：可以向上查找类和其父类的属性）
        Field field2 = aClass.getField("color"); // 获取public属性
        Field declaredField1 = aClass.getSuperclass().getDeclaredField("age"); //获取所有权限属性（注意：默认查找本类，不会向上查找父类属性）
        Field declaredField2 = aClass.getDeclaredField("male");
        System.out.println(field1);
        System.out.println(field2);
        System.out.println(declaredField1);
        System.out.println(declaredField2);

        // 属性数组
        Field[] fields = aClass.getFields();
        Field[] declaredFields = aClass.getDeclaredFields();
        System.out.println(Arrays.stream(fields).toList());
        System.out.println(Arrays.stream(declaredFields).toList());

        // 获取类的方法
        System.out.println("---------获取类的方法---------");
        Method animalTest01 = aClass.getMethod("animalTest01");
        Method catTest01 = aClass.getMethod("catTest01");
        Method animalTest02 = aClass.getSuperclass().getDeclaredMethod("animalTest02");
        Method catTest02 = aClass.getDeclaredMethod("catTest02");
        System.out.println(animalTest02);
        System.out.println(catTest02);
        System.out.println(animalTest01);
        System.out.println(catTest01);

        // 方法数组
        Method[] methods = aClass.getMethods();
        Method[] declaredMethods = aClass.getDeclaredMethods();
        System.out.println(Arrays.stream(methods).toList());
        System.out.println(Arrays.stream(declaredMethods).toList());

        // 获取类的构造方法
        System.out.println("---------获取类的构造方法---------");
//        Constructor<? extends Animal> constructor = aClass.getConstructor(); // 只存在隐式构造时是获取不到的
        Constructor<? extends Animal> declaredConstructor = aClass.getDeclaredConstructor();
//        System.out.println(constructor);
        System.out.println(declaredConstructor);

        // 获取权限（修饰符），多个修饰符融合成一个int值
        System.out.println("---------获取权限（修饰符）---------");
        int classModifiers = aClass.getModifiers(); // 获取类
        int fieldModifiers = field1.getModifiers(); // 获取属性
        int methodModModifiers = catTest01.getModifiers(); // 获取方法
        System.out.println(Modifier.isPublic(classModifiers));
        System.out.println(Modifier.isPublic(fieldModifiers));
        System.out.println(Modifier.isPublic(methodModModifiers));
    }
}

class Animal {

    public String name;

    private Integer age;
    public void animalTest01() {
        System.out.println("Public Animal");
    }

    private void animalTest02() {
        System.out.println("Private Animal");
    }
}

class Cat extends Animal {

    public String color;

    private String male;

    public void catTest01() {
        System.out.println("Public Cat");
    }

    private void catTest02() {
        System.out.println("Private cat");
    }
}
