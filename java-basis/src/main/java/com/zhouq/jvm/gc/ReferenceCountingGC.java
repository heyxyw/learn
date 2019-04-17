package com.zhouq.jvm.gc;

/**
 * 引用计数器缺陷，其实垃圾已经被回收，但是不是通过计数器来通知的，因为下面的引用都是 1 不是 0 。
 * 设置VM options : -XX:+PrintGCDetails 观察
 * @author: zhouq
 * @email zhouqiao@gmail.com
 * @date: 2019/1/3 13:59
 */
public class ReferenceCountingGC {
    public Object instance = null;
    public static void main(String[] args) {

        ReferenceCountingGC objA = new ReferenceCountingGC();
        ReferenceCountingGC objB = new ReferenceCountingGC();
        // 互相引用
        objA.instance = objB;
        objB.instance = objA;

        objA = null;
        objB = null;
        //假设在这里发生GC ,objA 和 objB  是否会被回收
        System.gc();
    }



}


