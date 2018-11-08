package com.learn;

import com.learn.domain.Car;
import com.learn.domain.User;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;


/**
 * Hello world!
 */
public class App {
    private static final Logger logger = Logger.getLogger(App.class);

    public static void main(String[] args) {

        // 获取数据源
        //loadDataSource();

        InitialBean();
    }

    private static void loadDataSource() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        DataSource dataSource = (DataSource) applicationContext.getBean("dataSource");
        Connection conn = null;
        logger.info("获取数据库连接资源");
        try {
            conn = dataSource.getConnection();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(conn);
        logger.info("成功获取数据库连接资源");
    }

    private static void InitialBean() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Spring.xml");
       // User user = (User) applicationContext.getBean("user");

        User user2 = (User) applicationContext.getBean("user3");

       // System.out.println(user == user2);

        Car car = (Car) applicationContext.getBean("car");

        System.out.println("user2==" + user2);
    }
}
