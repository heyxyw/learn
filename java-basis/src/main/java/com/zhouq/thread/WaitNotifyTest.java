package com.zhouq.thread;

/**
 * todo
 *
 * @author Administrator
 * @email zhouqiao@gmail.com
 * @date 2018/9/28 21:49
 */
public class WaitNotifyTest {
    private String[] shareObj = {"true"};

    public static void main(String[] args) {

        WaitNotifyTest test = new WaitNotifyTest();
        ThreadWait threadWait1 = test.new ThreadWait("wait thread1");
        threadWait1.setPriority(2);
        ThreadWait threadWait2 = test.new ThreadWait("wait thread2");
        threadWait2.setPriority(3);
        ThreadWait threadWait3 = test.new ThreadWait("wait thread3");
        threadWait3.setPriority(4);

        ThreadNotify threadNotify = test.new ThreadNotify(" notify com.zhouq.thread");

        threadNotify.start();
        threadWait1.start();
        threadWait2.start();
        threadWait3.start();
    }

    class ThreadWait extends Thread {
        
        public ThreadWait(String name) {
            super(name);
        }

        @Override
        public void run() {

            synchronized (shareObj) {
                while ("true".equals(shareObj[0])) {
                    System.out.println("线程" + this.getName() + "开始等待");
                    long start = System.currentTimeMillis();
                    try {
                        shareObj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    long end = System.currentTimeMillis();
                    System.out.println("线程" + this.getName() + "等待时间为：" + (end - start));
                }
            }

            System.out.println("线程" + this.getName() + "等待结束。。。");
        }
    }


    class ThreadNotify extends Thread {
        public ThreadNotify(String name) {
            super(name);
        }
        @Override
        public void run() {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (shareObj) {
                System.out.println("线程" + this.getName() + "开始准备通知");
//                shareObj[0] = "false";
                shareObj.notifyAll();
                System.out.println("线程" + this.getName() + "通知结束");
            }
            System.out.println("线程" + this.getName() + "运行结束");
        }
    }


}
