package com.dusanstanojevic.MetHotels.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.tapestry5.beaneditor.NonVisual;
import org.apache.tapestry5.beaneditor.Validate;

@Entity
@Table(name="soba")
@XmlRootElement(name = "soba")
public class Soba {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NonVisual
	public int id;
	
	@OneToMany(fetch = FetchType.LAZY)
	public List<Korisnik> users;
	
	@Validate("minlength=5")
	public String ime;
	
	public int sprat;
	
	public boolean tv;
	
	public boolean internet;
	
	public boolean djakuzi;
}
