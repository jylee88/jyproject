package com.jylee.api.service;

import org.springframework.stereotype.Service;

import com.jylee.api.mapper.userMapper;
import com.jylee.api.vo.userVO;

@Service("userService")
public class userService {

	private userMapper usermapper;

	public userService(userMapper usermapper) {
		this.usermapper = usermapper;
	}

	public userVO selectUser(String userId) {
		return usermapper.selectUser(userId);
	}
}
