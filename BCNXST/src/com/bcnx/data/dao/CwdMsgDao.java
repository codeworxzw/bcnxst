package com.bcnx.data.dao;

import java.sql.SQLException;

import com.bcnx.data.entity.CwdMsg;

public interface CwdMsgDao {
	public void update(CwdMsg cwdMsg) throws SQLException;
	public String getDe02() throws SQLException;
	public String getDe03() throws SQLException;
	public String getDe04() throws SQLException;
	public String getDe18() throws SQLException;
	public String getDe19() throws SQLException;
	public String getDe22() throws SQLException;
	public String getDe25() throws SQLException;
	public String getDe28() throws SQLException;
	public String getDe32() throws SQLException;
	public String getDe41() throws SQLException;
	public String getDe42() throws SQLException;
	public String getDe43() throws SQLException;
	public String getDe49() throws SQLException;
	public String getDe52() throws SQLException;
	public void save(CwdMsg cwdMsg) throws SQLException;
	public int check() throws SQLException;
	
}
