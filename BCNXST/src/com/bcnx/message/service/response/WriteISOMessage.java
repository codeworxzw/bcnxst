package com.bcnx.message.service.response;

import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;

public interface WriteISOMessage {
	public void setField39(String field39);
	public byte[] writeISOMessage(ISOMsg iSOMsg) throws ISOException;
}
