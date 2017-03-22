package waimai.yunlian.com.okstar.model;

/**
 * Created by Stran on 2016/12/22.
 */

public class Msg {
    public static int TYPE_SEND=0;
    public static int TYPE_RECICE=1;
    private String content;
    private int type;

    public Msg(String content, int type) {
        this.content = content;
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

}
