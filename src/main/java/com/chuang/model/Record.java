package com.chuang.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Record {
	private int id;
	private User user;
	private Room room;
	private String content;
	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss.SSSZ" )
	private Date createtime;
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public Record() {
		
	}
	
	@Override
	public String toString() {
		return "Record [id=" + id + ", user=" + user + ", room=" + room + ", content=" + content + ", createtime="
				+ createtime + "]";
	}
}
