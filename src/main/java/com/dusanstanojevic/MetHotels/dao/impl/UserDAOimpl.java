package com.dusanstanojevic.MetHotels.dao.impl;

import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;

import com.dusanstanojevic.MetHotels.dao.UserDAO;
import com.dusanstanojevic.MetHotels.entities.Korisnik;

public class UserDAOimpl implements UserDAO {
	@Inject
	private Session session;

	@CommitAfter
	@Override
	public Korisnik saveUser(Korisnik k) {
		session.save(k);
		return k;
	}

	
}
