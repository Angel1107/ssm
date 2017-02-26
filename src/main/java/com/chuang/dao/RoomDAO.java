package com.chuang.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.chuang.mapper.RoomMapper;
import com.chuang.model.Room;

@Repository
public class RoomDAO {
	@Autowired
	private RoomMapper rm;
	public boolean create(Room room) {
		return rm.createRoom(room)==1;
	}
}
