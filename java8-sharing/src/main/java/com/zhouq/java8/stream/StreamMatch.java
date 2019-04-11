package com.zhouq.java8.stream;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * todo
 *
 * @author zhouq
 * @email zhouqiao@gmail.com
 * @date 2018/8/11 11:47
 */
public class StreamMatch {

    public static void main(String[] args) {
        Stream<Integer> stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 34, 56, 24, 75, 355});


        boolean allMatch = stream.allMatch(i -> i > 10);
        System.out.println(allMatch);

        stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 34, 56, 24, 75, 355});
        boolean anyMatch = stream.anyMatch(i -> i > 10);
        System.out.println(anyMatch);

        stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 34, 56, 24, 75, 355});

        boolean noneMatch = stream.noneMatch(i -> i < 0);
        System.out.println(noneMatch);

    }

}
