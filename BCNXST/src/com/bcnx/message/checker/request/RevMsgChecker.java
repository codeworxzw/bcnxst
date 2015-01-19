package com.bcnx.message.checker.request;

import org.apache.log4j.Logger;
import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;

import com.bcnx.application.utility.UtilPackage;
import com.bcnx.message.service.request.MessageDefinition;
import com.bcnx.message.service.response.WriteISOMessage;

public class RevMsgChecker extends MessageCheckerImp implements MessageChecker{
	private static final Logger logger = Logger.getLogger(RevMsgChecker.class);
	private static final int[] fields = {2,3,4,7,11,12,13,14,15,18,19,22,25,28,32,35,37,39,41,42,43,49,90};
	private static final String TYPE="01";
	private MessageChecker messageChecker;
	private WriteISOMessage writeISOMessage;
	public void setMessageChecker(MessageChecker messageChecker){
		this.messageChecker = messageChecker;
	}
	@Override
	public void setWriteISOMessage(WriteISOMessage writeISOMessage) {
		this.writeISOMessage = writeISOMessage;
	}
	@Override
	public byte[] checkMessage(ISOMsg isoMsg) throws ISOException {
		boolean chk = super.checkMsgType(isoMsg, MessageDefinition.REVMTIREQ, fields, TYPE);
		if(chk){
			logger.debug("========== Cash Withdrawal Reversal Message ==========");
			String de02 = isoMsg.getString(02);
			String de03 = isoMsg.getString(03);
			String de04 = isoMsg.getString(04);
			String de07 = isoMsg.getString(07);
			String de11 = isoMsg.getString(11);
			String de12 = isoMsg.getString(12);
			String de13 = isoMsg.getString(13);
			String de14 = isoMsg.getString(14);
			String de15 = isoMsg.getString(15);
			String de18 = isoMsg.getString(18);
			String de19 = isoMsg.getString(19);
			String de22 = isoMsg.getString(22);
			String de25 = isoMsg.getString(25);
			String de28 = isoMsg.getString(28);
			String de32 = isoMsg.getString(32);
			String de35 = isoMsg.getString(35);
			String de37 = isoMsg.getString(37);
			String de41 = isoMsg.getString(41);
			String de42 = isoMsg.getString(42);
			String de43 = isoMsg.getString(43);
			String de49 = isoMsg.getString(49);
			String de90 = isoMsg.getString(90);
			chk = MessageDefinition.checkField02(de02);
			printChecker(chk, 2, de02);
			chk = MessageDefinition.checkField03(de03);
			printChecker(chk, 3, de03);
			chk = MessageDefinition.checkField04(de04);
			printChecker(chk, 4, de04);
			chk = MessageDefinition.checkField07(de07);
			printChecker(chk, 7, de07);
			chk = MessageDefinition.checkField11(de11);
			printChecker(chk, 11, de11);
			chk = MessageDefinition.checkField12(de12);
			printChecker(chk, 12, de12);
			chk = MessageDefinition.checkField13(de13);
			printChecker(chk, 13, de13);
			chk = MessageDefinition.checkField14(de14);
			printChecker(chk, 14, de14);
			chk = MessageDefinition.checkField15(de15);
			printChecker(chk, 15, de15);
			chk = MessageDefinition.checkField18(de18);
			printChecker(chk, 18, de18);
			chk = MessageDefinition.checkField19(de19);
			printChecker(chk, 19, de19);
			chk = MessageDefinition.checkField22(de22);
			printChecker(chk, 22, de22);
			chk = MessageDefinition.checkField25(de25);
			printChecker(chk, 25, de25);
			chk = MessageDefinition.checkField28(de28);
			printChecker(chk, 28, de28);
			chk = MessageDefinition.checkField32(de32);
			printChecker(chk, 32, de32);
			chk = MessageDefinition.checkField35(de35);
			printChecker(chk, 35, de35);
			chk = MessageDefinition.checkField37(de37);
			printChecker(chk, 37, de37);
			chk = MessageDefinition.checkField41(de41);
			printChecker(chk, 41, de41);
			chk = MessageDefinition.checkField42(de42);
			printChecker(chk, 42, de42);
			chk = MessageDefinition.checkField43(de43);
			printChecker(chk, 43, de43);
			chk = MessageDefinition.checkField49(de49);
			printChecker(chk, 49, de49);
			chk = MessageDefinition.checkField90(de90);
			printChecker(chk, 90, de90);
			UtilPackage.printLogger(isoMsg);
			return writeISOMessage.writeISOMessage(isoMsg);
		}
		return messageChecker.checkMessage(isoMsg);
	}
	
}
