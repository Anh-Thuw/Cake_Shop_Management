package SavePartyShopManager;


public class SavaDrinkMana {
String tenDrink , sizeDrink , thanhphanDrink ;
int giaDrink , id;
byte[] anhDrink ;
public SavaDrinkMana() {
	
}
public SavaDrinkMana(String tenDrink, String sizeDrink, String thanhphanDrink, int giaDrink, int id, byte[] anhDrink) {
	this.tenDrink = tenDrink;
	this.sizeDrink = sizeDrink;
	this.thanhphanDrink = thanhphanDrink;
	this.giaDrink = giaDrink;
	this.id = id;
	this.anhDrink = anhDrink;
}
public String getTenDrink() {
	return tenDrink;
}
public void setTenDrink(String tenDrink) {
	this.tenDrink = tenDrink;
}
public String getSizeDrink() {
	return sizeDrink;
}
public void setSizeDrink(String sizeDrink) {
	this.sizeDrink = sizeDrink;
}
public String getThanhphanDrink() {
	return thanhphanDrink;
}
public void setThanhphanDrink(String thanhphanDrink) {
	this.thanhphanDrink = thanhphanDrink;
}
public int getGiaDrink() {
	return giaDrink;
}
public void setGiaDrink(int giaDrink) {
	this.giaDrink = giaDrink;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public byte[] getAnhDrink() {
	return anhDrink;
}
public void setAnhDrink(byte[] anhDrink) {
	this.anhDrink = anhDrink;
}
}
