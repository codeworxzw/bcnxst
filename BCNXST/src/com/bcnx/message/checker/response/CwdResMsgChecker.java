package com.bcnx.message.checker.response;

import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;
import org.springframework.stereotype.Service;

import com.bcnx.application.utility.UtilPackage;
import com.bcnx.message.service.request.MessageDefinition;
@Service("cashWithdrawalResChecker")
public class CwdResMsgChecker implements ResMsgChecker {
	private static final int[] fields = {2,3,4,7,11,12,13,15,18,19,32,35,37,38,39,41,49,54};
	private ResMsgChecker resMsgChecker;
	@Override
	public void setResMsgChecker(
			ResMsgChecker resMsgChecker) {
		this.resMsgChecker = resMsgChecker;
	}

	@Override
	public boolean checker(ISOMsg isoMsg, ISOMsg isoOrg) throws ISOException {
		String procCode = isoMsg.getString(3).substring(0, 2);
		if(isoMsg.hasFields(fields)&&procCode.equals("01")){
			boolean check = true;
			boolean chk02 = isoMsg.getString(2).equals(isoOrg.getString(2))
					&& MessageDefinition.checkField02(isoMsg.getString(2));
			
			boolean chk03 = isoMsg.getString(3).equals(isoOrg.getString(3))
					&& MessageDefinition.checkField03(isoMsg.getString(3));
			
			boolean chk04 = isoMsg.getString(4).equals(isoOrg.getString(4))
					&& MessageDefinition.checkField04(isoMsg.getString(4));
			
			boolean chk07 = isoMsg.getString(7).equals(isoOrg.getString(7))
					&& MessageDefinition.checkField07(isoMsg.getString(7));
			
			boolean chk11 = isoMsg.getString(11).equals(isoOrg.getString(11))
					&& MessageDefinition.checkField11(isoMsg.getString(11));
			
			boolean chk12 = isoMsg.getString(12).equals(isoOrg.getString(12))
					&& MessageDefinition.checkField12(isoMsg.getString(12));
			
			boolean chk13 = isoMsg.getString(13).equals(isoOrg.getString(13))
					&& MessageDefinition.checkField13(isoMsg.getString(13));
			
			boolean chk15 = isoMsg.getString(15).equals(isoOrg.getString(15))
					&& MessageDefinition.checkField15(isoMsg.getString(15));
			
			boolean chk18 = isoMsg.getString(18).equals(isoOrg.getString(18))
					&& MessageDefinition.checkField18(isoMsg.getString(18));
			
			boolean chk19 = isoMsg.getString(19).equals(isoOrg.getString(19))
					&& MessageDefinition.checkField19(isoMsg.getString(19));
			
			boolean chk32 = isoMsg.getString(32).equals(isoOrg.getString(32))
					&& MessageDefinition.checkField32(isoMsg.getString(32));
			
			boolean chk35 = isoMsg.getString(35).equals(isoOrg.getString(35))
					&& MessageDefinition.checkField35(isoMsg.getString(35));
			
			boolean chk37 = isoMsg.getString(37).equals(isoOrg.getString(37))
					&& MessageDefinition.checkField37(isoMsg.getString(37));
			
			boolean chk38 = MessageDefinition.checkField38(isoMsg.getString(38));
			
			boolean chk39 = MessageDefinition.checkField39(isoMsg.getString(39));
			
			boolean chk41 = isoMsg.getString(41).equals(isoOrg.getString(41))
					&& MessageDefinition.checkField41(isoMsg.getString(41));
			
			boolean chk54 = MessageDefinition.checkField54(isoMsg.getString(54));

			check = chk02 && chk03 && chk04 && chk07 && chk11 && chk12 && chk13
					&& chk15 && chk18 && chk19 && chk32 && chk35 && chk37
					&& chk38 && chk39 && chk41 && chk54;

			UtilPackage.printElement(chk02, 2, isoMsg.getString(2));
			UtilPackage.printElement(chk03, 3, isoMsg.getString(3));
			UtilPackage.printElement(chk04, 4, isoMsg.getString(4)); 
			UtilPackage.printElement(chk07, 7, isoMsg.getString(7));
			UtilPackage.printElement(chk11, 11, isoMsg.getString(11));
			UtilPackage.printElement(chk12, 12, isoMsg.getString(12));
			UtilPackage.printElement(chk13, 13, isoMsg.getString(13));
			UtilPackage.printElement(chk15, 15, isoMsg.getString(15));
			UtilPackage.printElement(chk18, 18, isoMsg.getString(18));
			UtilPackage.printElement(chk19, 19, isoMsg.getString(19));
			UtilPackage.printElement(chk32, 32, isoMsg.getString(32));
			UtilPackage.printElement(chk35, 35, isoMsg.getString(35));
			UtilPackage.printElement(chk37, 37, isoMsg.getString(37));
			UtilPackage.printElement(chk38, 38, isoMsg.getString(38));
			UtilPackage.printElement(chk39, 39, isoMsg.getString(39));
			UtilPackage.printElement(chk41, 41, isoMsg.getString(41));
			UtilPackage.printElement(chk54, 54, isoMsg.getString(54));
			
			return check;
		} else
			return resMsgChecker.checker(isoMsg,isoOrg);
	}
}
