package com.zhouq;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
//        System.out.println("Hello World!");

//        ArrayList<Integer> objects = new ArrayList<Integer>();
//        objects.add(1);
//        objects.add(543);
//        objects.add(24);
//        objects.add(92);
//        objects.add(66);
//        objects.add(187);
//        objects.add(6);
//
//        List<Integer> integers = selectionSort(objects);
//        integers.forEach(System.out::println);


        List<String> list = new ArrayList<>(3);
        list.add("one");
        list.add("two");
        list.add("three");

        Object[] array1 = list.toArray();

        String[] array2 = new String[2];
        list.toArray(array2);
        System.out.println(Arrays.asList(array2));

        String[] array3 = new String[3];

        list.toArray(array3);

        System.out.println(Arrays.asList(array3));


    }

    //
    public static List<Integer> selectionSort(List<Integer> arr) {
        ArrayList<Integer> result = new ArrayList<>();
        int size = arr.size();
        for (int i = 0; i < size; i++) {
            int smallest = findSmallest(arr);
            result.add(arr.get(smallest));
            arr.remove(smallest);
        }
        return result;
    }


    /**
     * 查找最小元素的索引
     *
     * @param arr
     * @return
     */
    public static int findSmallest(List<Integer> arr) {
        int smallset = arr.get(0);
        int smallset_index = 0;
        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i) < smallset) {
                smallset = arr.get(i);
                smallset_index = i;
            }
        }
        return smallset_index;
    }
}
