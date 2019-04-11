package com.zhouq.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * todo
 *
 * @author zhouq
 * @email zhouqiao@gmail.com
 * @date 2018/8/11 10:37
 */
public class StreamMap {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 2, 3, 8, 9, 10,4, 5, 6, 7);

        //把list 里面的元素变成两倍
        list.stream().map(d ->d * 2).forEach(System.out::println);
        System.out.println("------------------------------------------------");
        // map
        List<String> dishes = menu.stream().map(d -> d.getName()).collect(toList());
        System.out.println(dishes);

        System.out.println("------------------------------------------------");
        //flatmap flat 扁平化

        String[] words = {"hello","zhouq"};

        Stream<String[]> stream = Arrays.stream(words).map(w -> w.split(""));
        Stream<String> stringStream = stream.flatMap(Arrays::stream);

        stringStream.distinct().forEach(System.out::println);

        System.out.println("------------------------------------------------");
        //skip 跳过前面 n 个元素

        list.stream().skip(4).forEach(System.out::println);
    }


    private static List<Dish> menu = Arrays.asList(
            new Dish("pork", false, 800, Dish.Type.MEAT),
            new Dish("beef", false, 700, Dish.Type.MEAT),
            new Dish("chicken", false, 400, Dish.Type.MEAT),
            new Dish("french fries", true, 530, Dish.Type.OTHER),
            new Dish("rice", true, 350, Dish.Type.OTHER),
            new Dish("season fruit", true, 120, Dish.Type.OTHER),
            new Dish("pizza", true, 550, Dish.Type.OTHER),
            new Dish("prawns", false, 300, Dish.Type.FISH),
            new Dish("salmon", false, 450, Dish.Type.FISH)
    );
}
