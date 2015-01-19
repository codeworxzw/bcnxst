package com.bcnx.message.checker.response;

import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;

public interface ResMsgChecker {
	public void setResMsgChecker(ResMsgChecker responseMessageChecker);
	public boolean checker(ISOMsg isoMsg, ISOMsg isoOrg) throws ISOException;
}
