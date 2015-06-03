package cursonjiang.com.eventbusdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import de.greenrobot.event.EventBus;

/**
 * Created by root on 15/6/3.
 */
public class EventBusTest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        //注册订阅
        EventBus.getDefault().register(this);
    }

    /**
     * 发送数据
     */
    private void postData() {
        EventBus.getDefault().post("消息");
    }

    //以下方法是接收数据消息事件 方法名必须一致
    public void Event(String string) {

    }

    public void onEventMainThread(String string) {

    }

    public void EventPostThread(String string) {

    }

    public void onEventBackgroundThread(String string) {

    }

    public void onEventAsync(String string) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        //取消订阅
        EventBus.getDefault().unregister(this);
    }
}
