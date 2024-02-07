package com.jylee.api.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.jylee.api.vo.fileVO;

@Mapper
public interface fileMapper {

	void insertFile(fileVO file);
}
