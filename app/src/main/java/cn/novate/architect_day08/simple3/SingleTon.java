package cn.novate.architect_day08.simple3;

/**
 * Email: 2185134304@qq.com
 * Created by Novate 2018/5/6 12:10
 * Version 1.0
 * Params:
 * Description:    单例 - 静态内部类（比较常用）
 *                  1. 保证线程的安全；
 *                  2. 用到的时候才会 new SingleTon() 对象；
*/

public class SingleTon {

    private SingleTon(){

    }

    public static SingleTon getInstance(){
        return SingleTonHolder.mInstance ;
    }

    public static class SingleTonHolder{
        private static volatile SingleTon mInstance = new SingleTon() ;
    }
}
