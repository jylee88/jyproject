package com.jylee.api.Test;

public class Test2 implements TestInterface{

	@Override
	public String test() {
		return new String("@@@@@ Test2 Class @@@@@");
	}

	public String getStr() {
		return new String("## Test2 class method - getStr ##");
	}
}
