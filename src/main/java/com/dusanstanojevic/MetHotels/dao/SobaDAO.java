package com.dusanstanojevic.MetHotels.dao;

import java.util.List;

import com.dusanstanojevic.MetHotels.entities.Soba;

public interface SobaDAO {
	public List<Soba> all();
	public Soba getById(int id);
	public void update(Soba s);
	public void delete (Soba s);
	public Soba saveSoba(Soba k);
}
