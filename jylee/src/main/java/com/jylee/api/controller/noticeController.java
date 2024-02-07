package com.jylee.api.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.jylee.api.service.noticeService;
import com.jylee.api.vo.noticeVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("notice")
public class noticeController {

	private noticeService noticeservice;

	public noticeController(noticeService noticeservice) {
		this.noticeservice = noticeservice;
	}

	@RequestMapping(value="/selectNoticeList")
	@ResponseBody
	public List<noticeVO> selectNoticeList(){
		log.debug("### Reqeust URL - /notice/selectNoticeList ###");

		List<noticeVO> noticeList = noticeservice.selectNoticeList();

		return noticeList;
	}

	@RequestMapping(value="/insertNotice", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Map<String,String> insertNotice(@RequestPart(value="ntc") noticeVO ntc,
			@RequestPart(value="files", required = false)MultipartFile[] files ) throws Exception{

		Map<String,String> resMap = new HashMap<>();

		noticeservice.insertNotice(ntc, files);

		resMap.put("MSG_CODE", "200");
		resMap.put("MSG", "등록 완료");

		return resMap;
	}
}
