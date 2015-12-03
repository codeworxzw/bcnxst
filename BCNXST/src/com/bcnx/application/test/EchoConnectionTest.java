package com.bcnx.application.test;

import org.junit.Test;

public class EchoConnectionTest {
	private static final String IP="172.20.0.11";
	private static final int PORT = 6021;
	
	@Test
	public void test() throws InterruptedException {
		
		Thread t = new Thread(new SenderThread(IP,PORT),"SENDER THREAD");
		t.start();
		t.join();
		
	}

}
