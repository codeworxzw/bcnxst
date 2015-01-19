package com.bcnx.message.acquirer.sender;

import java.io.IOException;
import java.net.UnknownHostException;

import com.bcnx.message.checker.response.ResMsgChecker;

public interface MessageClient {
	public byte[] runEchoClient(byte[] input) throws UnknownHostException, IOException;
	public void setResMsgChecker(ResMsgChecker resMsgChecker);
}
