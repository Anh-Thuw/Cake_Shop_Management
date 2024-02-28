package SavePartyShopManager;

public class SaveTierMana {
int giaTier , idTier ;
String tenTierMana ;
public SaveTierMana() {
	
}
public SaveTierMana(int giaTier, int idTier, String tenTierMana) {
	super();
	this.giaTier = giaTier;
	this.idTier = idTier;
	this.tenTierMana = tenTierMana;
}
public int getGiaTier() {
	return giaTier;
}
public void setGiaTier(int giaTier) {
	this.giaTier = giaTier;
}
public int getIdTier() {
	return idTier;
}
public void setIdTier(int idTier) {
	this.idTier = idTier;
}
public String getTenTierMana() {
	return tenTierMana;
}
public void setTenTierMana(String tenTierMana) {
	this.tenTierMana = tenTierMana;
}

}
