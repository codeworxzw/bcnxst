package com.bcnx.message.service.request;

import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;

import com.bcnx.application.utility.UtilPackage;
import com.bcnx.data.service.BalMsgService;

public class BalMsgGenImp implements MessageGenerator {
	private BalMsgService balMsgService;
	public void setBalMsgService(BalMsgService balMsgService){
		this.balMsgService = balMsgService;
	}
	@Override
	public byte[] messageBuilder() throws ISOException {
		String mti = MessageDefinition.FINMTIREQ;
		String de02 = balMsgService.getDe02();
		String de03 = balMsgService.getDe03();
		String de04 = balMsgService.getDe04();
		String de07 = MessageDefinition.buildField07();
		String de11 = MessageDefinition.buildField11();
		String de12 = MessageDefinition.buildField12();
		String de13 = MessageDefinition.buildField13();
		String de14 = MessageDefinition.buildField14(de02);
		String de15 = MessageDefinition.buildField15();
		String de18 = balMsgService.getDe18();
		String de19 = balMsgService.getDe19();
		String de22 = balMsgService.getDe22();
		String de25 = balMsgService.getDe25();
		String de28 = balMsgService.getDe28();
		String de32 = balMsgService.getDe32();
		String de35 = MessageDefinition.buildField35(de02);
		String de37 = MessageDefinition.buildField37(de11);
		String de41 = balMsgService.getDe41();
		String de42 = balMsgService.getDe42();
		String de43 = balMsgService.getDe43();
		String de49 = balMsgService.getDe49();
		String de52 = balMsgService.getDe52();
		
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
		isoMsg.set(41, de41);
		isoMsg.set(42, de42);
		isoMsg.set(43, de43);
		isoMsg.set(49, de49);
		isoMsg.set(52, de52);
		return UtilPackage.addHeader(isoMsg.pack());
	}

}
