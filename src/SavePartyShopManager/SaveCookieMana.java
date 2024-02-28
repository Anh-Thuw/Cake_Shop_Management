package SavePartyShopManager;

public class SaveCookieMana {
	String tenCookie , thanhphanCookie ;
	int giaCookie , IdCookie;
	byte[] anhCookie ;
	public SaveCookieMana() {
		
	}
	public SaveCookieMana(String tenCookie, String thanhphanCookie, int giaCookie, int idCookie, byte[] anhCookie) {
		
		this.tenCookie = tenCookie;
		this.thanhphanCookie = thanhphanCookie;
		this.giaCookie = giaCookie;
		IdCookie = idCookie;
		this.anhCookie = anhCookie;
	}
	public String getTenCookie() {
		return tenCookie;
	}
	public void setTenCookie(String tenCookie) {
		this.tenCookie = tenCookie;
	}
	public String getThanhphanCookie() {
		return thanhphanCookie;
	}
	public void setThanhphanCookie(String thanhphanCookie) {
		this.thanhphanCookie = thanhphanCookie;
	}
	public int getGiaCookie() {
		return giaCookie;
	}
	public void setGiaCookie(int giaCookie) {
		this.giaCookie = giaCookie;
	}
	public int getIdCookie() {
		return IdCookie;
	}
	public void setIdCookie(int idCookie) {
		IdCookie = idCookie;
	}
	public byte[] getAnhCookie() {
		return anhCookie;
	}
	public void setAnhCookie(byte[] anhCookie) {
		this.anhCookie = anhCookie;
	}
	
}
