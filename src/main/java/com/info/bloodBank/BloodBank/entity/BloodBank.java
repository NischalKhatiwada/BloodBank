package com.info.bloodBank.BloodBank.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class BloodBank implements Serializable{
	
	@Id
	@GeneratedValue	(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	private String address;
	private String CertNumber;	//Official governmental certification number i.e. PAN or similar
	private int contact;
	private double gpsLat;	//In decimal value
	private double gpsLong;  //In decimal value
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCertNumber() {
		return CertNumber;
	}
	public void setCertNumber(String certNumber) {
		CertNumber = certNumber;
	}
	public int getContact() {
		return contact;
	}
	public void setContact(int contact) {
		this.contact = contact;
	}
	public double getGpsLat() {
		return gpsLat;
	}
	public void setGpsLat(double gpsLat) {
		this.gpsLat = gpsLat;
	}
	public double getGpsLong() {
		return gpsLong;
	}
	public void setGpsLong(double gpsLong) {
		this.gpsLong = gpsLong;
	}	
	
	

}
