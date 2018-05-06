package cn.novate.architect_day08;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import cn.novate.architect_day08.manager.ActivityManager;

/**
 * Email: 2185134304@qq.com
 * Created by Novate 2018/5/6 16:47
 * Version 1.0
 * Params:
 * Description:
*/

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManager.getInstance().attach(this);
        setContentView(R.layout.activity_main);
        setTitle("RegisterActivity");
    }

    public void click(View view){
        // 不光要关闭自己还要关闭 LoginActivity 让其回到主页
        ActivityManager.getInstance().finish(this);
        ActivityManager.getInstance().finish(LoginActivity.class);
    }

    @Override
    public void onDestroy() {
        ActivityManager.getInstance().detach(this);
        super.onDestroy();
    }
}
