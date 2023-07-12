package model;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class Application {
	private List<NormalUser> registeredUsers;
	private List<AdminUser> registeredAdmins;
	private List<PublicDestination> publicDestinationList;
	private List<PrivateDestination> privateDestinationList;
	private NormalUser loggedUser;
	
	public NormalUser getLoggedUser() {
		return loggedUser;
	}

	public Application() {
		registeredUsers = new ArrayList<NormalUser>();
		registeredAdmins = new ArrayList<AdminUser>();
		publicDestinationList = new ArrayList<PublicDestination>();
		privateDestinationList = new ArrayList<PrivateDestination>();
		initialize();
	}
	
	public void initialize() {
		loadRegisteredUsers(getUsers(),getAdmins());
		loadDestinations(getPublicDestinations(), getPrivateDestinations());
	}
	
	private void loadDestinations(List<PublicDestination> publicDestinationList, List <PrivateDestination> privateDestinationList) {
		try {
			FileUtil.loadDestinationsFile(this, publicDestinationList, privateDestinationList);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	public void saveNewPublicDestination(PublicDestination publicDestination) {
		FileUtil.saveToFilePublic(publicDestination);
	}
	
	public void saveNewPrivateDestination(PrivateDestination privateDestination) {
		FileUtil.saveToFilePrivate(privateDestination);
	}
	
	private void loadRegisteredUsers(List<NormalUser> userlist,List<AdminUser> adminlist) {
		FileUtil.loadUsersFile(userlist,adminlist);
	}
	
	public int checkLoggedUser(String user,char[] password) {
		for(NormalUser u: registeredUsers) {
			if(u.getUsername().equals(user) && u.getPassword().equals(new String(password))) {
				loggedUser=u;
				return 0;
			}
		}
		for(AdminUser u: registeredAdmins) {
			if(u.getUsername().equals(user) && u.getPassword().equals(new String(password))) {
				return 1;
			}
		}
		return -1;
	}
	
	public List<NormalUser> getUsers(){
		return registeredUsers;
	}
	
	public List<AdminUser> getAdmins(){
		return registeredAdmins;
	}
	
	public List<PublicDestination> getPublicDestinations() {
		return publicDestinationList;
	}
	
	public List<PrivateDestination> getPrivateDestinations() {
		return privateDestinationList;
	}

}
