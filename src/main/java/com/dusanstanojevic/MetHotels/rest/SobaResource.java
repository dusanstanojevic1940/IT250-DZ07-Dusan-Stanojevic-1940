package com.dusanstanojevic.MetHotels.rest;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;

import com.dusanstanojevic.MetHotels.entities.Soba;

import java.util.List;


@Path("/soba")
public class SobaResource {
	@Inject
	private Session session;
	
	@GET
	@Produces("application/json")
	public List<Soba> getAllDomains()
	{
		return session.createCriteria(Soba.class).list();
	}
}
