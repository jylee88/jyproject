package com.jylee.api.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jylee.api.Test.TestInterface;
import com.jylee.api.Test.TestManager;
import com.jylee.api.service.userService;
import com.jylee.api.vo.userVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/user")
public class userController {

	private userService userservice;

	public userController(userService userservice) {
		this.userservice = userservice;
	}

	@RequestMapping(value="/test")
	public String test() {
		TestInterface t = TestManager.getClass("Test");

		return t.test();
	}

	/*
	 * 사용자 단건 조회
	 *
	 * @author leejaeyong
	 * @Param : 사용자ID
	 * @return : 사용자 정보
	 */
	@RequestMapping(value="/selectUser")
	public userVO selectUser(String userId) throws IOException{
		log.debug("##### Request userId ==> {} ####", userId);

		userVO user = userservice.selectUser(userId);

		if(null == user) {
			throw new IOException("존재하지 않는 사용자 입니다.");
		}

		return user;
	}

	/*
	 * 사용자 목록 조회
	 *
	 * @author leejaeyong
	 * @Param :
	 * @return : 사용자 정보 리스트
	 */
	@RequestMapping(value="/selectUserList", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<userVO> selectUserList() throws Exception{
		log.debug("##### Request userList ####");

		long startTime = System.currentTimeMillis();

		List<userVO> userList = userservice.selectUserList();

		Map<String,String> map = userList.stream()
				.filter(user -> "2".equals(user.getUserAuth()))
				.collect(Collectors.toMap(m1->m1.getUserId(), m2->m2.getUserAuth(),(oldVal, newVal)-> oldVal));
				//.collect(Collectors.toMap(userVO::getUserId, userVO::getUserAuth));

		List<userVO> list = userList.stream()
				.filter(user -> "2".equals(user.getUserAuth()))
				.collect(Collectors.toList());

		long endTime = System.currentTimeMillis();

		log.debug("### 시작시간 => {} \n 종료시간 => {} \n 소요시간 => {} ms",startTime, endTime, endTime - startTime);

		return userList;
	}

}
