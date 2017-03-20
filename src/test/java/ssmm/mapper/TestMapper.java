package ssmm.mapper;

import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.chuang.mapper.LoginLogMapper;
import com.chuang.mapper.RoomMapper;
import com.chuang.model.LoginLog;
import com.chuang.model.Room;

import ssmm.BaseTest;

public class TestMapper extends BaseTest{
	Logger logger= LoggerFactory.getLogger(this.getClass());

	@Autowired
	private RoomMapper rm;
	@Autowired
	private LoginLogMapper llm;
	@Test
	public void testSelectAll() {
		List<Room> rooms = rm.selectAll();
		System.out.println(rooms);
	}
	
	/**
	 * 不能用new 的方式传递对象
	 */
	@Test
	public void testAdd(){
		Room r = new Room();
		r.setName("纽麦福");
		r.setSize(10);
		rm.insert(new Room());
	}
	
	/**
	 * 自己写的接口可以通过new 的方式传递对象
	 */
	@Test 
	public void testAddLoginLog(){
		//Timestamp d = new Timestamp(System.currentTimeMillis()); 
		llm.insertLog(new LoginLog("Test",2,"Test","Test"));
	}
}
