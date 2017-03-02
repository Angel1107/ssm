package com.chuang.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.chuang.mapper.LoginLogMapper;
import com.chuang.model.LoginLog;

@Repository
public class LoginLogDao {
	@Autowired
	private LoginLogMapper logMapper;
	public int insertLog(LoginLog log){
		return logMapper.insertLog(log);
	}
}
