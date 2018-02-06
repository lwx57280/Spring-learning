package com.el;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * 需要被注入的Bean
 */
@Service
public class DemoService {

    /**
     * 1、此处为注入普通字符串
     */
    @Value("其他类的属性")
    private String anothor;

    public String getAnothor() {
        return anothor;
    }

    public void setAnothor(String anothor) {
        this.anothor = anothor;
    }
}
