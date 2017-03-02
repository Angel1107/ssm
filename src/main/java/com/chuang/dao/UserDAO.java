package com.chuang.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.chuang.mapper.UserMapper;
import com.chuang.model.User;

@Repository
public class UserDAO {
    
    @Autowired
    private UserMapper userMapper;
    
    public boolean register(User user){
        return userMapper.insertUser(user)==1?true:false;
    }
    
    public User login(String username ,String password){
        return userMapper.selectByUsernameAndPwd(username, password);
    }
    
    public User checkName(String username) {
		return userMapper.selectByUname(username);
	}
    
    public boolean checkAdmin(User user){
    	return userMapper.selectAdmin(user.getId())!=null?true:false;
    }
}