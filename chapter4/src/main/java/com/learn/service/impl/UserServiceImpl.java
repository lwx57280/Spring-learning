package com.learn.service.impl;

import com.learn.domain.User;
import com.learn.mapper.UserDAO;
import com.learn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("myUserService")
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDAO userDAO;

    @Override
    public User getUserById(Integer id) {
        return userDAO.getUserById(id);
    }

   /* public UserDAO getUserDAO() {
        return userDAO;
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }*/
}
