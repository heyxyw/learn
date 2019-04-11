package com.zhouq.this1;

/**
 * this 关键字
 *
 * @author zhouq
 * @email zhouqiao@gmail.com
 * @date 2018/6/7 22:25
 */
public class Leaf {
    int i = 0;
    Leaf increment(){
        i ++;
        return this;
    }
    void print(){
        System.out.println("i = " + i);
    }

    public static void main(String[] args) {
        Leaf leaf = new Leaf();
        leaf.increment().increment().increment().print();
    }
}
