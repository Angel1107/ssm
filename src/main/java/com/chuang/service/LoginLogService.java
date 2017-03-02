package com.chuang.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chuang.dao.LoginLogDao;
import com.chuang.model.LoginLog;

@Service
public class LoginLogService {
	@Autowired
	private LoginLogDao logDao;
	public int insertLog(LoginLog log){
		return logDao.insertLog(log);
	}
}
