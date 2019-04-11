package com.zhouq.this1;

/**
 * todo
 *
 * @author zhouq
 * @email zhouqiao@gmail.com
 * @date 2018/6/7 22:37
 */
public class ThisTest2 {


    static class Person {
         void eat(Apple apple){
             Apple peeled = apple.getPeeled();
             System.out.println(peeled);
         }
    }

    static class Peeler {
        static Apple peel(Apple apple){
            return apple;
        }
    }

    static class Apple {
        Apple getPeeled(){ return Peeler.peel(this);}
    }

    static class PassingThis{
        public static void main(String[] args) {
            new Person().eat(new Apple());
        }
    }
}
