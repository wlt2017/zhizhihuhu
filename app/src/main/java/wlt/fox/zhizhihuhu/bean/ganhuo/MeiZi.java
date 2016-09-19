package wlt.fox.zhizhihuhu.bean.ganhuo;

import java.util.List;

/**
 * Created by wlt on 2016/9/19.
 * E-mail : autumnsassou@163.com
 */
public class MeiZi {

    /**
     * error : false
     * results : [{"_id":"57de9714421aa95bc338982c","createdAt":"2016-09-18T21:31:00.863Z","desc":"9-19","publishedAt":"2016-09-19T11:36:25.457Z","source":"chrome","type":"福利","url":"http://ww2.sinaimg.cn/large/610dc034jw1f7y296c5taj20u00u0tay.jpg","used":true,"who":"daimajia"},{"_id":"57dd46a4421aa95bcb130126","createdAt":"2016-09-17T21:35:32.195Z","desc":"9-18","publishedAt":"2016-09-18T11:36:10.609Z","source":"chrome","type":"福利","url":"http://ww1.sinaimg.cn/large/610dc034jw1f7wws4xk5nj20u011hwhb.jpg","used":true,"who":"daimajia"},{"_id":"57d8982f421aa95bd05015af","createdAt":"2016-09-14T08:22:07.587Z","desc":"9-14","publishedAt":"2016-09-14T11:35:01.991Z","source":"chrome","type":"福利","url":"http://ww1.sinaimg.cn/large/610dc034jw1f7sszr81ewj20u011hgog.jpg","used":true,"who":"daimajia"},{"_id":"57d741cc421aa95bc7f06a17","createdAt":"2016-09-13T08:01:16.18Z","desc":"9-13","publishedAt":"2016-09-13T11:36:54.991Z","source":"chrome","type":"福利","url":"http://ww3.sinaimg.cn/large/610dc034jw1f7rmrmrscrj20u011hgp1.jpg","used":true,"who":"代码家"},{"_id":"57d5ed65421aa909895ffa5f","createdAt":"2016-09-12T07:48:53.693Z","desc":"9 - 12","publishedAt":"2016-09-12T11:34:31.135Z","source":"chrome","type":"福利","url":"http://ww1.sinaimg.cn/large/610dc034jw1f7qgschtz8j20hs0hsac7.jpg","used":true,"who":"代码家"},{"_id":"57d16f1b421aa90d2d8a4f52","createdAt":"2016-09-08T22:00:59.815Z","desc":"09-09","publishedAt":"2016-09-09T11:53:48.777Z","source":"chrome","type":"福利","url":"http://ww2.sinaimg.cn/large/610dc034jw1f7mixvc7emj20ku0dv74p.jpg","used":true,"who":"代码家"},{"_id":"57d0a893421aa90d312ebeff","createdAt":"2016-09-08T07:53:55.620Z","desc":"9-9","publishedAt":"2016-09-08T11:43:04.471Z","source":"chrome","type":"福利","url":"http://ww1.sinaimg.cn/large/610dc034jw1f7lughzrjmj20u00k9jti.jpg","used":true,"who":"代码家"},{"_id":"57cf601d421aa90d2d8a4f3b","createdAt":"2016-09-07T08:32:29.460Z","desc":"09-07","publishedAt":"2016-09-07T11:50:57.951Z","source":"chrome","type":"福利","url":"http://ww1.sinaimg.cn/large/610dc034jw1f7kpy9czh0j20u00vn0us.jpg","used":true,"who":"代码家"},{"_id":"57ce103a421aa910f56bd8b9","createdAt":"2016-09-06T08:39:22.211Z","desc":"9-7","publishedAt":"2016-09-06T11:35:21.379Z","source":"chrome","type":"福利","url":"http://ww2.sinaimg.cn/large/610dc034jw1f7jkj4hl41j20u00mhq68.jpg","used":true,"who":"代码家"},{"_id":"57cc16c9421aa910f56bd8ab","createdAt":"2016-09-04T20:42:49.403Z","desc":"09-05","publishedAt":"2016-09-05T11:32:16.999Z","source":"chrome","type":"福利","url":"http://ww1.sinaimg.cn/large/610dc034jw1f7hu7d460oj20u00u075u.jpg","used":true,"who":"daimajia"}]
     */

    private boolean error;
    /**
     * _id : 57de9714421aa95bc338982c
     * createdAt : 2016-09-18T21:31:00.863Z
     * desc : 9-19
     * publishedAt : 2016-09-19T11:36:25.457Z
     * source : chrome
     * type : 福利
     * url : http://ww2.sinaimg.cn/large/610dc034jw1f7y296c5taj20u00u0tay.jpg
     * used : true
     * who : daimajia
     */

    private List<Results> results;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<Results> getResults() {
        return results;
    }

    public void setResults(List<Results> results) {
        this.results = results;
    }

    public static class Results {
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
            return "Results{" +
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
        return "MeiZi{" +
                "error=" + error +
                ", results=" + results +
                '}';
    }
}
