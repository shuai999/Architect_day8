package cn.novate.architect_day08.simple2;

/**
 * Email: 2185134304@qq.com
 * Created by Novate 2018/5/6 11:15
 * Version 1.0
 * Params:
 * Description:    单例 - 懒汉式：只有在使用的时候，才会去new 对象
*/

public class SingleTon {

    // 只有在使用的时候，才会去 new 对象，比较高效
    // 但是会有问题？ 多线程并发的问题，如果多线程调用还是会存在多个实例的
    private static SingleTon mInstance ;

    private SingleTon(){

    }

    public static SingleTon getInstance(){
        if (mInstance == null){
            mInstance = new SingleTon() ;
        }

        return mInstance ;
    }
}
