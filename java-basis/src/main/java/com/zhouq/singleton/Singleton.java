package com.zhouq.singleton;

/**
 * 懒汉式--双重检查锁
 *
 */
public class Singleton {

    // 加 volatile 是为了避免指令重排
    // 禁止指令重排优化这条语义直到jdk1.5以后才能正确工作。
    // 此前的JDK中即使将变量声明为volatile也无法完全避免重排序所导致的问题. 在 JDK 1.5 之前还是没办法完全避免线程安全问题。
    // 更优雅的实现，使用枚举
    private volatile static Singleton uniqueInstance;

    private Singleton() {

    }

    public static Singleton getUniqueInstance() {
        // 多加一次null 判断，好处在于，由于单利存在 new 的情况非常少，不需要每次进来都进行加锁操作，
        // 第一层null 判断会减少非常多的加锁开销。
        if (uniqueInstance == null) {
            synchronized (Singleton.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new Singleton();
                }
            }
        }
        return uniqueInstance;
    }

}
