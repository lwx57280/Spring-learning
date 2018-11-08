package com.learn.factory;

import com.learn.domain.Car;

import java.util.HashMap;
import java.util.Map;

/**
 * 创建静态工厂类,静态工厂方法
 */
public class StaticCarFactory {

    private static Map<Integer,Car> carMap;

    static {
        carMap = new HashMap<>();
        carMap.put(1,new Car(1,"奥迪"));
        carMap.put(2,new Car(2,"奥拓"));
    }

    public static Car getCar(int num){
        return carMap.get(num);
    }
}
