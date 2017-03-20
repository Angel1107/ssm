package com.chuang.mapper;

import java.util.List;

import com.chuang.model.Record;


public interface RecordMapper{

	public List<Record> selectByUserId(int id);
}
