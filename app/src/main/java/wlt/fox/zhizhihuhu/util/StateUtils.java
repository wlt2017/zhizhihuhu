package wlt.fox.zhizhihuhu.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by wlt on 2016/9/18.
 * E-mail : autumnsassou@163.com
 */
public class StateUtils {

    public static boolean isNetworkAvailable(Context context) {
       if(context !=null){
           ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
           NetworkInfo info = cm.getActiveNetworkInfo();
           if(info !=null){
               return info.isAvailable();
           }
       }
        return false;
    }
}
