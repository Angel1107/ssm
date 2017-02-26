package com.chuang.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.chuang.model.Room;
import com.chuang.service.RoomService;

@Controller
@RequestMapping("/room")
public class RoomController {
	@Autowired
	private RoomService  roomService;
	
	@RequestMapping("/create.do")
	public	String createRoom(@RequestParam("name") String name,@RequestParam("size") int  size) {
		Room room = new Room();
		room.setName(name);
		room.setSize(size);
		roomService.createRoom(room);
		return "redirect:/";
	}
	@RequestMapping("/tocreate")
	public String  toCreatePage() {
		return "pages/createR";
	}
	
	
}
