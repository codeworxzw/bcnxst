package com.bcnx.application.utility;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ApplicationQueue {
	private static final int size = 500;
	private static BlockingQueue<byte[]> queue = new ArrayBlockingQueue<byte[]>(size);
	public static BlockingQueue<byte[]> getQueue(){
		return queue;
	}
}
