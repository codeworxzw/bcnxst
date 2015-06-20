package com.bcnx.application.utility;

import java.util.Stack;

public class ApplicationStack {
	private static Stack<Object> stack;
	static{
		stack = new Stack<Object>();
	}
	public static Stack<Object> getStack(){
		return stack;
	}
}
