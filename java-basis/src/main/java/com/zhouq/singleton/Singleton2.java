package com.zhouq.singleton;

/**
 * 单利模式 静态内部类方法
 */
public class Singleton2 {

    private static class Holder {
        private static Singleton2 singleton = new Singleton2();
    }

    private Singleton2() {

    }

    public static Singleton2 getUniqueInstance() {
        return Holder.singleton;
    }

}
