package org.example;

public class Demo_TrianglePrint {
    public static void main(String[] args) {
        // 打印 * 三角形的两种思路
        Demo_TrianglePrint.printA();
        System.out.println("-------------------------------------------------");
        Demo_TrianglePrint.printB();
    }

    public static void printA() {
        int num = 9;
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < (num - 1) - i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < i * 2 + 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void printB() {
        int row = 9;
        int col = 2 * (row - 1) + 1;
        int mid = (col - 1) / 2;
        String[][] arr = new String[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (j >= mid - i && j <= mid + i) {
                    arr[i][j] = "*";
                } else {
                    arr[i][j] = " ";
                }
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }
}
