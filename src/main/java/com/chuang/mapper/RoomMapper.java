package com.chuang.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.chuang.model.Room;

import tk.mybatis.mapper.common.Mapper;

public interface RoomMapper extends Mapper<Room>{
	
	@Select("select * from room where id = #{id}")
	public Room selectById(int id);
	@Insert("insert into room(name,size) values(#{name},#{size})")
	public int createRoom(Room room);
}
