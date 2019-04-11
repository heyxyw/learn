package com.zhouq.java8.optional;

import java.lang.management.BufferPoolMXBean;
import java.util.Optional;

/**
 * todo
 *
 * @author zhouq
 * @email zhouqiao@gmail.com
 * @date 2018/9/19 23:03
 */
public class OptionalUsage {

    public static void main(String[] args) {
        Optional<Insurance> insuranceOptional = Optional.<Insurance>empty();


//        insuranceOptional.get();

        Optional<Insurance> insurance = Optional.of(new Insurance());
//        System.out.println(insurance.get());
//
//        Optional<Insurance> objectOptional = Optional.ofNullable(null);
//
//        objectOptional.orElseGet(Insurance::new);
//
//        objectOptional.orElse(new Insurance());
//
//        objectOptional.orElseThrow(RuntimeException::new);
//
//        objectOptional.orElseThrow(() -> new RuntimeException("Not have reference"));

//        Insurance insurance1 = insuranceOptional.filter(i -> i.getName() == null).get();
//        System.out.println(insurance1);

//        Optional<String> nameOptional = insuranceOptional.map(i -> i.getName());
//        System.out.println(nameOptional.orElse("enpty value"));
//        System.out.println(nameOptional.isPresent());
//        nameOptional.ifPresent(System.out::println);

        System.out.println(getInsuranceName(null));
        System.out.println(getInsuranceNameByOptional(null));

    }


    private static String getInsuranceName(Insurance insurance){
        if (null == insurance){
            return "unknown";
        }

        return insurance.getName();
    }

    private static String getInsuranceNameByOptional(Insurance insurance){
        return Optional.ofNullable(insurance).map(Insurance::getName).orElse("unknown");
    }
}
