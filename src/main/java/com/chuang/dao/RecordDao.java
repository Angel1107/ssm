package com.chuang.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.chuang.mapper.RecordMapper;
import com.chuang.model.Record;

@Repository
public class RecordDao {

	@Autowired
	private RecordMapper recordMapper;
	
	public List<Record> GetRecordById(int id){
		return  recordMapper.selectByUserId(id);
	}
}
