package com.bcnx.message.checker.response;

import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;

import com.bcnx.application.utility.UtilPackage;
import com.bcnx.message.service.request.MessageDefinition;

public class NetResMsgChecker implements ResMsgChecker {
	private static final int[] fields = {7,11,37,39,70};
	private ResMsgChecker responseMessageChecker;
	
	@Override
	public void setResMsgChecker(
			ResMsgChecker responseMessageChecker) {
		this.responseMessageChecker = responseMessageChecker;
	}

	@Override
	public boolean checker(ISOMsg isoMsg, ISOMsg orgMsg) throws ISOException {
		if (isoMsg.hasFields(fields)) {
			boolean check = true;
			boolean chk7 = isoMsg.getString(7).equals(orgMsg.getString(7))
					&& MessageDefinition.checkField07(isoMsg.getString(7));
			boolean chk11 = isoMsg.getString(11).equals(orgMsg.getString(11))
					&& MessageDefinition.checkField11(isoMsg.getString(11));
			boolean chk37 = isoMsg.getString(37).equals(orgMsg.getString(37))
					&& MessageDefinition.checkField37(isoMsg.getString(37));
			boolean chk39 = MessageDefinition
					.checkField39(isoMsg.getString(39));
			boolean chk70 = MessageDefinition.checkField70(isoMsg
					.getString(70));
			UtilPackage.printElement(chk7, 7, isoMsg.getString(7));
			UtilPackage.printElement(chk11, 11, isoMsg.getString(11));
			UtilPackage.printElement(chk37, 37, isoMsg.getString(37));
			UtilPackage.printElement(chk39, 39, isoMsg.getString(39));
			UtilPackage.printElement(chk70, 70, isoMsg.getString(70));
			check = chk7 && chk11 && chk37 && chk39 && chk70;
			return check;
		} else
			return responseMessageChecker.checker(isoMsg,orgMsg);
	}
}
