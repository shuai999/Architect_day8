package cn.novate.architect_day08.simple4;

import java.util.HashMap;
import java.util.Map;

/**
 * Email: 2185134304@qq.com
 * Created by Novate 2018/5/6 12:10
 * Version 1.0
 * Params:
 * Description:    单例 - 容器管理（系统服务里边用的这种 getSystemService()）
*/

public class SingleTon {

    private static Map<String , Object> mSingleMap = new HashMap<>() ;

    private SingleTon(){

    }


    /**
     * 用静态的方式把 SingleTon对象初始化好了
     */
    static {
        mSingleMap.put("activity_manager" , new SingleTon()) ;
    }

    public static Object getService(String serviceName){
        return mSingleMap.get(serviceName) ;
    }
}
