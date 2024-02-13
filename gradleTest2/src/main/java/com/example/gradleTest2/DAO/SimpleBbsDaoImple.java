package com.example.gradleTest2.DAO;
//20240213-3
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.gradleTest2.DTO.SimpleBbsDto;

@Mapper
public interface SimpleBbsDaoImple {
	
	public List<SimpleBbsDto> list();
	public int write (SimpleBbsDto simpleBbsDto);
	public SimpleBbsDto view(String id);
	public int update(SimpleBbsDto simpleBbsDto);
	public int delete(String id);

}
