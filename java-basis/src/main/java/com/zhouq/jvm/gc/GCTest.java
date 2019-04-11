package com.zhouq.jvm.gc;

/**
 * 新生代 Minor GC 测试
 *
 * @author: zhouq
 * @email zhouqiao@gmail.com
 *
 */
public class GCTest {

    private static final int _1MB = 1024 * 1024 ;

    /**
     *
     * VM 参数： -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
     */
    public static void main(String[] args) {
        byte[] alloction1 ,alloction2,alloction3,alloction4;

        alloction1 = new byte[2 * _1MB];
        alloction2 = new byte[2 * _1MB];
        alloction3 = new byte[2 * _1MB];
        alloction4 = new byte[4 * _1MB]; //出现一次 Minor GC

    }
}
