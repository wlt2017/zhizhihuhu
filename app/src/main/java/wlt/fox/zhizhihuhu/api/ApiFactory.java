package wlt.fox.zhizhihuhu.api;

/**
 * Created by wlt on 2016/9/18.
 * E-mail : autumnsassou@163.com
 */
public class ApiFactory {

    protected static final Object monitor = new Object();
    static ZhihuApi zhihuApiSingleton = null;
    static GankApi gankApiSingleton = null;
    static DailyApi dailyApiSingleton = null;

    //return Singleton
    public static ZhihuApi getZhihuApiSingleton() {
        synchronized (monitor) {
            if (zhihuApiSingleton == null) {
                zhihuApiSingleton = new ApiRetrofit().getZhihuApiService();
            }
            return zhihuApiSingleton;
        }
    }

    public static GankApi getGankApiSingleton() {
        synchronized (monitor) {
            if (gankApiSingleton == null) {
                gankApiSingleton = new ApiRetrofit().getGankApiService();
            }
            return gankApiSingleton;
        }
    }

    public static DailyApi getDailyApiSingleton() {
        synchronized (monitor) {
            if (dailyApiSingleton == null) {
                dailyApiSingleton = new ApiRetrofit().getDailyApiService();
            }
            return dailyApiSingleton;
        }
    }
}
