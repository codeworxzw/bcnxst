package com.bcnx.message.checker.response;

import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;
import org.springframework.stereotype.Service;

import com.bcnx.application.utility.UtilPackage;
import com.bcnx.message.service.request.MessageDefinition;
@Service("reversalResponseChecker")
public class RevResChecker implements ResMsgChecker {
	private static final int[] fields = {2,3,4,7,11,19,32,35,37,39,41,43,49,90};
	private ResMsgChecker responseMessageChecker;
	@Override
	public void setResMsgChecker(
			ResMsgChecker responseMessageChecker) {
		this.responseMessageChecker = responseMessageChecker;
	}
	@Override
	public boolean checker(ISOMsg isoMsg, ISOMsg isoOrg) throws ISOException {
		String procCode = isoMsg.getString(3).substring(0, 2);
		if(isoMsg.hasFields(fields)&&procCode.equals("01")){
			boolean check = true;
			boolean chk2 = isoMsg.getString(2).equals(isoOrg.getString(2))
					&& MessageDefinition.checkField02(isoMsg.getString(2));
			boolean chk3 = isoMsg.getString(3).equals(isoOrg.getString(3))
					&& MessageDefinition.checkField03(isoMsg.getString(3));
			boolean chk4 = isoMsg.getString(4).equals(isoOrg.getString(4))
					&& MessageDefinition.checkField04(isoMsg.getString(4));
			boolean chk7 = isoMsg.getString(7).equals(isoOrg.getString(7))
					&& MessageDefinition.checkField07(isoMsg.getString(7));
			boolean chk11 = isoMsg.getString(11).equals(isoOrg.getString(11))
					&& MessageDefinition.checkField11(isoMsg.getString(11));
			boolean chk19 = isoMsg.getString(19).equals(isoOrg.getString(19))
					&& MessageDefinition.checkField19(isoMsg.getString(19));
			boolean chk32 = isoMsg.getString(32).equals(isoOrg.getString(32))
					&& MessageDefinition.checkField32(isoMsg.getString(32));
			boolean chk35 = isoMsg.getString(35).equals(isoOrg.getString(35))
					&& MessageDefinition.checkField35(isoMsg.getString(35));
			boolean chk37 = isoMsg.getString(37).equals(isoOrg.getString(37))
					&& MessageDefinition.checkField37(isoMsg.getString(37));
			boolean chk39 = MessageDefinition
					.checkField39(isoMsg.getString(39));
			boolean chk41 = isoMsg.getString(41).equals(isoOrg.getString(41))
					&& MessageDefinition.checkField41(isoMsg.getString(41));
			boolean chk43 = isoMsg.getString(43).equals(isoOrg.getString(43))
					&& MessageDefinition.checkField43(isoMsg.getString(43));
			boolean chk49 = isoMsg.getString(49).equals(isoOrg.getString(49))
					&& MessageDefinition.checkField49(isoMsg.getString(49));
			boolean chk90 = isoMsg.getString(90).equals(isoOrg.getString(90))
					&& MessageDefinition.checkField90(isoMsg.getString(90));
			UtilPackage.printElement(chk2, 2, isoMsg.getString(2));
			UtilPackage.printElement(chk3, 3, isoMsg.getString(3));
			UtilPackage.printElement(chk4, 4, isoMsg.getString(4));
			UtilPackage.printElement(chk7, 7, isoMsg.getString(7));
			UtilPackage.printElement(chk11, 11, isoMsg.getString(11));
			UtilPackage.printElement(chk19, 19, isoMsg.getString(19));
			UtilPackage.printElement(chk32, 32, isoMsg.getString(32));
			UtilPackage.printElement(chk35, 35, isoMsg.getString(35));
			UtilPackage.printElement(chk37, 37, isoMsg.getString(37));
			UtilPackage.printElement(chk39, 39, isoMsg.getString(39));
			UtilPackage.printElement(chk41, 41, isoMsg.getString(41));
			UtilPackage.printElement(chk43, 43, isoMsg.getString(43));
			UtilPackage.printElement(chk49, 49, isoMsg.getString(49));
			UtilPackage.printElement(chk90, 90, isoMsg.getString(90));
			check = chk2 && chk3 && chk4 && chk7 && chk11 && chk19 && chk32
					&& chk35 && chk37 && chk39 && chk41 && chk43 && chk49
					&& chk90;
			return check;
		}
		else
			return responseMessageChecker.checker(isoMsg,isoOrg);
	}
}
