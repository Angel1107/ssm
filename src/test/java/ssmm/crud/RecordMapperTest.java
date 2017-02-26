package ssmm.crud;


import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.chuang.mapper.RecordMapper;
import com.chuang.model.Record;

public class RecordMapperTest {
	private ApplicationContext ctx;
	private RecordMapper rm;
	
	@Before
	public void setUp() throws Exception {
		ctx = new ClassPathXmlApplicationContext("spring-dao.xml");
		 rm =  (RecordMapper) ctx.getBean("recordMapper");
	}

	@Test
	public void testSelectByUserId() {
		List<Record> rmb =rm.selectByUserId(2);
		System.out.println(rmb);
	}

}
