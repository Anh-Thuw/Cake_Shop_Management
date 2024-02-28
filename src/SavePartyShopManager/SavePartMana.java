package SavePartyShopManager;

public class SavePartMana {
int giaPart , IdPart ;
String tenPart ;
public SavePartMana() {
	
}
public SavePartMana(int giaPart, int idPart, String tenPart) {
	super();
	this.giaPart = giaPart;
	IdPart = idPart;
	this.tenPart = tenPart;
}
public int getGiaPart() {
	return giaPart;
}
public void setGiaPart(int giaPart) {
	this.giaPart = giaPart;
}
public int getIdPart() {
	return IdPart;
}
public void setIdPart(int idPart) {
	IdPart = idPart;
}
public String getTenPart() {
	return tenPart;
}
public void setTenPart(String tenPart) {
	this.tenPart = tenPart;
}


}
