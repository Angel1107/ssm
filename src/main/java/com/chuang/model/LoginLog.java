package com.chuang.model;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class LoginLog {
	private int logId;
	private Timestamp loginTime;
	private String ip;
	private int userId;
	private String osName;
	private String userAgent;
	
	public LoginLog() {
		super();
	}
	
	public LoginLog(String ip, int userId, String osName, String userAgent) {
		super();
		this.ip = ip;
		this.userId = userId;
		this.osName = osName;
		this.userAgent = userAgent;
	}

}
