package wlt.fox.zhizhihuhu;

import android.app.Application;
import android.content.Context;

/**
 * Created by wlt on 2016/9/18.
 * E-mail : autumnsassou@163.com
 */
public class MyApp extends Application {

    private static final String DB_NAME = "weibo.db";

    public static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
    }
}
