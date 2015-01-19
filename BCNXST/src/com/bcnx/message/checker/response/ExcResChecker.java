package com.bcnx.message.checker.response;

import org.apache.log4j.Logger;
import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;

import com.bcnx.application.utility.UtilPackage;

public class ExcResChecker implements ResMsgChecker {
	private static final Logger logger = Logger.getLogger(ExcResChecker.class);
	@Override
	public void setResMsgChecker(
			ResMsgChecker responseMessageChecker) {
	}
	@Override
	public boolean checker(ISOMsg isoMsg, ISOMsg isoOrg) throws ISOException {
		logger.info("\r\n============== INVALID RESPONSE ===============\r\n");
		UtilPackage.printLogger(isoMsg);
		return false;
	}

}
