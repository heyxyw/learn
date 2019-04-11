package com.zhouq.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * 获取stream 的方式
 *
 * @author zhouq
 * @email zhouqiao@gmail.com
 * @date 2018/8/11 10:17
 */
public class CreateStream {


    /**
     * 通过 list.stream 获取stream
     * @return
     */
    private static Stream<String> createStareamFromCollection(){
        List<String> list = Arrays.asList("helllo", "zhouq", "heyxyw", "memeda");
        return list.stream();
    }

    /**
     * 通过 Stream.of 获取stream
     * @return
     */
    private static Stream<String> createStareamFromValues(){
        return Stream.of("helllo", "zhouq", "heyxyw", "memeda");
    }

    /**
     * 通过 arrays 获取
     * @return
     */
    private static Stream<String> createStreamFromArrays(){
        return Arrays.stream(new String[]{"helllo", "zhouq", "heyxyw", "memeda"});
    }

    public static void main(String[] args) {
        createStareamFromCollection().forEach(System.out::println);

        createStareamFromValues().forEach(System.out::println);

        createStreamFromArrays().forEach(System.out::println);
    }

}
