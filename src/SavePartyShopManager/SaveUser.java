package SavePartyShopManager;

public class SaveUser {
 String  Name , Sex , email , username  ;
 long cccd , phone ;
 int id ;
 public SaveUser() {
	 
 }
public SaveUser(String name, String sex, String email, String username, long cccd, long phone, int id) {
	super();
	Name = name;
	Sex = sex;
	this.email = email;
	this.username = username;
	this.cccd = cccd;
	this.phone = phone;
	this.id = id;
}
public String getName() {
	return Name;
}
public void setName(String name) {
	Name = name;
}
public String getSex() {
	return Sex;
}
public void setSex(String sex) {
	Sex = sex;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public long getCccd() {
	return cccd;
}
public void setCccd(long cccd) {
	this.cccd = cccd;
}
public long getPhone() {
	return phone;
}
public void setPhone(long phone) {
	this.phone = phone;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}

}