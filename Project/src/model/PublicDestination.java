package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PublicDestination extends Destination {

	public PublicDestination(String geolocation, String title, String image, String description, Date initialDate, Date endDate) {
		super(geolocation, title, image, description, initialDate, endDate);
	}

	public String toStringToFile() {
		SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd-MM-yyyy");
		SimpleDateFormat dateFormat2 = new SimpleDateFormat("dd-MM-yyyy");
		String initialDate = dateFormat1.format(getInitialDate());
		String endDate = dateFormat2.format(getEndDate());
		return getGeolocation() + "#" + getTitle() + "#" + getImage() + "#" + getDescription() + "#" + initialDate + "#" + endDate + "#public";
	}

	
	@Override
	public String toString() {
		return getTitle();
	}

}
