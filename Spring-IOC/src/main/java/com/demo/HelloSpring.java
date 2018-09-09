package com.demo;


/**
 * Hello world!
 */
public class HelloSpring {
    private String who = null;

    public String getWho() {
        return who;
    }

    public void setWho(String who) {
        this.who = who;
    }

    public void print() {
        System.out.println("Hello," + this.getWho() + "!");
    }
}
