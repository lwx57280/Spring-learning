package com.learn.factory;

import com.learn.domain.Car;

import java.util.HashMap;
import java.util.Map;

/**
 * 实例工厂类,工厂方法
 */
public class InstanceCarFactory {

    private Map<Integer,Car> carMap;

    public InstanceCarFactory() {
        carMap = new HashMap<>();
        carMap.put(1,new Car(1,"奥迪"));
        carMap.put(2,new Car(2,"奥拓"));
    }

    public Car getCar(int num){
        return carMap.get(num);
    }
}
