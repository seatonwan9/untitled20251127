package org.search;
/*
* 二分查找法
* */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int result = binarySearch(arr, 7);
        System.out.println("所查数据的坐标位置为：" + result);
    }

    public static int binarySearch(int[] arr, int target) {
     int start = 0;
     int end = arr.length - 1;
     int mid = 0;
     while (start <= end) {
         mid = (start + end) / 2;
         if (target > arr[mid]) {
             start = mid + 1;
         } else if (target < arr[mid]) {
             end = mid - 1;
         } else {
             return mid;
         }
     }
     return -1;
    }
}
