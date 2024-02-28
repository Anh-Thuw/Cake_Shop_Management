package SavePartyShopManager;

public class SaveLogin {
String userName , password , position ;
public SaveLogin() {
	
}
public SaveLogin(String userName, String password, String position) {
	
	this.userName = userName;
	this.password = password;
	this.position = position;
}

public String getUserName() {
	return userName;
}

public void setUserName(String userName) {
	this.userName = userName;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getPosition() {
	return position;
}

public void setPosition(String position) {
	this.position = position;
}

}
