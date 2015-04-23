package com.dusanstanojevic.MetHotels.dao.impl;

import java.util.List;

import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.dusanstanojevic.MetHotels.dao.SobaDAO;
import com.dusanstanojevic.MetHotels.entities.Soba;

public class SobaDAOimpl implements SobaDAO {
	@Inject
	private Session session;
	
	@CommitAfter
	@Override
	public List<Soba> all() {
		return session.createCriteria(Soba.class).list();
	}

	@CommitAfter
	@Override
	public Soba getById(int id) {
		return (Soba)session.createCriteria(Soba.class).add(Restrictions.eq("id", id)).uniqueResult();
	}

	@CommitAfter
	@Override
	public Soba saveSoba(Soba k) {
		session.save(k);
		return k;
	}
	
	@CommitAfter
	@Override
	public void update(Soba s) {
		session.update(s);
	}

	@CommitAfter
	@Override
	public void delete(Soba s) {
		session.delete(s);
	}
}
