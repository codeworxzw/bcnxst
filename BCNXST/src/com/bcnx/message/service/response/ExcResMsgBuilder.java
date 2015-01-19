package com.bcnx.message.service.response;

import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;

import com.bcnx.application.utility.UtilPackage;
import com.bcnx.message.service.request.MessageDefinition;

public class ExcResMsgBuilder implements WriteISOMessage {
	private String field39;
	@Override
	public byte[] writeISOMessage(ISOMsg iSOMsg) throws ISOException {
		String orgMti = iSOMsg.getMTI().substring(0,2);
		String mti = orgMti+"10";
		setField39("72");
		iSOMsg.setPackager(MessageDefinition.getGenericPackager());
		iSOMsg.setMTI(mti);
		iSOMsg.set(39, field39);
		return UtilPackage.addHeader(iSOMsg.pack());
	}
	@Override
	public void setField39(String field39) {
		this.field39 = field39;
	}
}
