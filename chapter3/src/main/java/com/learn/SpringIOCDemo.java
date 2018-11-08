package com.learn;

import com.learn.domain.Car;
import com.learn.domain.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Spring IOC工厂方法 + 自动装载
 */
public class SpringIOCDemo {
    public static void main(String[] args) {
        //staticFactoryDemo();

//        instanceFactoryDemo();

//        byNamePerson();

        byTypePerson();
    }

    /**
     * 创建静态工厂类,静态工厂方法
     */
    private static void staticFactoryDemo() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        Car car = (Car) applicationContext.getBean("car");
        System.out.println(car);
    }

    /**
     * 实例工厂类,工厂方法
     */
    private static void instanceFactoryDemo() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        Car car2 = (Car) applicationContext.getBean("car2");
        System.out.println(car2);
    }

    /**
     * byName:通过属性名自动装载。
     */
    private static void byNamePerson(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Person person = (Person) applicationContext.getBean("person");
        System.out.println(person);
    }

    /**
     * byType:通过属性对应的数据类型自动装载。
     */
    private static void byTypePerson(){

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        Person person = (Person) applicationContext.getBean("person");
        System.out.println(person);
    }
}
