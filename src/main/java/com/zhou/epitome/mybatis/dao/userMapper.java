//package com.zhou.epitome.mybatis.dao;
//
//import com.weway.entity.User;
//import org.apache.ibatis.annotations.Select;
//
//public interface userMapper {
//    int insert(User record);
//
//    int insertSelective(User record);
//
//    @Select("select * from user where id ={#id}")
//    User selectByPrimaryKey(Integer id);
//}