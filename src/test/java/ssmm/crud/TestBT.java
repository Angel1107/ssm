package ssmm.crud;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.chuang.mapper.RecordMapper;
import com.chuang.model.Record;

import ssmm.BaseTest;
/***
 * 通過继承BaseTest
 * @author Lc
 * 注解注入bean
 */
public class TestBT extends BaseTest{
	@Autowired
	private RecordMapper rm;
	@Test
	public void testSelectByUserId() {
		List<Record> rmb =rm.selectByUserId(2);
		System.out.println(rmb);
	}
	
}
