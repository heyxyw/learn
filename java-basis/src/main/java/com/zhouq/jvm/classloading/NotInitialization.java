package com.zhouq.jvm.classloading;

/**
 * 被动使用类字段演示：
 * 1.通过子类引用父类静态字段，不会触发子类的初始化
 * 2.通过数组定义来引用类，不会触发此类的初始化
 * 3.常量在编译阶段就会存入常量池中，本质上并没有直接引用到定义常量的类，因此不会触发定义常量类的初始化
 *
 * @author: zhouq
 * @Date: 2019/1/2 10:26
 */
public class NotInitialization {

    static class SuperClass {
        static {
            System.out.println("SuperClass init!");
        }

        public static int value = 123;
    }

    static class SubClass extends SuperClass {
        static {
            System.out.println("SubClass init!");
        }
    }


    static class ConstClass {
        static {
            System.out.println("ConstClass init !");
        }

        public static final String HELLOWORLD = "hello world!";
    }


    public static void main(String[] args) {
        //1.非主动使用类字段演示
        System.out.println(SubClass.value);

        System.out.println("=============================华丽的分割线=============================");
        //2.数组定义
        SuperClass[] sca = new SuperClass[10];
        System.out.println(sca);

        System.out.println("=============================华丽的分割线=============================");
        //3.常量在编译阶段就会存入常量池中，本质上并没有直接引用到定义常量的类，因此不会触发定义常量类的初始化

        System.out.println(ConstClass.HELLOWORLD);
    }

}
