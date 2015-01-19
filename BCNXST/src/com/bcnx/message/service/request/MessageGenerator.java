package com.bcnx.message.service.request;

import org.jpos.iso.ISOException;

public interface MessageGenerator {
	public byte[] messageBuilder() throws ISOException;
}
