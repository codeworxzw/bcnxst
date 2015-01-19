package com.bcnx.message.checker.request;

import org.apache.log4j.Logger;
import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;

public class MessageCheckerImp {
	private static final Logger logger = Logger.getLogger(MessageCheckerImp.class);
	public boolean checkMsgType(ISOMsg isoMsg, String msgTypeInd, int[] fields, String type) throws ISOException{
		String mti = isoMsg.getMTI();
		String proCode = isoMsg.getString(3).substring(0, 2);
		boolean chkMti = mti.equals(msgTypeInd);
		boolean chkProCode = proCode.equals(type);
		boolean chkFields = isoMsg.hasFields(fields);
		return chkMti&&chkProCode&&chkFields;
	}
	public void printChecker(boolean chk, int i, String field){
		if(!chk){
			logger.info(String.format("Message Data Element [ %-2d] Value [%-42s] ==> ERROR",i,field));
		}
		else 
			logger.info(String.format("Message Data Element [ %-2d] Value [%-42s] ==> O.K",i,field));
	}
}
