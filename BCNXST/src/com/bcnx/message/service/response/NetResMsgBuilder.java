package com.bcnx.message.service.response;

import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;

import com.bcnx.application.utility.UtilPackage;
import com.bcnx.message.service.request.MessageDefinition;

public class NetResMsgBuilder implements WriteISOMessage {
	private WriteISOMessage writeISOMessage;
	private String field39 = "00";
	@Override
	public byte[] writeISOMessage(ISOMsg isoMsg) throws ISOException {
		String mti = isoMsg.getMTI();
		if (mti.equals(MessageDefinition.NETMTIREQ)) {
			String field07 = isoMsg.getString(7);
			String field11 = isoMsg.getString(11);
			String field37 = isoMsg.getString(37);
			String field70 = isoMsg.getString(70);
			// Build response code
			ISOMsg resISOMsg = new ISOMsg();
			resISOMsg.setPackager(MessageDefinition.getGenericPackager());
			// set message field
			resISOMsg.setMTI(MessageDefinition.NETMTIRES);
			resISOMsg.set(7, field07);
			resISOMsg.set(11, field11);
			resISOMsg.set(37, field37);
			resISOMsg.set(39, field39);
			resISOMsg.set(70, field70);
			return UtilPackage.addHeader(resISOMsg.pack());
		} else{
			writeISOMessage.setField39(field39);
			return writeISOMessage.writeISOMessage(isoMsg);
		}
	}
	@Override
	public void setField39(String field39) {
		this.field39 = field39;
	}
	public void setWriteISOMessage(WriteISOMessage writeISOMessage){
		this.writeISOMessage = writeISOMessage;
	}

}
