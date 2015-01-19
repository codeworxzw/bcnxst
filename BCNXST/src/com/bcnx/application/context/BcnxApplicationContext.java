package com.bcnx.application.context;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class BcnxApplicationContext {
	private static ApplicationContext context;
	static{
		context = new FileSystemXmlApplicationContext("connext/configuration.xml");
	}
	public static ApplicationContext getApplicationContext(){
		return context;
	}
}
