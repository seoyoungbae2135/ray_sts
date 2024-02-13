package com.example.gradleTest2.DAO;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.gradleTest2.DTO.MyUserDto;
//20240208-1
@Mapper
public interface MyUserDaoImple {
	public List<MyUserDto> list();
}
