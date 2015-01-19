package com.bcnx.application.utility;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.log4j.Logger;
import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;

import com.bcnx.data.entity.Bin;
import com.bcnx.data.entity.CardAcct;
import com.bcnx.data.entity.Member;

public class UtilPackage {
	private static final Logger logger = Logger.getLogger(UtilPackage.class);
	private static final char[] HEX_CHARS = "0123456789ABCDEF".toCharArray();
	// extract message from bytes data
	public static byte[] extractMessage(byte[] msg) {
		byte[] header = {msg[0],msg[1],msg[2],msg[3]};
		int len = Integer.parseInt(new String(header));
		byte[] data = new byte[len];
		for(int i=4;i<msg.length;i++){
			data[i-4] = msg[i];
		}
		return data;
	}
	// add header to message data
	public static byte[] addHeader(byte[] data){
		int len = data.length;
		String strLen = String.format("%04d", len);
		byte[] header = strLen.getBytes();
		return mergeBytes(header,data);
	}
	// Bytes array merge
	public static byte[] mergeBytes(byte[] a, byte[] b){
		
		int aLen = a.length;
		int bLen = b.length;
		
		int len = aLen+bLen;
		
		byte[] data = new byte[len];
		for(int i=0;i<aLen;i++){
			data[i]=a[i];
		}
		for(int j=0;j<bLen;j++){
			data[j+aLen]=b[j];
		}
		
		return data;
	}
	// hex to string, string to hex
	
    public static String stringToHex(String input) throws UnsupportedEncodingException
    {
        if (input == null) throw new NullPointerException();
        return asHex(input.getBytes());
    }
 
    public static String hexToString(String txtInHex)
    {
        byte [] txtInByte = new byte [txtInHex.length() / 2];
        int j = 0;
        for (int i = 0; i < txtInHex.length(); i += 2)
        {
                txtInByte[j++] = Byte.parseByte(txtInHex.substring(i, i + 2), 16);
        }
        return new String(txtInByte);
    }
 
    public static String asHex(byte[] buf)
    {
        char[] chars = new char[2 * buf.length];
        for (int i = 0; i < buf.length; ++i)
        {
            chars[2 * i] = HEX_CHARS[(buf[i] & 0xF0) >>> 4];
            chars[2 * i + 1] = HEX_CHARS[buf[i] & 0x0F];
        }
        return new String(chars);
    }
	// print log file
    public static String printLoggerString(ISOMsg isoMsg) throws ISOException{
    	String line1 = "\r\n---------- ISO Message Detail ----------\r\n";
		String line2 = "+--------+----------+---------------------------------------------+";
		String line3 = "|   DE   |   Len    |                     Value                   |";
		String line4 = "[      1]"+"  [     4]"+"    ["+String.format("%s", isoMsg.getMTI())+"]";
		for(int i=1;i<=isoMsg.getMaxField();i++){
			if(isoMsg.hasField(i)){
				String field = isoMsg.getString(i);
				String num = String.format("%7d", i);
				String length = String.format("%5d", field.length());
				String value = String.format("%s", field);
				line4 = line4+"\r\n["+ num + "]  [ "+length +"]    [" + value +"]";
			}
		}
		String line5 = "\r\n-------------------------------------------------------------------\r\n";
		return line1+"\r\n"+line2+"\r\n"+line3+"\r\n"+line2+"\r\n"+line4+"\r\n"+line5+"\r\n";
    }
	public static void printLogger(ISOMsg isoMsg) throws ISOException{
		logger.info("\r\n---------- ISO Message Detail ----------\r\n");
		logger.info("+--------+----------+---------------------------------------------+");
		logger.info("|   DE   |   Len    |                     Value                   |");
		logger.info("+--------+----------+---------------------------------------------+");
		logger.info("[      1]"+"  [     4]"+"    ["+String.format("%s", isoMsg.getMTI())+"]");
		for(int i=1;i<=isoMsg.getMaxField();i++){
			if(isoMsg.hasField(i)){
				String field = isoMsg.getString(i);
				String num = String.format("%7d", i);
				String length = String.format("%5d", field.length());
				String value = String.format("%s", field);
				logger.info("["+ num + "]  [ "+length +"]    [" + value +"]");
			}
		}
		logger.info("\r\n-------------------------------------------------------------------\r\n");
	}
	public static String printRequestString(byte[] data){
		String line = "\r\n>>>>>>>>>>> REQUEST <<<<<<<<<<<<\r\n";
		char[] biteArray = new String(data).replace("\n", ".").toCharArray();
		String print = "";
		for(int i=0;i<biteArray.length;i++){
			print = print + String.format("%c", biteArray[i]);
			int count = i+1;
			if(count%16==0)
				print = print+"\r\n";
		}
		return line+"\r\n"+print;
	}
	public static void printRequest(byte[] data){
		logger.info("\r\n ============== Transaction Start ==============\r\n");
		logger.info("\r\n>>>>>>>>>>> REQUEST <<<<<<<<<<<<\r\n");
		char[] biteArray = new String(data).replace("\n", ".").toCharArray();
		String print = "";
		for(int i=0;i<biteArray.length;i++){
			print = print + String.format("%c", biteArray[i]);
			int count = i+1;
			if(count%16==0)
				print = print+"\r\n";
		}
		logger.info(print);
	}
	public static String printRaw(byte[] data){
		char[] biteArray = new String(data).replace("\n", ".").toCharArray();
		String print = "";
		for(int i=0;i<biteArray.length;i++){
			print = print + String.format("%c", biteArray[i]);
			int count = i+1;
			if(count%16==0)
				print = print+"\r\n";
		}
		return print;
	}
	public static String printResponseString(byte[] data){
		String line1 = "\r\n>>>>>>>>>>> RESPONSE <<<<<<<<<<<<\r\n";
		char[] biteArray = new String(data).replace("\n", ".").toCharArray();
		String print = "";
		for(int i=0;i<biteArray.length;i++){
			print = print + String.format("%c", biteArray[i]);
			int count = i+1;
			if(count%16==0)
				print = print+"\r\n";
		}
		return line1+"\r\n"+print;
	}
	public static void printResponse(byte[] data){
		logger.info("\r\n>>>>>>>>>>> RESPONSE <<<<<<<<<<<<\r\n");
		char[] biteArray = new String(data).replace("\n", ".").toCharArray();
		String print = "";
		for(int i=0;i<biteArray.length;i++){
			print = print + String.format("%c", biteArray[i]);
			int count = i+1;
			if(count%16==0)
				print = print+"\r\n";
		}
		logger.info(print);
	}
	public static String printDumpString(byte[] raw) {
		String print = "\r\n============ HEX DUMP ===============\r\n";
		char[] dump = UtilPackage.asHex(raw).toCharArray();
		for(int i=0;i<dump.length;i++){
			int count = i + 1;
			if(count%2==0)
				print = print+String.format("%c ",dump[i]);
			else
				print = print+String.format("%c",dump[i]);
			
			if(count % 32 == 0)
				print = print+"\r\n";
		}
		return print;
	}
	public static void printDump(byte[] raw){
		logger.info("\r\n============ HEX DUMP ===============\r\n");
		String print = "";
		char[] dump = UtilPackage.asHex(raw).toCharArray();
		for(int i=0;i<dump.length;i++){
			int count = i + 1;
			if(count%2==0)
				print = print+String.format("%c ",dump[i]);
			else
				print = print+String.format("%c",dump[i]);
			
			if(count % 32 == 0)
				print = print+"\r\n";
		}
		logger.info(print);
	}
	public static void printElement(boolean check, int de, String field){
		String out = "";
		if(!check)
			out = String.format("DE - %02d : [%-42s] ===> INVALID", de,field);
		else
			out = String.format("DE - %02d : [%-42s] ===> O.K",de,field);
		logger.info(out);
	}
	public static void printStatus(boolean check){
		if(check)
			logger.info("\r\nResult : SUCCESS.");
		else
			logger.info("\r\nResult : FAILED.");
		logger.info("\r\n========== Transaction End ===========");
	}
	/**
	 * 
	 * @param members
	 * @return
	 */
	
