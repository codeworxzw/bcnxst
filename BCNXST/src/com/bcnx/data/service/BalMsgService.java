package com.bcnx.data.service;

import com.bcnx.data.entity.BalMsg;

public interface BalMsgService {
	public void update(BalMsg balMsg);
	public String getDe02();
	public String getDe03();
	public String getDe04();
	public String getDe18();
	public String getDe22();
	public String getDe25();
	public String getDe28();
	public String getDe32();
	public String getDe41();
	public String getDe42();
	public String getDe43();
	public String getDe49();
	public String getDe52();
	public String getDe19();
	public int checkRecord();
	public void save(BalMsg balMsg);
}
