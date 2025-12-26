package org.thread;

import java.util.concurrent.*;

/*
* 三种线程创建的方式
* */
public class Thread_Demo {
    public static void main(String[] args) {

        System.out.println("MainThread: " + Thread.currentThread().getName());

        // 继承Thread
        MyThread myThread = new MyThread();
        myThread.start();

        // 实现Runnable，无返回值
        MyRunnable myRunnable = new MyRunnable();
//        Thread t = new Thread(myRunnable);
//        t.start();

        // 创建线程池
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.submit(new MyRunnable());
        // 实现Callable，有返回值
        Future<Integer> future = executorService.submit(new MyCallable());
        try {
            Integer result = future.get();
            System.out.println("Result: " + result);
        } catch (InterruptedException | ExecutionException e) { // 异常捕获
            throw new RuntimeException(e);
        } finally {
            // 关闭线程池
            executorService.shutdown();
        }

/*        // 匿名类
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("AnonymousThread: " + Thread.currentThread().getName());
            }
        }).start();

        // Lambda表达式
        new Thread(() -> {
            System.out.println("LambdaThread: " + Thread.currentThread().getName());
        }).start();*/
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("MyThread: " + Thread.currentThread().getName());
    }
}

class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("MyRunnable: " + Thread.currentThread().getName());
    }
}

class MyCallable implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println("MyCallable: " + Thread.currentThread().getName());
        Thread.sleep(3000);
        return 123;
    }
}
