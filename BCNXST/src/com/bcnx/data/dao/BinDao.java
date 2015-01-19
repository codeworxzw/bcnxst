package com.bcnx.data.dao;

import java.sql.SQLException;
import java.util.List;

import com.bcnx.data.entity.Bin;

public interface BinDao {
	public void save(Bin bin) throws SQLException;
	public void update(Bin bin) throws SQLException;
	public Bin getBin() throws SQLException;
	public Bin getBin(Bin bin) throws SQLException;
	public List<Bin> getBins() throws SQLException;
	public Bin getBin(String bin) throws SQLException;
	public String[] getBinList() throws SQLException;
	public List<Bin> getBinLike(String trim) throws SQLException;
	public void delete(Bin b) throws SQLException;
}
