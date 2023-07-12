package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PrivateDestination extends Destination {
	
	private User user;

	public PrivateDestination(String geolocation, String title, String image, String description, Date initialDate, Date endDate, User user) {
		super(geolocation, title, image, description, initialDate, endDate);
		this.user = user;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	@Override
	public String toString() {
		return getTitle();
	}
	
	public String toStringToFile() {
		SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd-MM-yyyy");
		SimpleDateFormat dateFormat2 = new SimpleDateFormat("dd-MM-yyyy");
		String initialDate = dateFormat1.format(getInitialDate());
		String endDate = dateFormat2.format(getEndDate());
		return getGeolocation() + "#" + getTitle() + "#" + getImage() + "#" + getDescription() + "#" + initialDate + "#" + endDate + "#private" + "#" + user.getUsername();
	}

}
