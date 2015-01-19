package com.bcnx.message.checker.request;

import org.apache.log4j.Logger;
import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;

import com.bcnx.application.utility.UtilPackage;
import com.bcnx.message.service.request.MessageDefinition;
import com.bcnx.message.service.response.WriteISOMessage;

public class NetMsgChecker extends MessageCheckerImp implements MessageChecker{
	private static final Logger logger = Logger.getLogger(NetMsgChecker.class);
	private static int[] fields = {7,11,37,70};
	private MessageChecker messageChecker;
	private WriteISOMessage writeISOMessage;
	public void setWriteISOMessage(WriteISOMessage writeISOMessage){
		this.writeISOMessage = writeISOMessage;
	}
	public void setMessageChecker(MessageChecker messageChecker){
		this.messageChecker = messageChecker;
	}
	@Override
	public byte[] checkMessage(ISOMsg isoMsg) throws ISOException {
		String mti = isoMsg.getMTI();
		boolean chk1 = mti.equals(MessageDefinition.NETMTIREQ);
		boolean chk2 = isoMsg.hasFields(fields);
		if(chk1&&chk2){
			logger.info("============= NetWork Message ==============");
			String de07 = isoMsg.getString(07);
			String de11 = isoMsg.getString(11);
			String de37 = isoMsg.getString(37);
			String de70 = isoMsg.getString(70);
			
			boolean chk = MessageDefinition.checkField07(de07);
			super.printChecker(chk, 7, de07);
			chk = MessageDefinition.checkField11(de11);
			super.printChecker(chk, 11, de11);
			chk = MessageDefinition.checkField37(de37);
			super.printChecker(chk, 37, de37);
			chk = MessageDefinition.checkField70(de70);
			super.printChecker(chk, 70, de70);
			
			UtilPackage.printLogger(isoMsg);
			return writeISOMessage.writeISOMessage(isoMsg);
		}
		return messageChecker.checkMessage(isoMsg);
	}
	
}
