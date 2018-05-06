package cn.novate.architect_day08.simple2.sync;

/**
 * Email: 2185134304@qq.com
 * Created by Novate 2018/5/6 11:15
 * Version 1.0
 * Params:
 * Description:    单例 - 懒汉式： (同步锁：DCL)
 *                 只有在使用的时候，才会去new 对象
 *                 DCL定义：就是单例设计模式懒汉式同步锁的方式
*/

public class SingleTon3 {

    // 只有在使用的时候，才会去 new 对象，比较高效
    // 但是会有问题？ 多线程并发的问题，如果多线程调用还是会存在多个实例的

    // 加上 volatile 好处是什么？
    // 1.防止重新排序
    private static volatile SingleTon3 mInstance ;

    private SingleTon3(){

    }


    /**
     * 双重校验加同步锁 synchronized：
     *      既保证线程安全，同时也保证效率比较高
     *      但是可能还会有问题，
     */
    public static SingleTon3 getInstance(){
        if (mInstance == null){
            synchronized (SingleTon3.class){    // 这个if只能进来一次，第二次就不会进来了
                if (mInstance == null){
                    mInstance = new SingleTon3() ;
                }
            }
        }

        return mInstance ;
    }
}
