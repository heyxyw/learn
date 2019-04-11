package com.zhouq.java8;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * todo
 *
 * @author zhouq
 * @email zhouqiao@gmail.com
 * @date 2018/8/4 17:00
 */
public class MethodReference {

    private static <T> void useConsumer(Consumer<T> consumer,T t){
        consumer.accept(t);
    }

    public static void main(String[] args) {
        Consumer<String> consumer = (s) -> System.out.println(s);
        useConsumer(consumer,"Hello zhouq");

        useConsumer(s -> System.out.println(s),"Hello zhouq");

        useConsumer(System.out::println,"Hello zhouq");

        System.out.println("================================");

        List<Apple> apples = Arrays.asList(new Apple("green", 100), new Apple("abc", 300), new Apple("bd", 200));

        System.out.println(apples);

        apples.sort((a1,a2) -> a1.getColor().compareTo(a2.getColor()));

        System.out.println(apples);

        System.out.println("================================");

        apples.stream().forEach(System.out::println);


        int i = Integer.parseInt("123");
        System.out.println(i);


        Function<String,Integer> f =  Integer::parseInt;

        Integer result = f.apply("123");

        System.out.println(result);



    }
}
