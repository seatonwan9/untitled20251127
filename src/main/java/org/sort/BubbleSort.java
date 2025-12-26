package org.sort;
/*
* 冒泡排序
* */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {1, 5, 3, 2, 4};
        int[] result = bubbleSort(arr);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
    public static int[] bubbleSort(int[] arr) {
        for (int j = 0; j < arr.length; j++) {
            for (int i = 0; i < arr.length - j - 1; i++) {
                int left = arr[i];
                int right = arr[i + 1];
                if (left > right) {
                    arr[i] = right;
                    arr[i + 1] = left;
                }
            }
        }
        return arr;
    }
}
