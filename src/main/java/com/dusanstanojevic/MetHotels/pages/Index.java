package com.dusanstanojevic.MetHotels.pages;

import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;

import com.dusanstanojevic.MetHotels.entities.Soba;

import java.util.ArrayList;
import java.util.List;

/**
 * Start page of application MetHotels.
 */
public class Index {
  @Persist
  @Property
  private List<Soba> sobe;
  
  @Inject
  private Session session;
  
  @Property
  private Soba soba;
  
  @Property
  private Soba s;
  
  @CommitAfter
  void onActivate() {
	  sobe = session.createCriteria(Soba.class).list();
  }
  
  @CommitAfter
  Object onSuccess() {
	  session.persist(soba);
	  return this;
  }
}
