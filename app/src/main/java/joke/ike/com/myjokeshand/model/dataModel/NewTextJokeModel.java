package joke.ike.com.myjokeshand.model.dataModel;

/**
作者：ike
时间：2017/1/20 10:20
功能描述：首页推荐笑话的数据实体模型
**/

public class NewTextJokeModel {

    /**
     * content : 　　我和对象在一起两年了，没有一张合影，没有任何礼物，我都不想说我谈个恋爱连玫瑰花都没收到过，情人节巧克力都是我自己买给自己，一起吃饭也不主动埋单，有一次散步累了我想要抱抱却被说娇情，从来都不在乎我，我伤心了也不安慰我，甚至有男生盯着我看也无动于衷，她是不是有其他男人了？
     * hashId : AA2D771B735C7278356ED7FCD5E8BB60
     * unixtime : 1421779500
     */

    private String content;
    private String hashId;
    private String unixtime;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
