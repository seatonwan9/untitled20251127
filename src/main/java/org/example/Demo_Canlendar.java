package org.example;

import java.util.Calendar;

/*
* 打印当月日历
* */
public class Demo_Canlendar {
    public static void main(String[] args) {
        System.out.println("周一\t周二\t周三\t周四\t周五\t周六\t周日");
        // 获取当前日历类
        Calendar instance = Calendar.getInstance();
        // 设置当月1号
        instance.set(Calendar.DAY_OF_MONTH, 1);
        // 获取当月最大天数
        int maximum = instance.getMaximum(Calendar.DAY_OF_MONTH);

        for (int i = 1; i <= maximum; i++) {
            // 获取当前是周几
            int dayOfWeek = instance.get(Calendar.DAY_OF_WEEK);
            // 获取当前是几号
            int dayOfMonth = instance.get(Calendar.DAY_OF_MONTH);
            // 当月1号的情况
            if (i == 1) {
                if (dayOfWeek == Calendar.SUNDAY) {
                    for (int j = 0; j < 6; j++) {
                        System.out.print("\t");
                    }
                    System.out.println(dayOfMonth);
                } else {
                    for (int j = 0; j < dayOfWeek - 2; j++) {
                        System.out.print("\t");
                    }
                    System.out.print(dayOfMonth);
                    System.out.print("\t");
                }

            } else {
                // 当月不为1号的情况
                if (dayOfWeek == Calendar.SUNDAY) {
                    System.out.println(dayOfMonth);
                } else {
                    System.out.print(dayOfMonth + "\t");
                }
            }
            instance.add(Calendar.DAY_OF_MONTH, 1);
        }
    }
}
