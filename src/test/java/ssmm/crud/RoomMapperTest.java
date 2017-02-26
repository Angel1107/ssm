package ssmm.crud;


import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.chuang.mapper.RoomMapper;
import com.chuang.model.Room;

public class RoomMapperTest {
	private RoomMapper rm;
	@SuppressWarnings("resource")
	@Before
	public void setUp() throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-dao.xml");
		rm = (RoomMapper) context.getBean("roomMapper");
	}

	@Test
	public void testSelectById() {
		Room rmb =  rm.selectById(1001);
		System.out.println(rmb);
	}

}
