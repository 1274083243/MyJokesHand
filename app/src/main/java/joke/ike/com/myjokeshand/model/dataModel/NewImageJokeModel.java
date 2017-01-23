package joke.ike.com.myjokeshand.model.dataModel;

/**
作者：ike
时间：2017/1/23 10:14
功能描述：图片笑话数据实体
**/
public class NewImageJokeModel {

    /**
     * content : 这世界很大，我想去看看
     * url : http://juheimg.oss-cn-hangzhou.aliyuncs.com/joke/201505/31/DDB2B43D258C23DFE191E89788C921CF.jpg
     * hashId : DDB2B43D258C23DFE191E89788C921CF
     * unixtime : 1433015033
     */

    private String content;
    private String url;
    private String hashId;
    private String unixtime;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getHashId() {
        return hashId;
    }

    public void setHashId(String hashId) {
        this.hashId = hashId;
    }

    public String getUnixtime() {
        return unixtime;
    }

    public void setUnixtime(String unixtime) {
        this.unixtime = unixtime;
    }
}
