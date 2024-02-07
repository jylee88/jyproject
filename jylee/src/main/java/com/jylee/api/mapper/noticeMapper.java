package com.jylee.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.jylee.api.vo.noticeVO;

@Mapper
public interface noticeMapper {

	String selectNoticeId();

	List<noticeVO> selectNoticeList();

	void insertNotice(noticeVO ntc);
}
