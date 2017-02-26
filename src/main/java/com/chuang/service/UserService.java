package com.chuang.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chuang.dao.UserDAO;
import com.chuang.model.User;

@Service
public class UserService {
    
    @Autowired
    private UserDAO userDao;
    
    public boolean register(User user){
        return userDao.register(user);
    }
    
    public User login(String username, String password) {
        return userDao.login(username, password);
    }
    
    public User checkName(String username) {
		return userDao.checkName(username);
	}
}