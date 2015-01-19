package com.bcnx.message.checker.request;

import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;

import com.bcnx.message.service.response.WriteISOMessage;

public interface MessageChecker {
	public void setWriteISOMessage(WriteISOMessage writeISOMessage);
	public byte[] checkMessage(ISOMsg isoMsg) throws ISOException;
}
