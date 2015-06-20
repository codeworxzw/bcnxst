package com.bcnx.message.service.request;

import java.util.EmptyStackException;
import java.util.Stack;

import org.apache.log4j.Logger;
import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;

import com.bcnx.application.utility.ApplicationStack;
import com.bcnx.application.utility.UtilPackage;
import com.bcnx.data.service.RevMsgService;

public class RevMsgGenImp implements MessageGenerator {
	private static final Logger logger = Logger.getLogger(RevMsgGenImp.class);
	private RevMsgService revMsgService;
	public void setRevMsgService(RevMsgService revMsgService){
		this.revMsgService = revMsgService;
	}
	@Override
	public byte[] messageBuilder() throws ISOException {
		Stack<Object> stack = ApplicationStack.getStack();
		if(stack.isEmpty()){
			logger.info("Error : Stack is empty.!");
			throw new EmptyStackException();
		}
		ISOMsg orgMsg = (ISOMsg) stack.pop();
		String mti = MessageDefinition.REVMTIREQ;
		String de02 = orgMsg.getString(2);
		String de03 = orgMsg.getString(3);
		String de04 = orgMsg.getString(4);
		String de07 = orgMsg.getString(7);
		String de11 = orgMsg.getString(11);
		String de12 = orgMsg.getString(12);
		String de13 = orgMsg.getString(13);
		String de14 = orgMsg.getString(14);
		String de15 = orgMsg.getString(15);
		String de18 = orgMsg.getString(18);
		String de19 = orgMsg.getString(19);
		String de22 = orgMsg.getString(22);
		String de25 = orgMsg.getString(25);
		String de28 = orgMsg.getString(28).replaceAll("D", "C");
		String de32 = orgMsg.getString(32);
		String de35 = orgMsg.getString(35);
		String de37 = orgMsg.getString(37);
		String de39 = revMsgService.getDe39();
		String de41 = orgMsg.getString(41);
		String de42 = orgMsg.getString(42);
		String de43 = orgMsg.getString(43);
		String de49 = orgMsg.getString(49);
		String de90 = MessageDefinition.buildField90(mti, de07, de11, de32);
		
		ISOMsg isoMsg = new ISOMsg();
		isoMsg.setPackager(MessageDefinition.getGenericPackager());
		isoMsg.setMTI(mti);
		isoMsg.set( 2, de02);
		isoMsg.set( 3, de03);
		isoMsg.set( 4, de04);
		isoMsg.set( 7, de07);
		isoMsg.set(11, de11);
		isoMsg.set(12, de12);
		isoMsg.set(13, de13);
		isoMsg.set(14, de14);
		isoMsg.set(15, de15);
		isoMsg.set(18, de18);
		isoMsg.set(19, de19);
		isoMsg.set(22, de22);
		isoMsg.set(25, de25);
		isoMsg.set(28, de28);
		isoMsg.set(32, de32);
		isoMsg.set(35, de35);
		isoMsg.set(37, de37);
		isoMsg.set(39, de39);
		isoMsg.set(41, de41);
		isoMsg.set(42, de42);
		isoMsg.set(43, de43);
		isoMsg.set(49, de49);
		isoMsg.set(90, de90);
		return UtilPackage.addHeader(isoMsg.pack());
	}
}
