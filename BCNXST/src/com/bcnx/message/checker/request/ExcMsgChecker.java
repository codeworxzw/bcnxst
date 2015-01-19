package com.bcnx.message.checker.request;

import org.apache.log4j.Logger;
import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;

import com.bcnx.message.service.response.WriteISOMessage;

public class ExcMsgChecker extends MessageCheckerImp implements MessageChecker {
	private static final Logger logger = Logger.getLogger(ExcMsgChecker.class);
	private WriteISOMessage writeISOMessage;
	@Override
	public void setWriteISOMessage(WriteISOMessage writeISOMessage) {
		this.writeISOMessage = writeISOMessage;
	}

	@Override
	public byte[] checkMessage(ISOMsg isoMsg) throws ISOException {
		logger.debug("======== Mismatch Exception Message ========");
		return writeISOMessage.writeISOMessage(isoMsg);
	}

}
