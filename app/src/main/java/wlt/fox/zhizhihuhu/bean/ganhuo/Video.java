package wlt.fox.zhizhihuhu.bean.ganhuo;

import java.util.List;

/**
 * Created by wlt on 2016/9/19.
 * E-mail : autumnsassou@163.com
 */
public class Video {

    /**
     * error : false
     * results : [{"_id":"57df5b87421aa95bc7f06a56","createdAt":"2016-09-19T11:29:11.672Z","desc":"BGM配的太好了哈哈哈哈哈哈哈","publishedAt":"2016-09-19T11:36:25.457Z","source":"chrome","type":"休息视频","url":"http://weibo.com/p/230444a69d54b688c351a2ffa8baf4edba8f0b","used":true,"who":"娱乐娱乐"},{"_id":"57da32bc421aa95bd05015bd","createdAt":"2016-09-15T13:33:48.28Z","desc":"程序员的第一次约会！这真的是程序员被黑的最惨的一次了！23333333","publishedAt":"2016-09-18T11:36:10.609Z","source":"chrome","type":"休息视频","url":"http://toutiao.com/i6330157221892063745/?tt_from=sina&utm_campain=client_share&app=news_article&utm_source=sinaweibo&iid=5368972119&utm_medium=toutiao_ios","used":true,"who":"lxxself"},{"_id":"57d68dac421aa90981539503","createdAt":"2016-09-12T19:12:44.91Z","desc":"【敖厂长】斯大林请冷静！","publishedAt":"2016-09-14T11:35:01.991Z","source":"chrome","type":"休息视频","url":"http://www.bilibili.com/video/av6209709/","used":true,"who":"LHF"},{"_id":"57d6e0d6421aa95bd050159e","createdAt":"2016-09-13T01:07:34.766Z","desc":"李宗盛 ：人生沒有白走的路，每一步都算數。","publishedAt":"2016-09-13T11:36:54.991Z","source":"chrome","type":"休息视频","url":"http://v.youku.com/v_show/id_XMTYwNTYwMDg1Ng==.html?from=s1.8-1-1.2&spm=0.0.0.0.HUbBbY","used":true,"who":"lxxself"},{"_id":"57d61b67421aa909815394f9","createdAt":"2016-09-12T11:05:11.184Z","desc":"性苦闷者的呐喊","publishedAt":"2016-09-12T11:34:31.135Z","source":"chrome","type":"休息视频","url":"http://v.youku.com/v_show/id_XMTcxODMzMjU2MA==.html?beta&","used":true,"who":"代码家"},{"_id":"57c7e22e421aa9125d96f552","createdAt":"2016-09-01T16:09:18.661Z","desc":"这个成语接龙有毒，智商已经逆天了，哈哈哈~为所欲为你妹啊！","publishedAt":"2016-09-09T11:53:48.777Z","source":"chrome","type":"休息视频","url":"http://v.youku.com/v_show/id_XMTcwODUxOTQ2NA==.html?beta&from=s1.8-1-1.2&spm=0.0.0.0.KEya7A","used":true,"who":"代码家"},{"_id":"57cebfd4421aa91a108fc6dc","createdAt":"2016-09-06T21:08:36.812Z","desc":"【文曰小强】6分钟看完2016雨果奖《北京折叠》原著","publishedAt":"2016-09-08T11:43:04.471Z","source":"chrome","type":"休息视频","url":"http://www.bilibili.com/video/av6128318/","used":true,"who":"LHF"},{"_id":"57cee442421aa91a0c3df5e3","createdAt":"2016-09-06T23:44:02.955Z","desc":"你是一个人吗？","publishedAt":"2016-09-07T11:50:57.951Z","source":"chrome","type":"休息视频","url":"http://v.qq.com/x/page/c0326sz7fuk.html","used":true,"who":"lxxself"},{"_id":"57c845b6421aa97cb9511680","createdAt":"2016-09-01T23:13:58.592Z","desc":"拖延症患者终极躺枪之作《就今天！》","publishedAt":"2016-09-06T11:35:21.379Z","source":"chrome","type":"休息视频","url":"http://v.youku.com/v_show/id_XMTY5NTI5Njg5Ng==.html?beta&","used":true,"who":"lxxself"},{"_id":"57cb6e79421aa97cbd81c75f","createdAt":"2016-09-04T08:44:41.861Z","desc":"老师教2+2=5，坚持2+2=4何等不易!","publishedAt":"2016-09-05T11:32:16.999Z","source":"chrome","type":"休息视频","url":"http://www.miaopai.com/show/dSpYA0hMK4DRvsJqOxEpNw__.htm","used":true,"who":"代码家"}]
     */

    private boolean error;
    /**
     * _id : 57df5b87421aa95bc7f06a56
     * createdAt : 2016-09-19T11:29:11.672Z
     * desc : BGM配的太好了哈哈哈哈哈哈哈
     * publishedAt : 2016-09-19T11:36:25.457Z
     * source : chrome
     * type : 休息视频
     * url : http://weibo.com/p/230444a69d54b688c351a2ffa8baf4edba8f0b
     * used : true
     * who : 娱乐娱乐
     */

    private List<ResultsBean> results;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean {
        private String _id;
        private String createdAt;
        private String desc;
        private String publishedAt;
        private String source;
        private String type;
        private String url;
        private boolean used;
        private String who;

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getPublishedAt() {
            return publishedAt;
        }

        public void setPublishedAt(String publishedAt) {
            this.publishedAt = publishedAt;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public boolean isUsed() {
            return used;
        }

        public void setUsed(boolean used) {
            this.used = used;
        }

        public String getWho() {
            return who;
        }

        public void setWho(String who) {
            this.who = who;
        }

        @Override
        public String toString() {
            return "ResultsBean{" +
                    "_id='" + _id + '\'' +
                    ", createdAt='" + createdAt + '\'' +
                    ", desc='" + desc + '\'' +
                    ", publishedAt='" + publishedAt + '\'' +
                    ", source='" + source + '\'' +
                    ", type='" + type + '\'' +
                    ", url='" + url + '\'' +
                    ", used=" + used +
                    ", who='" + who + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "Video{" +
                "error=" + error +
                ", results=" + results +
                '}';
    }
}
