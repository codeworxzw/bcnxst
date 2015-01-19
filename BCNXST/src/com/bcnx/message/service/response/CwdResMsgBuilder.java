package com.bcnx.message.service.response;

import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;
import org.springframework.context.ApplicationContext;

import com.bcnx.application.context.BcnxApplicationContext;
import com.bcnx.application.utility.UtilPackage;
import com.bcnx.data.entity.CardAcct;
import com.bcnx.data.service.CardAcctService;
import com.bcnx.message.service.request.MessageDefinition;

public class CwdResMsgBuilder implements WriteISOMessage {
	public void setField39(String field39){	}
	@Override
	public byte[] writeISOMessage(ISOMsg isoMsg) throws ISOException {
			String field02 = isoMsg.getString(2);
			String field03 = isoMsg.getString(3);
			String field04 = isoMsg.getString(4);
			String field07 = isoMsg.getString(7);
			String field11 = isoMsg.getString(11);
			String field12 = isoMsg.getString(12);
			String field13 = isoMsg.getString(13);
			String field15 = isoMsg.getString(15);
			String field18 = isoMsg.getString(18);
			String field19 = isoMsg.getString(19);
			String field28 = isoMsg.getString(28);
			String field32 = isoMsg.getString(32);
			String field35 = isoMsg.getString(35);
			String field37 = isoMsg.getString(37);
			String field38 = MessageDefinition.buildField11();
			String field41 = isoMsg.getString(41);
			String field49 = isoMsg.getString(49);
			
			ISOMsg resISOMsg = new ISOMsg();
			resISOMsg.setPackager(MessageDefinition.getGenericPackager());
			resISOMsg.setMTI(MessageDefinition.FINMTIRES);
			resISOMsg.set(2, field02);
			resISOMsg.set(3, field03);
			resISOMsg.set(4, field04);
			resISOMsg.set(7, field07);
			resISOMsg.set(11, field11);
			resISOMsg.set(12, field12);
			resISOMsg.set(13, field13);
			resISOMsg.set(15, field15);
			resISOMsg.set(18, field18);
			resISOMsg.set(19, field19);
			resISOMsg.set(32, field32);
			resISOMsg.set(35, field35);
			resISOMsg.set(37, field37);
			resISOMsg.set(38, field38);
			resISOMsg.set(41, field41);
			resISOMsg.set(49, field49);
			double amt = Double.parseDouble(field04)/100;
			double fee = Double.parseDouble(field28.substring(1, 8));
			DebitCardAccount debitCardAccount = new DebitCardAccount(field02,amt,fee);
			// deduct card account
			String field39 = debitCardAccount.process();
			String field54 = null;
			if (field39.equals("00")) {
				field54 = MessageDefinition.buildField54(field03, field02);
				resISOMsg.set(54, field54);
			}
			resISOMsg.set(39, field39);
			return UtilPackage.addHeader(resISOMsg.pack());
	}
	private class DebitCardAccount{
		private String card;
		private double amount;
		private double fee;
		public DebitCardAccount(String card, double amount, double fee){
			this.card = card;
			this.amount = amount;
			this.fee = fee;
		}
		public String process(){
			ApplicationContext context = BcnxApplicationContext.getApplicationContext();
			CardAcctService service = (CardAcctService) context.getBean("cardAcctService");
			CardAcct cardAcct = new CardAcct();
			cardAcct.setCard(card);
			CardAcct cardAccount = service.getCardAcct(cardAcct);
			if(cardAccount.getBal()<amount+fee+50000)
				return "51";
			double amt = cardAccount.getBal() - (amount+fee);
			cardAccount.setBal(amt);
			service.update(cardAccount);
			return "00";
		}
	}
}
