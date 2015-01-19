package com.bcnx.data.service;

import java.util.List;

import com.bcnx.data.entity.Bin;

public interface BinService {
	public void save(Bin bin);
	public Bin getBin(String bin);
	public Bin getBin(int bin);
	public void update(Bin bin);
	public List<Bin> getBin();
	public String[] getBinList();
	public List<Bin> getBinLike(String trim);
	public void delete(Bin b);
}
