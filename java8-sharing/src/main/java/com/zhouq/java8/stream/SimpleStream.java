package com.zhouq.java8.stream;
import java.util.*;
import static java.util.stream.Collectors.toList;

/**
 * todo
 *
 * @author zhouq
 * @email zhouqiao@gmail.com
 * @date 2018/8/5 17:36
 */
public class SimpleStream {
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


    private static List<String> getDishNamesByStream(List<Dish> menu) {
        return menu.parallelStream() // parallelStream 为多核并行执行
                .filter(d -> {
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return d.getCalories() > 400;
                }) //选出卡路里 大于 400
                .sorted(Comparator.comparingInt(Dish::getCalories)) // 按照卡路里排序
                .map(Dish::getName) //提取 名称
                .collect(toList());//将所有名称保存到 list 中

    }


    private static List<String> getDishNamesByCollections(List<Dish> menu) {
        List<Dish> lowCalories = new ArrayList<>();
        //filter and get calories less 400
        for (Dish dish : menu) {
            if (dish.getCalories() > 400) {
                lowCalories.add(dish);
            }
        }

        //sort
        Collections.sort(lowCalories, Comparator.comparingInt(Dish::getCalories));

        List<String> dishNameList = new ArrayList<>();

        for (Dish d : lowCalories) {
            dishNameList.add(d.getName());
        }
        return dishNameList;
    }


    public static void main(String[] args) {
//        List<String> dishNamesByCollections = getDishNamesByCollections(menu);
//        System.out.println(dishNamesByCollections);


//        List<String> dishNamesByStream = getDishNamesByStream(menu);
//        System.out.println(dishNamesByStream);


//        Stream<Dish> stream = menu.stream();
//        stream.forEach(System.out::println);
        // stream 流失操作只能使用一次 连续使用会 抛出 stream has already been operated upon or closed
//        stream.forEach(System.out::println);


        //
        List<String> result = menu.stream().filter(d -> {
            System.out.println("filtering ->" + d.getName());
            return d.getCalories() > 300;
        }).map(d -> {
            System.out.println("map -> " + d.getName());
           return d.getName();
        }).limit(3).collect(toList());


        System.out.println(result);

    }

}
