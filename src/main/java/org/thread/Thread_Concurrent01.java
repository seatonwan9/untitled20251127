package org.thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Thread_Concurrent01 {
    public static void main(String[] args) throws InterruptedException {
        // 创建取号队列
        BlockingQueue<User> ticketQueue = new LinkedBlockingQueue<>();

        // 创建3个银行窗口
        int windowCount = 3;
        BankWindow[] windows = new BankWindow[windowCount];

        for (int i = 0; i < windowCount; i++) {
            windows[i] = new BankWindow("窗口" + (i + 1), ticketQueue);
            windows[i].start();
        }

        // 创建30个用户，每秒来一个用户取号
        int userCount = 5;
        AtomicInteger ticketCounter = new AtomicInteger(1);

        for (int i = 0; i < userCount; i++) {
            int ticketNumber = ticketCounter.getAndIncrement();
            User user = new User("用户" + ticketNumber, ticketNumber);

            // 用户取号
            ticketQueue.put(user);
            System.out.println(user.getName() + "取号:" + user.getTicketNumber() + "，进入排队队列");

            // 间隔1秒
            Thread.sleep(1000);
        }

        // 等待所有用户被处理完
        while (!ticketQueue.isEmpty()) {
            Thread.sleep(100);
        }

        // 等待所有窗口线程结束
        for (BankWindow window : windows) {
            window.setShouldStop(true);
        }

        System.out.println("所有业务处理完毕！");
    }
}

// 用户类
class User {
    private String name;
    private int ticketNumber;

    public User(String name, int ticketNumber) {
        this.name = name;
        this.ticketNumber = ticketNumber;
    }

    public String getName() {
        return name;
    }

    public int getTicketNumber() {
        return ticketNumber;
    }
}

// 银行窗口类
class BankWindow extends Thread {
    private String windowName;
    private BlockingQueue<User> ticketQueue;
    private volatile boolean shouldStop = false;

    public BankWindow(String windowName, BlockingQueue<User> ticketQueue) {
        this.windowName = windowName;
        this.ticketQueue = ticketQueue;
    }

    public void setShouldStop(boolean shouldStop) {
        this.shouldStop = shouldStop;
    }

    @Override
    public void run() {
        while (!shouldStop || !ticketQueue.isEmpty()) {
            try {
                // 从队列中取一个用户
                User user = ticketQueue.take();

                // 处理业务（5秒）
                System.out.println(windowName + "开始为" + user.getName() +
                        "（号码:" + user.getTicketNumber() + "）办理业务");
                Thread.sleep(5000); // 模拟处理时间5秒
                System.out.println(windowName + "为" + user.getName() +
                        "（号码:" + user.getTicketNumber() + "）办理完成");

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
        System.out.println(windowName + "关闭");
    }
}