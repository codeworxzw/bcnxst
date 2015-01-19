package com.bcnx.message.checker.request;

import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;

public interface RoutingValidation {
	public boolean checkMemberInfo(ISOMsg isoMsg) throws ISOException;
}
