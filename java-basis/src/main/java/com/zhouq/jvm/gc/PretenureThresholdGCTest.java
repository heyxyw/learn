package com.zhouq.jvm.gc;

/**
 * //todo
 *
 * @author: zhouq
 * @email zhouqiao@gmail.com
 * @date: 2019/1/4 0:13
 */
public class PretenureThresholdGCTest {
    private static final int _1MB = 1024 * 1024 ;
    /**
     *
     * VM 参数： -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
     * -XX:PretenureSizeThreshold=3145728
     */
    public static void main(String[] args) {
        byte[] alloction1;
        alloction1 = new byte[4 * _1MB];

    }
}
