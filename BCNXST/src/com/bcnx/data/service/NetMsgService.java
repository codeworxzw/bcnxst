package com.bcnx.data.service;

import com.bcnx.data.entity.NetMsg;

public interface NetMsgService {
	public void save(NetMsg netMsg);
	public void update(NetMsg netMsg);
	public String getDe70();
	public int check();
}
