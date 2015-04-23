/**
 * 
 */
package com.dusanstanojevic.MetHotels.pages;

import java.util.List;

import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.apache.tapestry5.ioc.annotations.Inject;

import com.dusanstanojevic.MetHotels.dao.SobaDAO;
import com.dusanstanojevic.MetHotels.dao.UserDAO;
import com.dusanstanojevic.MetHotels.entities.Korisnik;
import com.dusanstanojevic.MetHotels.entities.Soba;

/**
 * @author dusanstanojevic
 *
 */
public class User {
	 @Persist
	 @Property
	 private List<Korisnik> users;
	 
	 @Property
	 private Soba soba;
  
	 @Property
	 private Korisnik user;
	 
	 @Inject
	 private UserDAO userDAO;
  
	 @Property
	 private Integer id;
	 
	 @Inject
	 private SobaDAO sobaDAO;
	 
	 public void setId(int id) {
		 this.id = id;
	 }
	 
	 Long onPassivate() {
		 if (id!=null)
			 return (Long)((long)id);
		 return null;
	 }
	 
	 Object onActivate(Long id) {
		 if (id!=null && id>0) {
			 this.id = (int)((long)id);
			 soba = sobaDAO.getById(this.id);
			 users = soba.users;
			 return null;
		 } else {
			 return Index.class;
		 }
	 }
  
	 @CommitAfter
	 Object onSuccess() {
		 userDAO.saveUser(user);
		 soba.users.add(user);
		 sobaDAO.saveSoba(soba);
		 return this;
	 }
}