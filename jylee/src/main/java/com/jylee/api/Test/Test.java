package com.jylee.api.Test;

public class Test implements TestInterface{

	@Override
	public String test() {
		return new String("@@@@ Test Class @@@@@");
	}

	public String getStr() {
		return new String("## Test class method - getStr ##");
	}
}
