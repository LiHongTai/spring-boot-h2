package com.roger.test;

import com.roger.constant.CisConstant;

public class Test {

	public static void main(String[] args) {
		StringBuilder methodName = new StringBuilder();
		String arg = "> = 30 ";
		if(arg.contains(CisConstant.LESS_THAN_SIGN)) {
			methodName.append(CisConstant.LESS_THAN);
			arg.replace(CisConstant.LESS_THAN_SIGN, CisConstant.EMPTY);
		}
		
		if(arg.contains(CisConstant.GREATER_THAN_SIGN)) {
			methodName.append(CisConstant.GREATER_THAN);
			arg = arg.replace(CisConstant.GREATER_THAN_SIGN, CisConstant.EMPTY);
		}
		
		if(arg.contains(CisConstant.EQUAL_SIGN)) {
			methodName.append(CisConstant.EQUAL);
			arg = arg.replace(CisConstant.EQUAL_SIGN, CisConstant.EMPTY);
		}
		System.out.println("methodName:"+methodName.toString() + ";arg:"+arg.trim());
	}

}
