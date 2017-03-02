package com.chuang.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.chuang.model.User;

public interface UserMapper {
    
    //@Insert("INSERT INTO userinfo(username, password) VALUES(#{username},#{password})")
    public int insertUser(User user);
    
    @Select("SELECT * FROM userinfo WHERE username = #{username} AND password = #{password}")
    @Results(value = { @Result(id = true, column = "id", property = "id"),
                       @Result(column = "username", property = "username"), 
                       @Result(column = "password", property = "password"),
                       @Result(column = "phone", property = "phone")})
    public User selectByUsernameAndPwd(@Param("username")String username ,@Param("password")String password);
    
    public int updateUser(User user);
    @Delete("delete from userinfo where id = #{id}")
    public int deleteUser(int id); 
    @Select("select * from userinfo where id = #{id}")
    public User selectById(int id);
    
    public List<User> selectByName(String name);
    @Select("select * from userinfo where username=#{username}")
    public User selectByUname(String name);
    
    @Select("select * from userinfo where IsAdmin = 'Y' and id = #{id}")
    public User selectAdmin(int id);
}