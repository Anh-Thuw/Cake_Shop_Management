package SavePartyShopManager;

public class SaveTasteMana {
int giaTaste , idTaste;
String tenTaste ;
public SaveTasteMana() {
	
}
public SaveTasteMana(int giaTaste, int idTaste, String tenTaste) {
	super();
	this.giaTaste = giaTaste;
	this.idTaste = idTaste;
	this.tenTaste = tenTaste;
}
public int getGiaTaste() {
	return giaTaste;
}
public void setGiaTaste(int giaTaste) {
	this.giaTaste = giaTaste;
}
public int getIdTaste() {
	return idTaste;
}
public void setIdTaste(int idTaste) {
	this.idTaste = idTaste;
}
public String getTenTaste() {
	return tenTaste;
}
public void setTenTaste(String tenTaste) {
	this.tenTaste = tenTaste;
}

}
