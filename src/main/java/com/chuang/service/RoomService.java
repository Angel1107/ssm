package com.chuang.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chuang.dao.RoomDAO;
import com.chuang.model.Room;
@Service
public class RoomService {
	@Autowired
	private RoomDAO rdao;
	
	public Boolean createRoom(Room room) {
		return rdao.create(room);
	}
}
