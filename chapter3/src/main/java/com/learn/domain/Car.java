package com.learn.domain;

public class Car {

    private Integer num;

    private String brand;

    public Car(Integer num, String brand) {
        this.num = num;
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Car{" +
                "num=" + num +
                ", brand='" + brand + '\'' +
                '}';
    }
}
