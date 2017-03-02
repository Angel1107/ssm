package com.chuang.web;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chuang.dao.UserDAO;
import com.chuang.model.Room;
import com.chuang.model.User;
import com.chuang.service.RoomService;

@Controller
@RequestMapping("/room")
public class RoomController {
	@Autowired
	private RoomService  roomService;
	@Autowired
	private UserDAO userDao;
	@RequestMapping("/create.do")
	public	String createRoom(@RequestParam("name") String name,@RequestParam("size") int  size) {
		Room room = new Room();
		room.setName(name);
		room.setSize(size);
		roomService.createRoom(room);
		return "redirect:/";
	}
	@RequestMapping(value="/checkAdmin",method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public boolean checkAdmin(HttpSession session) {
		User user = (User) session.getAttribute("user");
		return  userDao.checkAdmin(user);
	}
	@RequestMapping("/tocreate")
	public String toCreatePage(){
		return "pages/createR.jsp";
	}
	
}
