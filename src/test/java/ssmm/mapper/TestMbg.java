package ssmm.mapper;

import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.chuang.mapper.TestmbgMapper;
import com.chuang.model.Testmbg;

import ssmm.BaseTest;

public class TestMbg extends BaseTest{
	@Autowired
	private TestmbgMapper tmbgm;
	
	/**
	 * 通过generator生成的mapper  可以实现new的方式传递对象
	 */
	@Test
	public void tmbg(){
		tmbgm.insert(new Testmbg("0000", "1111", 2222, new Date()));
		//List lst = tmbgm.selectAll();
		//System.out.println(lst);
	}
	
}
