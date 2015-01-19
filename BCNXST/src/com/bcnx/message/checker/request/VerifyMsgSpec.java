package com.bcnx.message.checker.request;

import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;

public interface VerifyMsgSpec {
	public byte[] checkMsg(ISOMsg isoMsg) throws ISOException;
}
