package model;

import java.util.Date;

public class Destination {
	
	private String geolocation;
	private String title;
	private String image;
	private String description;
	private Date initialDate; // si se complica, se cambia a String
	private Date endDate;
	
	public Destination(String geolocation, String title, String image, String description, Date initialDate, Date endDate) {
		this.geolocation = geolocation;
		this.title = title;
		this.image = image;
		this.description = description;
		this.initialDate = initialDate;
		this.endDate = endDate;
	}


	public String getGeolocation() {
		return geolocation;
	}


	public void setGeolocation(String geolocation) {
		this.geolocation = geolocation;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Date getInitialDate() {
		return initialDate;
	}


	public void setInitialDate(Date initialDate) {
		this.initialDate = initialDate;
	}


	public Date getEndDate() {
		return endDate;
	}


	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

}
