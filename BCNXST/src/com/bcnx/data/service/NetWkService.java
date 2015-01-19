package com.bcnx.data.service;

import com.bcnx.data.entity.NetWk;

public interface NetWkService {
	public void save(NetWk netWk);
	public void update(NetWk netWk);
	public NetWk getNetWk(String mode);
	public int checkNetWk(int id);
}
