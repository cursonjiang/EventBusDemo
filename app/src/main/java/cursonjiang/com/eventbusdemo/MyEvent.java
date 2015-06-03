package cursonjiang.com.eventbusdemo;

/**
 * Created by root on 15/6/3.
 */
public class MyEvent {
    private String type;
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
