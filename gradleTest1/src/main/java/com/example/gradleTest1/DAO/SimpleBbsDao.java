package com.example.gradleTest1.DAO;
//20240207-4
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.gradleTest1.DTO.SimpleBbsDto;


@Repository
public class SimpleBbsDao implements SimpleBbsDaoImple{

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	
	@Override
	public List<SimpleBbsDto> listDao() {
		String sql="select * from simple_bbs order by id desc";
		List<SimpleBbsDto> list = jdbcTemplate.query(sql,
				new BeanPropertyRowMapper<SimpleBbsDto>(SimpleBbsDto.class));
		return list;
	}

	@Override
	public SimpleBbsDto viewDao(String id) {
		String sql="select * from simple_bbs where id='"+id+"'";
		SimpleBbsDto dto = jdbcTemplate.queryForObject(
				sql, new BeanPropertyRowMapper<SimpleBbsDto>(SimpleBbsDto.class));
		return dto;
	}

	@Override
	public int writeDao(SimpleBbsDto simpleBbsDto) {
		String sql="insert into simple_bbs(writer,title,content)"
				+" values(?,?,?)";
		jdbcTemplate.update(sql, simpleBbsDto.getWriter(),
				simpleBbsDto.getTitle(),simpleBbsDto.getContent());
		return 0;
	}

	@Override
	public int deleteDao(String id) {
		String sql="delete from simple_bbs where id='"+id+"'";
		jdbcTemplate.update(sql);
		return 0;
	}

}