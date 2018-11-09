package com.proxy;

import com.service.TestService;
import com.service.impl.TestServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * AOP cglib代理应用
 */
public class MyHandler implements InvocationHandler {

    private Object target;  // 目标对象 |真实对象

    public MyHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 事务处理
        if (method.getName().startsWith("test")) {
            System.out.println("******加入事务处理*******");
        }
        // 继续调用目标对象的方法，也就是真实对象的方法
        return method.invoke(target, args);
    }


    public static void main(String[] args) {
        MyHandler handler = new MyHandler(new TestServiceImpl());

        TestService proxy =(TestService) Proxy.newProxyInstance(MyHandler.class.getClassLoader(),
                new Class[]{TestService.class}, handler);
        proxy.test();
//        proxy.test1();
//        proxy.aaa();
    }
}
