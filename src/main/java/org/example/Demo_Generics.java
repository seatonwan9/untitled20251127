package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
* PECS 原则（Producer-Extends, Consumer-Super）
* 如果是生产数据（读取），用 ? extends T；如果是消费数据（写入），用 ? super T
* */
public class Demo_Generics {
    public static void main(String[] args) {

/*        List<Box<Integer>> list = new ArrayList<>();
        Box<Integer> box1 = new Box<>();
        box1.setValue(1);
        Box<Integer> box2 = new Box<>();
        box2.setValue(2);
        list.add(box1);
        list.add(box2);

        for (Box<Integer> box : list) {
            System.out.println(box.getValue());
        }*/

        // 生产者只读
        List<Integer> ints = Arrays.asList(1, 2, 3);
        List<Double> doubles = Arrays.asList(1.1, 2.2);
        System.out.println(sum(ints));
        System.out.println(sum(doubles));


        // 消费者写入
        List<Number> numbers = new ArrayList<>();
        List<Object> objects = new ArrayList<>();
        List<Integer> integers = new ArrayList<>();

        addAll(numbers, Arrays.asList(1, 2, 3));
        addAll(objects, Arrays.asList(4, 5, 6));
        addAll(integers, Arrays.asList(7, 8, 9));

        System.out.println( numbers);
        System.out.println( objects);
        System.out.println( integers);
    }

    // 生产者模式，只读
    public static double sum(List<? extends Number> numbers) {
        double total = 0.0;
        for (Number n : numbers) {  // 安全地读取为 Number
            total += n.doubleValue(); // 所有 Number 子类都有 doubleValue()
        }
        return total;
    }

    // 消费者模式，只写
    public static void addAll(List<? super Integer> consumer, List<Integer> producer) {
        consumer.addAll(producer);
    }
}

/*class Box<T extends Number> {
    T value;
    public void setValue(T value) {
        this.value = value;
    }
    public T getValue() {
        return value;
    }
}*/
