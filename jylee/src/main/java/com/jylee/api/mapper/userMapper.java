package com.jylee.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jylee.api.vo.userVO;

@Mapper
public interface userMapper {

	userVO selectUser(@Param(value="userId")String userId);

	List<userVO> selectUserList();
}
