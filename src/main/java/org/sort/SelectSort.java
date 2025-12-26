package org.sort;
/*
* 选择排序
* */
public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {1, 5, 3, 2, 4};
        int[] result = selectSort(arr);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
    public static int[] selectSort(int[] arr) {
        for (int j = 0; j < arr.length; j++) {
            int maxIndex = 0;
            for (int i = 1; i < arr.length - j; i++) {
                if (arr[i] > arr[maxIndex] ) {
                    maxIndex = i;
                }
            }
            int maxNum = arr[maxIndex];
            int lastNum = arr[arr.length - j - 1];
            arr[maxIndex] = lastNum;
            arr[arr.length - j - 1] = maxNum;
        }
        return arr;
    }
}
