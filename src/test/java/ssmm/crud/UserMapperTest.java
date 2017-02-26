package ssmm.crud;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.chuang.mapper.UserMapper;
import com.chuang.model.User;

public class UserMapperTest {
	private ApplicationContext ac;
	private UserMapper um;

	@Before
	public void setUp() throws Exception {
		 ac = new ClassPathXmlApplicationContext("spring-dao.xml");
		 um = (UserMapper) ac.getBean("userMapper");
	}

	@Test
	public void testInsertUser() {
		int insert = um.insertUser(new User("zhanglei","zl123"));
		if(insert>0)
			System.out.println("插入成功");
	}

	@Test
	public void testSelectByUsernameAndPwd() {
		User u = um.selectByUsernameAndPwd("zs", "123");
		if(u!=null)
		System.out.println("用户名密码校对成功："+u);
	}

	@Test
	public void testUpdateUser() {
		int update = um.updateUser(new User(6,"lmh","lmh123"));
		if(update>0)
			System.out.println("修改成功");
	}
	
	
	@Test
	public void testdeleteUser(){
		int delete = um.deleteUser(6);
		if(delete > 0)
			System.out.println("删除成功");
	}
	
	
	@Test
	public void testselectById(){
		User user = um.selectById(2);
		if(user!=null)
		System.out.println(user);
	}
	
	@Test
	public void testselectByName(){
		List<User> ulst = um.selectByName("zh");
		if(ulst!=null)
		System.out.println(ulst);
	}
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		UserMapper um = (UserMapper) ctx.getBean("userMapper");
		User u = new User();
		u.setUsername("李四");
		u.setPassword("ls123");
		um.insertUser(u);
	}


}
