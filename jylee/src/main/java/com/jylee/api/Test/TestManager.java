package com.jylee.api.Test;

public class TestManager {

	public static TestInterface getClass(String type) {

		if("Test".equals(type)) {
			return new Test();
		}else {
			return new Test2();
		}
	}
}
