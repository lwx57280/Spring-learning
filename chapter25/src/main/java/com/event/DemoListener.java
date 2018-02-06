package com.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 事件监听器
 */
//1、实现ApplicationListener接口，并指定监听的事件类型
@Component
public class DemoListener implements ApplicationListener<DemoEvent> {

    //2、使用onApplicationEvent方法对消息进行接受处理
    @Override
    public void onApplicationEvent(DemoEvent event) {
        String msg = event.getMsg();
        System.out.println("我（Bean-demoListener）接收到了Bean-demoPublisher发布的消息:"+msg);
    }
}
