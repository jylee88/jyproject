package com.jylee.api.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jylee.api.vo.userVO;

@Mapper
public interface userMapper {

	userVO selectUser(@Param(value="userId")String userId);
}
