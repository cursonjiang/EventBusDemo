package cursonjiang.com.eventbusdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import de.greenrobot.event.EventBus;

/**
 * 涉及：事件类自定义、注册，订阅事件、事件的发布、数据解析、取消注册
 */
public class MainActivity extends AppCompatActivity {

    private TextView tv_content;
    private Button btn_send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_content = (TextView) findViewById(R.id.tv_content);
        btn_send = (Button) findViewById(R.id.btn_send);

        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyEvent myEvent = new MyEvent();
                myEvent.setType("1");
                myEvent.setContent("1内容");
                EventBus.getDefault().post(myEvent);//发送消息
            }
        });
        //注册事件
        EventBus.getDefault().register(this);
    }

    /**
     * 必须从写onEvent
     * 事件响应
     *
     * @param event
     */
    public void onEvent(MyEvent event) {
        if (event.getType().equals("0")) {
            tv_content.setText(event.getContent());
        }
    }

    public void onEventMainThread(MyEvent event) {
        if (event.getType().equals("1")) {
            tv_content.setText(event.getContent());
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //取消事件
        EventBus.getDefault().unregister(this);
    }
}
