package com.zhouq.quickSort;

/**
 * 二分查找
 *
 *
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 8, 9, 10, 33, 545};

        System.out.println(binarySearch(arr, 8));
    }

    private static int binarySearch(int[] array, int e) {
        int low = 0;
        int high = array.length + 1;

        while (low <= high) {
            int middle = (low + high) / 2;

            if (e - (array[middle]) >= 0 && e - (array[middle]) <= 0) {
                return middle;
            }
            if (e - (array[middle]) > 0) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }

        return -1;
    }
}
