package com.bcnx.message.checker.request;

import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;

import com.bcnx.message.service.response.WriteISOMessage;

public class VerifyMsgSpecImp implements VerifyMsgSpec {
	private MessageChecker messageChecker;
	private RoutingValidation routingInfoValidation;
	private WriteISOMessage writeISOMessage;
	public void setMessageChecker(MessageChecker messageChecker){
		this.messageChecker = messageChecker;
	}
	public void setRoutingInfoValidation(RoutingValidation routingInfoValidation){
		this.routingInfoValidation = routingInfoValidation;
	}
	public void setWriteISOMessage(WriteISOMessage writeISOMessage) {
		this.writeISOMessage = writeISOMessage;
	}
	@Override
	public byte[] checkMsg(ISOMsg isoMsg) throws ISOException {
		if(!routingInfoValidation.checkMemberInfo(isoMsg)){
			writeISOMessage.setField39("58");
			return writeISOMessage.writeISOMessage(isoMsg);
		}
		writeISOMessage.setField39("00");
		return messageChecker.checkMessage(isoMsg);
	}

}
