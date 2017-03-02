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
}
