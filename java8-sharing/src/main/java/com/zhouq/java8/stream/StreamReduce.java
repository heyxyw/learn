package com.zhouq.java8.stream;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * todo
 *
 * @author zhouq
 * @email zhouqiao@gmail.com
 * @date 2018/8/13 21:58
 */
public class StreamReduce {

    public static void main(String[] args) {
        Stream<Integer> stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 34, 56, 24, 75, 355});
        Integer result = stream.reduce(0, (i, j) -> i + j);
        System.out.println(result);
        stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 34, 56, 24, 75, 355});

        stream.reduce((i,j) -> i + j ).ifPresent(System.out::println);



        stream = Arrays.stream(new Integer[]{1,2,3,4,5,6,6});

        stream.reduce(Integer::max).ifPresent(System.out::println);


        stream = Arrays.stream(new Integer[]{1,2,3,4,5,6,6});

        stream.reduce(Integer::min).ifPresent(System.out::println);

        stream = Arrays.stream(new Integer[]{1,2,3,4,5,6,6});

        stream.reduce((i,j) -> i > j ? j : i).ifPresent(System.out::println);

    }


}
