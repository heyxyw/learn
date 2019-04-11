package com.zhouq.java8;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;

/**
 * todo
 *
 * @author zhouq
 * @email zhouqiao@gmail.com
 * @date 2018/8/4 15:05
 */
public class LambdaUsage {


    public static List<Apple> filter(List<Apple> source, Predicate<Apple> predicate){
        List<Apple> result =new ArrayList<>();
        for(Apple apple : source){
            if (predicate.test(apple)){
                result.add(apple);
            }
        }
        return result;
    }

    public static List<Apple> filterByWeight(List<Apple> source, LongPredicate predicate){
        List<Apple> result =new ArrayList<>();
        for(Apple apple : source){
            if (predicate.test(apple.getWeight())){
                result.add(apple);
            }
        }
        return result;
    }

    /**
     *
     * @param source
     * @param predicate
     * @return
     */
    public static List<Apple> filterByBiPredicate(List<Apple> source, BiPredicate<String,Long> predicate){
        List<Apple> result = new ArrayList<>();
        for (Apple apple : source){
            if (predicate.test(apple.getColor(),apple.getWeight())){
                result.add(apple);
            }
        }
        return result;
    }


    private static void simpleBiConsumer(String c, List<Apple> source, BiConsumer<Apple,String> consumer){
        for (Apple apple:source){
            consumer.accept(apple,c);
        }
    }

    private static String testFunction(Apple apple,Function<Apple,String> fun){
        return fun.apply(apple);
    }


    private static Apple testBiFunction(String color,long weight,BiFunction<String,Long,Apple> fun){
        return fun.apply(color,weight);
    }


    public static void main(String[] args) {
        List<Apple> appleList = Arrays.asList(new Apple("green",100),new Apple("yellow",150),new Apple("green",160));

        List<Apple> greenApples = filter(appleList, apple -> apple.getColor().equals("green"));
        System.out.println(greenApples);


        List<Apple> filterByWeight = filterByWeight(appleList, w -> w > 100);
        System.out.println(filterByWeight);

        System.out.println("=======================================");
        List<Apple> result1 = filterByBiPredicate(appleList, (c, w) -> c.equals("green") && w > 100);
        System.out.println(result1);

        System.out.println("=======================================");


        simpleBiConsumer("123",appleList,(a,s) -> {
            System.out.println(s + " " +a.getColor() + ":weight =>" + a.getWeight() );
        });

        System.out.println("=======================================");

        String reuslt3 = testFunction(new Apple("yellow", 100), (a) -> a.toString());

        System.out.println(reuslt3);
        System.out.println("=======================================");
        IntFunction<Double> f  = i -> i * 100.0d;

        Double reuslt4 = f.apply(10);
        System.out.println(reuslt4);
        System.out.println("=======================================");

        Supplier<String> s1 = String::new;

        System.out.println(s1.get().getClass());
        System.out.println("=======================================");

        Apple apple = testBiFunction("green", 130, (s, w) -> new Apple(s, w));
        System.out.println(apple);
    }
}
