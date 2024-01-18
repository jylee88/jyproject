package com.jylee.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

	@RequestMapping(value="/selectUser")
	public userVO selectUser(String userId) {
		log.debug("##### Request userId ==> {} ####", userId);

		userVO user = userservice.selectUser(userId);
		return user;
	}

}
