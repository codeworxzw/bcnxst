package com.bcnx.message.service.response;

import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;

import com.bcnx.application.utility.UtilPackage;
import com.bcnx.message.service.request.MessageDefinition;

public class RevResMsgBuilder implements WriteISOMessage {
	private String field39 = "00";
	private WriteISOMessage writeISOMessage;
	@Override
	public byte[] writeISOMessage(ISOMsg isoMsg) throws ISOException {
		String mti = isoMsg.getMTI();
		if (mti.equals(MessageDefinition.REVMTIREQ)) {
			String field02 = isoMsg.getString(2);
			String field03 = isoMsg.getString(3);
			String field04 = isoMsg.getString(4);
			String field07 = isoMsg.getString(7);
			String field11 = isoMsg.getString(11);
			String field19 = isoMsg.getString(19);
			String field32 = isoMsg.getString(32);
			String field35 = isoMsg.getString(35);
			String field37 = isoMsg.getString(37);
			String field41 = isoMsg.getString(41);
			String field43 = isoMsg.getString(43);
			String field49 = isoMsg.getString(49);
			String field90 = isoMsg.getString(90);
			// message type
			ISOMsg resISOMsg = new ISOMsg();
			resISOMsg.setPackager(MessageDefinition.getGenericPackager());
			resISOMsg.setMTI(MessageDefinition.REVMTIRES);
			resISOMsg.set(2, field02);
			resISOMsg.set(3, field03);
			resISOMsg.set(4, field04);
			resISOMsg.set(7, field07);
			resISOMsg.set(11, field11);
			resISOMsg.set(19, field19);
			resISOMsg.set(32, field32);
			resISOMsg.set(35, field35);
			resISOMsg.set(37, field37);
			resISOMsg.set(39, field39);
			resISOMsg.set(41, field41);
			resISOMsg.set(43, field43);
			resISOMsg.set(49, field49);
			resISOMsg.set(90, field90);
			byte[] msgData = resISOMsg.pack();
			return UtilPackage.addHeader(msgData);
		} else
			return writeISOMessage.writeISOMessage(isoMsg);
	}

	@Override
	public void setField39(String field39) {
		this.field39 = field39;
	}
	public void setWriteISOMessage(WriteISOMessage writeISOMessage){
		this.writeISOMessage = writeISOMessage;
	}

}
