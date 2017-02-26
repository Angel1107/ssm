package com.chuang.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chuang.dao.RecordDao;
import com.chuang.model.Record;

@Service
public class RecoedService {
	@Autowired
	private RecordDao recordDao;
	
	public List<Record> selectRecords(int id){
		return recordDao.GetRecordById(id);
	}
	
}
