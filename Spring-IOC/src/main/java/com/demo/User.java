package com.demo;

/**
 * 构造函数注入
 */
public class User {

    private String name;

    private Integer age;

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public void userInfo(){
        System.out.println(name+"======"+age);

    }
}
