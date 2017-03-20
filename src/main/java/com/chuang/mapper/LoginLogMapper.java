package com.chuang.mapper;

import org.apache.ibatis.annotations.Insert;

import com.chuang.model.LoginLog;

import tk.mybatis.mapper.common.Mapper;

public interface LoginLogMapper extends Mapper<LoginLog> {
	
	@Insert("INSERT INTO loginlog(ip,userid,osName,userAgent) VALUES(#{ip},#{userId},#{osName},#{userAgent})")
	public int insertLog(LoginLog log);
}
