package com.demo.api.postcode.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PostCodeRecord {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	long id;
	private String postCode;
	private String suburb;
	private String state;
	private String longitude;
	private String latitude;

	public PostCodeRecord() {
		super();
	}
	public PostCodeRecord(String postCode,String suburb,String state, String longitude, String latitude) {
		super();
		this.postCode = postCode;
		this.suburb = suburb;
		this.state = state;
		this.longitude = longitude;
		this.latitude = latitude;
	}
    public String getPostCode() {
		return postCode;
	}


	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}


	public String getSuburb() {
		return suburb;
	}


	public void setSuburb(String suburb) {
		this.suburb = suburb;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

}
