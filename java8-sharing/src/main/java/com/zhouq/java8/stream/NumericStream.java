package com.zhouq.java8.stream;

import java.util.stream.IntStream;

/**
 * todo
 *
 * @author zhouq
 * @email zhouqiao@gmail.com
 * @date 2018/8/13 22:18
 */
public class NumericStream {

    public static void main(String[] args) {
//        Stream<Integer> stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7});
//        int sum = stream.mapToInt(i -> i.intValue()).filter(i -> i > 3).sum();
//        System.out.println(sum);


        int a = 9;

        //1.. 1000 哪一个值可以满足勾股定理
        //result int[a,b,c]

        IntStream.rangeClosed(1, 100).filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
                .boxed()
                .map(b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)})
                .forEach(r -> System.out.println("a=" + r[0] + ",b=" + r[1] + ",c=" + r[2]));

        System.out.println("===============================================");

        IntStream.rangeClosed(1, 100)
                .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
                .mapToObj(b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)})
                .forEach(r -> System.out.println("a=" + r[0] + ",b=" + r[1] + ",c=" + r[2]));

//        intStream.forEach(System.out::println);
    }
}
