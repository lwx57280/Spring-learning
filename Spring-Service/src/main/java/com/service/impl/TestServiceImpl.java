package com.service.impl;

import com.service.TestService;

public class TestServiceImpl implements TestService {
    @Override
    public void test() {
        test1();
        System.out.println("Test.........");
    }

    @Override
    public void test1() {
        System.out.println("Test1.........");
    }

    @Override
    public void aaa() {
        System.out.println("aaa.........");
    }
}
