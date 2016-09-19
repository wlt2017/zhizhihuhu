package wlt.fox.zhizhihuhu.api;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;
import wlt.fox.zhizhihuhu.bean.ganhuo.MeiZi;
import wlt.fox.zhizhihuhu.bean.ganhuo.Video;

/**
 * Created by wlt on 2016/9/18.
 * E-mail : autumnsassou@163.com
 */
public interface GankApi {
    //http://gank.io/api/

    //http://gank.io/api/data/福利/10/1
    @GET("data/福利/10/{page}")
    Observable<MeiZi> getMeiziData(@Path("page") int page);

    //http://gank.io/api/data/休息视频/10/1
    @GET("data/休息视频/10/{page}")
    Observable<Video> getVideoData(@Path("page") int page);

}
