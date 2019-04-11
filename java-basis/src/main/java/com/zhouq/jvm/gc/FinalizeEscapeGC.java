package com.zhouq.jvm.gc;

/**
 * 代码自我拯救的演示过程
 * 1.对象可有在被GC时自我拯救
 * 2.这种自我拯救的机会只有一次，因为一个对象的finalize() 方法最多只会被系统调用一次
 *
 * @author: zhouq
 * @email zhouqiao@gmail.com
 */
public class FinalizeEscapeGC {

    public static FinalizeEscapeGC SAVE_HOOK = null;

    public void isAlive(){
        System.out.println("是的，我还活着...");
    }

    //finalize 只会被系统调用一次，也就是对象只有一次拯救自己的机会。
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize 方法执行完成。");
        FinalizeEscapeGC.SAVE_HOOK = this;
    }
    public static void main(String[] args) throws InterruptedException {
        SAVE_HOOK = new FinalizeEscapeGC();

        //对象第一次拯救自己
        SAVE_HOOK = null;
        System.gc();
        Thread.sleep(500);
        if (SAVE_HOOK != null){
            SAVE_HOOK.isAlive();
        }else{
            System.out.println("我已经被回收了 。。。");
        }
        System.out.println("==================华丽的分割线=================");
        // 下面代码跟上面一致，但是这次拯救失败
        SAVE_HOOK = null;
        System.gc();
        Thread.sleep(500);
        if (SAVE_HOOK != null){
            SAVE_HOOK.isAlive();
        }else{
            System.out.println("我已经被回收了 。。。");
        }

    }
}
