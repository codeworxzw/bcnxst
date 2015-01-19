package com.bcnx.message.service.request;

import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;

import com.bcnx.application.utility.UtilPackage;
import com.bcnx.data.service.NetMsgService;

public class NetMsgGenImp implements MessageGenerator {
	private NetMsgService netMsgService;
	public void setNetMsgService(NetMsgService netMsgService){
		this.netMsgService = netMsgService;
	}
	@Override
	public byte[] messageBuilder() throws ISOException {
		String mti  = MessageDefinition.NETMTIREQ;
		String de07 = MessageDefinition.buildField07();
		String de11 = MessageDefinition.buildField11();
		String de37 = MessageDefinition.buildField37(de11);
		String de70 = netMsgService.getDe70();
		ISOMsg isoMsg = new ISOMsg();
		isoMsg.setPackager(MessageDefinition.getGenericPackager());
		isoMsg.setMTI(mti);
		isoMsg.set(7, de07);
		isoMsg.set(11,de11);
		isoMsg.set(37,de37);
		isoMsg.set(70,de70);
		return UtilPackage.addHeader(isoMsg.pack());
	}

}
