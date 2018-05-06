package cn.novate.architect_day08.simple1;

/**
 * Email: 2185134304@qq.com
 * Created by Novate 2018/5/6 11:10
 * Version 1.0
 * Params:
 * Description:    单例 - 饿汉式：随着类的启动就已经 new 了一个对象了 （一般不会这么用，不太好）
*/

public class SingleTon {

    // 随着类的启动就已经 new 了一个对象了，但是可能我们只是想在用的时候再去 new 对象
    private static SingleTon mInstance = new SingleTon();

    private SingleTon(){

    }

    public static SingleTon getInstance(){
        return mInstance ;
    }
}
