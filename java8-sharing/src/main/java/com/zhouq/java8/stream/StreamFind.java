package com.zhouq.java8.stream;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * todo
 *
 * @author zhouq
 * @email zhouqiao@gmail.com
 * @date 2018/8/11 12:10
 */
public class StreamFind {


    public static void main(String[] args) {
        Stream<Integer> stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 34, 56, 24, 75, 355});
        Optional<Integer> optional = stream.filter(i -> i % 2 == 0).findAny();
        System.out.println(optional.orElse(-1));

        int i1 = find(new Integer[]{1, 2, 3, 4, 34, 56, 24, 75, 355}, -1, i -> i > 50);
        System.out.println(i1);

        stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 34, 56, 24, 75, 355});

        Optional<Integer> optional1 = stream.filter(i -> i % 2 == 0).findFirst();

        optional1.ifPresent(System.out::println);

        System.out.println(optional1.filter(i -> i == 2).get());



    }

    private static int find(Integer[] values, int defaultValue, Predicate<Integer> predicate) {
        for (int i : values) {
            if (predicate.test(i)) {
                return i;
            }
        }

        return defaultValue;
    }
}
