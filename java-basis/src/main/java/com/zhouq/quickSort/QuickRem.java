package com.zhouq.quickSort;

import java.util.Arrays;

/**
 * 快速排序
 * 快速排序 时间平均 O(NlogN) 最坏 O( N^2 ) 空间平均 O(logN)和 最坏O(N)
 */
public class QuickRem {
    public static void main(String[] args) {
        int[] data = {9, -16, 21, 23, -30, -49, 21, 30, 30};
        System.out.println(" 排序之前： \n" + Arrays.toString(data));
//        quickSort(data);
        quickSort_2(data, 0, data.length - 1);
        System.out.println(" 排序之后： \n" + Arrays.toString(data));
    }

    private static void quickSort(int[] data) {
        if (data.length != 0) {
            subSort(data, 0, data.length - 1);
        }
    }

    private static void subSort(int[] data, int start/*0*/, int end/*最后一个索引*/) {
        if (start < end) {
            int base = data[start];
            int i = start;
            int j = end + 1;//+1 +1 +1
            while (true) {
                while (i < end && data[++i] <= base) ;

                while (j > start && data[--j] >= base) ;

                if (i < j)
                    swap(data, i, j);
                else
                    break;
            }
            swap(data, start, j);
            subSort(data, start, j - 1);
            subSort(data, j + 1, end);
        }
    }

    private static void swap(int[] data, int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    /**
     * 快排
     *
     * @param data
     * @param low
     * @param high
     */
    private static void quickSort_2(int[] data, int low, int high) {
        if (low > high) return;

        int i, j, base, temp;

        i = low;
        j = high;
        //基准位置数据
        base = data[low];

        while (i < j) {
            //产查询右边的，找到比基准位置小的数据位置
            while (i < j && base <= data[j]) {
                j--;
            }

            // 再查询左边的，找到比基准位置大的数据位置
            while (i < j && base >= data[i]) {
                i++;
            }

            //符合条件的就进行交换位置
            if (i < j) {
                temp = data[i];
                data[i] = data[j];
                data[j] = temp;
            }
        }

        // 到这里就说明 i == j  就交换基准位置的数据
        data[low] = data[j];
        data[j] = base;
        // 递归处理左边
        quickSort_2(data, low, j - 1);
        // 递归处理右边
        quickSort_2(data, j + 1, high);
    }


}
