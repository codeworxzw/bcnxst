package com.bcnx.message.service.request;

import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;

import com.bcnx.application.utility.UtilPackage;
import com.bcnx.data.service.RevMsgService;

public class RevMsgGenImp implements MessageGenerator {
	private RevMsgService revMsgService;
	public void setRevMsgService(RevMsgService revMsgService){
		this.revMsgService = revMsgService;
	}
	@Override
	public byte[] messageBuilder() throws ISOException {
		String mti = MessageDefinition.REVMTIREQ;
		String de02 = revMsgService.getDe02();
		String de03 = revMsgService.getDe03();
		String de04 = revMsgService.getDe04();
		String de07 = MessageDefinition.buildField07();
		String de11 = MessageDefinition.buildField11();
		String de12 = MessageDefinition.buildField12();
		String de13 = MessageDefinition.buildField13();
		String de14 = MessageDefinition.buildField14(de02);
		String de15 = MessageDefinition.buildField15();
		String de18 = revMsgService.getDe18();
		String de19 = revMsgService.getDe19();
		String de22 = revMsgService.getDe22();
		String de25 = revMsgService.getDe25();
		String de28 = revMsgService.getDe28();
		String de32 = revMsgService.getDe32();
		String de35 = MessageDefinition.buildField35(de02);
		String de37 = MessageDefinition.buildField37(de11);
		String de39 = revMsgService.getDe39();
		String de41 = revMsgService.getDe41();
		String de42 = revMsgService.getDe42();
		String de43 = revMsgService.getDe43();
		String de49 = revMsgService.getDe49();
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
