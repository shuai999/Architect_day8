package cn.novate.architect_day08.simple5;

/**
 * Email: 2185134304@qq.com
 * Created by Novate 2018/5/6 12:25
 * Version 1.0
 * Params:
 * Description:    单例 - 自成一派
*/

public class SingleTon {

    private static SingleTon mInstance ;

    static {
        mInstance = new SingleTon() ;
    }

    private SingleTon(){

    }

    public static SingleTon getInstance(){
        return mInstance ;
    }
}
