package wlt.fox.zhizhihuhu.api;

import retrofit2.http.GET;
import rx.Observable;
import wlt.fox.zhizhihuhu.bean.zhihu.LatestNews;

/**
 * Created by wlt on 2016/9/18.
 * E-mail : autumnsassou@163.com
 */
public interface ZhihuApi {

    //http://news-at.zhihu.com/api/4/

    //http://news-at.zhihu.com/api/4/news/latest
    @GET("news/latest")
    Observable<LatestNews> getLatestNews();

}
