package com.zhouq.java8.stream;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * filter
 *
 * @author zhouq
 * @email zhouqiao@gmail.com
 * @date 2018/8/11 10:29
 */
public class StreamFilter {
    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 2, 3, 8, 9, 10,4, 5, 6, 7);

        // 取出 偶数
        List<Integer> result = list.stream().filter(i -> (i % 2 == 0)).collect(toList());

        System.out.println(result);
        // 去重
        result = list.stream().distinct().collect(toList());

        System.out.println(result);


    }


}
