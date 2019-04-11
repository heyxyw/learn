package com.zhouq.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhouq
 * @email zhouqiao@gmail.com
 * @date 2018/8/4 11:20
 */
public class FilterApple {

    @FunctionalInterface
    public interface AppleFilter {
        boolean filter(Apple apple);
    }


    /**
     * 查找苹果
     *
     * @param apples
     * @param appleFilter
     * @return
     */
    public static List<Apple> findApple(List<Apple> apples, AppleFilter appleFilter) {

        List<Apple> result = new ArrayList<>();

        for (Apple apple : apples) {
            if (appleFilter.filter(apple)) {
                result.add(apple);
            }
        }

        return result;
    }

    /**
     * 绿色且大小大于等于150 的
     */
    public static class GreenAnd150WeightFilter implements AppleFilter {
        @Override
        public boolean filter(Apple apple) {
            return ("green".equals(apple.getColor()) && apple.getWeight() >= 150);
        }
    }


    /**
     * 查找绿色苹果
     *
     * @param inventory
     * @return
     */
    public static List<Apple> findGreenApple(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if ("green".equals(apple.getColor())) {
                result.add(apple);
            }
        }
        return result;
    }


    public static void main(String[] args) throws InterruptedException {
        List<Apple> apples = Arrays.asList(new Apple("green", 150), new Apple("yellow", 100), new Apple("green", 160));

//        List<Apple> greenApples = findGreenApple(apples);
//
//        System.out.println(greenApples);

//        List<Apple> apple = findApple(apples, new GreenAnd150WeightFilter());
//        System.out.println(apple);


//        List<Apple> yellowList = findApple(apples, new AppleFilter() {
//            @Override
//            public boolean filter(Apple apple) {
//                return "yellow".equals(apple.getColor());
//            }
//        });
//
//        System.out.println(yellowList);


//        List<Apple> lambdaResult = findApple(apples, apple -> {
//            return apple.getColor().equals("green");
//        });
//
//        System.out.println(lambdaResult);


        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        }).start();


        new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
        }).start();


        Thread.currentThread().join();

    }

}
