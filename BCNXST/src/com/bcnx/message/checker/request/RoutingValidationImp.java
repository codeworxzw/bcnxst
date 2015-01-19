package com.bcnx.message.checker.request;

import org.apache.log4j.Logger;
import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcnx.data.entity.Bin;
import com.bcnx.data.entity.Member;
import com.bcnx.data.service.BinService;
import com.bcnx.data.service.MemberService;
import com.bcnx.message.service.request.MessageDefinition;
@Service("routingInfoValidation")
public class RoutingValidationImp implements RoutingValidation {
	private static final Logger logger = Logger.getLogger(RoutingValidationImp.class);
	@Autowired
	private MemberService memberService;
	@Autowired
	private BinService binService;
	public void setMemberService(MemberService memberService){
		this.memberService = memberService;
	}
	public void setBinService(BinService binService){
		this.binService = binService;
	}
	@Override
	public boolean checkMemberInfo(ISOMsg isoMsg) throws ISOException {
		logger.info("\r\n>>>>>>>>>> VERIFICATION DETAIL <<<<<<<<<<\r\n");
		if(MessageDefinition.NETMTIREQ.equals(isoMsg.getMTI()))
			return true;
		// check BIN number for Issuer confirmation
		String bin = isoMsg.getString(2).substring(0, 6);
		Bin b = binService.getBin(bin);
		Member issuer = memberService.getMemberFromIIN(b.getIin());
		if(issuer==null){
			logger.info("EORROR : INVALID ISSUER CARD BIN");
			return false;
		}
		logger.info(String.format("ISSUER IIN [%6s], ISSUER VERIFICATION ==> O.K",issuer.getIin()));
		// check ACQUIRER information
		String acqId = isoMsg.getString(32);
		Member acquirer = memberService.getMemberFromIIN(acqId);
		if(acquirer==null){
			logger.info("EORROR : INVALID ACQUIRER ID");
			return false;
		}
		logger.info(String.format("ACQUIRER IIN [%6s], ACQUIRER VERIFICATION ==> O.K",acquirer.getIin()));
		
		if(issuer.getIin().equals(acquirer.getIin())){
			logger.info("ERROR : Invalid routing infomation, bin and acquirer id is the same");
			return false;
		}
		return true;
	}

}
