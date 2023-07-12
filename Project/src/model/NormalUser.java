package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NormalUser extends User {
	
	private List <Destination> bucketList;

	public NormalUser(String username, String email, String password) {
		super(username, email, password);
		this.bucketList= new ArrayList<Destination>();
	}
	
	public void createDestination(String geolocation, String title, String image, String description, Date initialDate, Date endDate) {
		PrivateDestination des = new PrivateDestination(geolocation, title, image, description, initialDate, endDate, this);
		addDestination(des);
	}

	
	public void addDestination(Destination des) {
		if(des instanceof PrivateDestination)
			bucketList.add(des);
		else {
			PrivateDestination desP = new PrivateDestination(des.getGeolocation(), des.getTitle(), des.getImage(), des.getDescription(), des.getInitialDate(), des.getEndDate(), this);
			bucketList.add(desP);
		}
	}
	
	public void deleteDestination(Destination des) {
		bucketList.remove(des);
	}

}