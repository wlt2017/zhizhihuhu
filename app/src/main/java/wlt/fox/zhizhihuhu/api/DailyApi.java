package wlt.fox.zhizhihuhu.api;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;
import wlt.fox.zhizhihuhu.bean.daily.DailyBean;

/**
 * Created by wlt on 2016/9/18.
 * E-mail : autumnsassou@163.com
 */
public interface DailyApi {

    //http://app3.qdaily.com/app3/

    //http://app3.qdaily.com/app3/homes/index/0.json
    @GET("homes/index/num.json")
    Observable<DailyBean> getDailyTimeLine(@Path("num") String num);

}
