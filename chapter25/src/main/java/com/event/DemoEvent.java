package com.event;

import org.springframework.context.ApplicationEvent;

/**
 * 自定义事件
 */
public class DemoEvent extends ApplicationEvent {

    private static final long serialVersionUID = 5295610966788379240L;
    private String msg;
    public DemoEvent(Object source, String msg) {
        super(source);
        this.msg=msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
