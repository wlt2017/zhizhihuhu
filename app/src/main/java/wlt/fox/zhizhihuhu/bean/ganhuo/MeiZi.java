package wlt.fox.zhizhihuhu.bean.ganhuo;

import java.util.List;

/**
 * Created by wlt on 2016/9/19.
 * E-mail : autumnsassou@163.com
 */
public class MeiZi {

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

        private String contentUrl;
        public String getContentUrl() {
            return contentUrl;
        }
        public void setContentUrl(String contentUrl) {
            this.contentUrl = contentUrl;
        }

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
