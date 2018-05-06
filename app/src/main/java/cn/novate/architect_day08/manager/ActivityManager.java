package cn.novate.architect_day08.manager;

import android.app.Activity;

import java.util.Stack;

/**
 * Email: 2185134304@qq.com
 * Created by Novate 2018/5/6 16:30
 * Version 1.0
 * Params:
 * Description:    Activity的栈管理
*/

public class ActivityManager {

    private static volatile ActivityManager mInstance;
    // 集合 有 List LinkedList Stack  ?
    // 由于删除和添加比较多，所以可以使用 Stack栈
    private Stack<Activity> mActivities;

    private ActivityManager(){
        mActivities = new Stack<>();
    }

    // 双重校验
    public static ActivityManager getInstance() {
        if (mInstance == null) {
            synchronized (ActivityManager.class) {
                if (mInstance == null) {
                    mInstance = new ActivityManager();
                }
            }
        }
        return mInstance;
    }

    /**
     * 添加统一管理
     */
    public void attach(Activity activity){
        mActivities.add(activity);
    }

    /**
     * 移除解绑 - 防止内存泄漏
     */
    public void detach(Activity detachActivity){
        // for循环 一边循环一边移除会出问题 ，
        /*for (Activity activity : mActivities) {
            if(activity == detachActivity){
                mActivities.remove(activity);
            }
        }*/
        int size = mActivities.size();
        for (int i = 0; i < size; i++) {
            Activity activity = mActivities.get(i);
            if (activity == detachActivity) {
                mActivities.remove(i);
                i--;
                size--;
            }
        }
    }

    /**
     * 关闭当前的 Activity
     */
    public void finish(Activity finishActivity){
        // for循环 一边循环一边移除会出问题 ，
        /*for (Activity activity : mActivities) {
            if(activity == finishActivity){
                mActivities.remove(activity);
                activity.finish();
            }
        }
*/
        int size = mActivities.size();
        for (int i = 0; i < size; i++) {
            Activity activity = mActivities.get(i);
            if (activity == finishActivity) {
                mActivities.remove(i);
                activity.finish();
                i--;
                size--;
            }
        }
    }

    /**
     * 根据Activity的类名关闭 Activity
     */
    public void finish(Class<? extends Activity> activityClass){
        // for循环 一边循环一边移除会出问题 ，
        /*for (Activity activity : mActivities) {
            if(activity.getClass().getCanonicalName().equals(activityClass.getCanonicalName())){
                mActivities.remove(activity);
                activity.finish();
            }
        }*/

        int size = mActivities.size();
        for (int i = 0; i < size; i++) {
            Activity activity = mActivities.get(i);
            if (activity.getClass().getCanonicalName().equals(activityClass.getCanonicalName())) {
                mActivities.remove(i);
                activity.finish();
                i--;
                size--;
            }
        }
    }

    /**
     * 退出整个应用
     */
    public void exitApplication(){

    }

    /**
     * 获取当前的Activity（最前面）
     */
    public Activity currentActivity(){
        return mActivities.lastElement();
    }
}
