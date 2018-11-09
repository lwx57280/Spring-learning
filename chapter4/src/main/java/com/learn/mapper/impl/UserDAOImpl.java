package com.learn.mapper.impl;

import com.learn.domain.User;
import com.learn.mapper.UserDAO;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UserDAOImpl implements UserDAO {


    private static Map<Integer,User> userMap;

    static {
        userMap = new HashMap<>();
        userMap.put(1,new User(1,"张三"));
        userMap.put(2,new User(2,"李四"));
        userMap.put(3,new User(3,"王五"));
    }

    @Override
    public User getUserById(Integer id) {
        return userMap.get(id);
    }
}
