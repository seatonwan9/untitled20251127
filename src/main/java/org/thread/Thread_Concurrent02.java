package org.thread;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Thread_Concurrent02 {
    public static void main(String[] args) throws InterruptedException {
        // 创建取号队列
        BlockingQueue<User02> queue = new LinkedBlockingQueue<>();
        // 创建一个计数器，初始值为用户数量
        CountDownLatch latch = new CountDownLatch(5); // 用户数量为5

        int windowCount = 3;
        ExecutorService executorService = Executors.newFixedThreadPool(windowCount);
        for (int i = 1; i <= windowCount; i++) {
            executorService.submit(new Bank02("窗口" + i, queue, latch));
        }

        int userCount = 5;
        AtomicInteger ticketCounter = new AtomicInteger(1);
        for (int i = 1; i <= userCount; i++) {
            int andIncrement = ticketCounter.getAndIncrement();
            User02 user = new User02("用户" + andIncrement + "000", andIncrement);
            queue.put(user);
            System.out.println(user.getName() + "取号：" + user.getNumber() + "，进入队列");
            Thread.sleep(1000);
        }

        // 等待所有任务完成
        latch.await(); // 等待计数器归零

        // 关闭线程池
        executorService.shutdown();
        if (!executorService.awaitTermination(30, TimeUnit.SECONDS)) {
            executorService.shutdownNow();
        }

        System.out.println("所有业务处理完毕！");
    }
}

class User02 {
    private String name;
    private int number;

    public User02(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }
}

class Bank02 implements Runnable {
    private String windowsName;
    private BlockingQueue<User02> queue;
    private CountDownLatch latch;

    public Bank02(String windowsName, BlockingQueue<User02> queue, CountDownLatch latch) {
        this.windowsName = windowsName;
        this.queue = queue;
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                User02 user = queue.take();
                System.out.println("------" + windowsName + "正在办理业务：" + user.getName() + "（号码：" + user.getNumber() + "）");
                Thread.sleep(5000);
                System.out.println("------" + windowsName + "办理完成：" + user.getName() + "（号码：" + user.getNumber() + "）");
                // 每处理完一个用户，计数器减1
                latch.countDown();
            }
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        } finally {
            System.out.println(windowsName + "关闭");
        }

    }
}
