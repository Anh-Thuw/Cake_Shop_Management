package SavePartyShopManager;

import java.sql.Date;

public class SaveEmployee {
String Name, date , Sex , Shifts , Note ;
long cccd , phone , salary ;
int id ; ;//dd//mm//yyyyphon
public SaveEmployee() {
	
}

public SaveEmployee(String name, String date, String sex, String shifts, String note, long cccd, long phone,
		long salary, int id) {
	super();
	Name = name;
	this.date = date;
	Sex = sex;
	Shifts = shifts;
	Note = note;
	this.cccd = cccd;
	this.phone = phone;
	this.salary = salary;
	this.id = id;
}

public String getName() {
	return Name;
}

public void setName(String name) {
	Name = name;
}

public String getDate() {
	return date;
}

public void setDate(String date) {
	this.date = date;
}

public String getSex() {
	return Sex;
}

public void setSex(String sex) {
	Sex = sex;
}

public String getShifts() {
	return Shifts;
}

public void setShifts(String shifts) {
	Shifts = shifts;
}

public String getNote() {
	return Note;
}

public void setNote(String note) {
	Note = note;
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

public long getSalary() {
	return salary;
}

public void setSalary(long salary) {
	this.salary = salary;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}


}
