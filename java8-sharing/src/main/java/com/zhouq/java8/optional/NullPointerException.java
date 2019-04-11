package com.zhouq.java8.optional;

/**
 * NPE 问题测试
 *
 * @author zhouq
 * @email zhouqiao@gmail.com
 * @date 2018/9/19 22:25
 */
public class NullPointerException {

    public static void main(String[] args) throws InterruptedException {

//        String insuranceName = getCarInsuranceName(new Person());

        String result = getInsuranceNameByDeepDouble(new Person());
        Thread.sleep(3000);
        System.out.println(result);

    }

    //获取汽车保险名称,不带NPE 验证
    public static String getCarInsuranceName(Person person) {
        return person.getCar().getInsurance().getName();
    }

    //带检查NPE 写法
    public static String getInsuranceNameByDeepDouble(Person person){
        if (null != person){
            Car car = person.getCar();
            if (null != car){
                Insurance insurance = car.getInsurance();
                if (null != null){
                    return insurance.getName();
                }
            }
        }

        return "UNKNOWN";
    }

    //遇到 null 就返回默认值
    public static String getInsuranceNameByMultExit(Person person){
        final String defaultValue = "UNKNOWN";
        if (null == person){
            return defaultValue;
        }
        Car car = person.getCar();
        if (null ==  car){
            return defaultValue;
        }
        Insurance insurance = car.getInsurance();
        if (insurance == null){
            return defaultValue;
        }

        return insurance.getName();
    }


}