	public static Object[][] membersToArray(List<Member> members) {
		int size = 6;
		int len = members.size();
		Object[][] objs = new Object[len][size];
		for(int i=0;i<len;i++){
			objs[i][0] = new Boolean(false);
			objs[i][1] = members.get(i).getId();
			objs[i][2] = members.get(i).getIin();
			objs[i][3] = members.get(i).getMemId();
			objs[i][4] = members.get(i).getName();
			objs[i][5] = members.get(i).getLocation();
		}
		return objs;
	}
	public static Object[][] binsToArray(List<Bin> bins) {
		int size = 5;
		int len = bins.size();
		Object[][] objs = new Object[len][size];
		for(int i=0;i<len;i++){
			objs[i][0] = new Boolean(false);
			objs[i][1] = bins.get(i).getId();
			objs[i][2] = bins.get(i).getBin();
			objs[i][3] = bins.get(i).getType();
			objs[i][4] = bins.get(i).getIin();
		}
		return objs;
	}
	public static Object[][] cardAccountToArray(List<CardAcct> cardAcct) {
		//{ "ID","CARD", "TYPE", "CURR","FLAG","BALANCE","EXPDATE","CAV","BIN" };
		int size = 10;
		int len = cardAcct.size();
		Object[][] objs = new Object[len][size];
		for(int i=0;i<len;i++){
			objs[i][0] = new Boolean(false);
			objs[i][1] = cardAcct.get(i).getId();
			objs[i][2] = cardAcct.get(i).getCard();
			objs[i][3] = cardAcct.get(i).getType();
			objs[i][4] = cardAcct.get(i).getCurr();
			objs[i][5] = cardAcct.get(i).getFlag();
			objs[i][6] = cardAcct.get(i).getBal();
			objs[i][7] = cardAcct.get(i).getExp();
			objs[i][8] = cardAcct.get(i).getCav();
			objs[i][9] = cardAcct.get(i).getBin();
		}
		return objs;
	}
	
	public static boolean checkDateTime(String dateTime){
		String dtPattern = "MMddHHmmss";
		SimpleDateFormat formatter = new SimpleDateFormat(dtPattern);
		
		try {
			formatter.parse(dateTime);
			return true;
		} catch (ParseException e) {
			logger.info("Exception occured whil try to check validity of date time",e);
			return false;
		}
	}
	
	public static boolean checkDate(String date){
		String dPattern = "MMdd";
		SimpleDateFormat formatter = new SimpleDateFormat(dPattern);
		try {
			formatter.parse(date);
			return true;
		} catch (ParseException e) {
			logger.info("Exception occured whil try to check validity of date time",e);
			return false;
		}
	}
	
	public static boolean checkTime(String time){
		String tPattern = "HHmmss";
		SimpleDateFormat formatter = new SimpleDateFormat(tPattern);
		try {
			formatter.parse(time);
			return true;
		} catch (ParseException e) {
			logger.info("Exception occured whil try to check validity of date time",e);
			return false;
		}
	}
}
