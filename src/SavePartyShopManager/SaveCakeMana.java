package SavePartyShopManager;

public class SaveCakeMana {
	String tenCake, thanhphanCake;
	int giaCake , idCake;
	byte[] anhCake;

	public SaveCakeMana() {

	}

	public SaveCakeMana(String tenCake, String thanhphanCake, int giaCake, int idCake, byte[] anhCake) {
		
		this.tenCake = tenCake;
		this.thanhphanCake = thanhphanCake;
		this.giaCake = giaCake;
		this.idCake = idCake;
		this.anhCake = anhCake;
	}

	public String getTenCake() {
		return tenCake;
	}

	public void setTenCake(String tenCake) {
		this.tenCake = tenCake;
	}

	public String getThanhphanCake() {
		return thanhphanCake;
	}

	public void setThanhphanCake(String thanhphanCake) {
		this.thanhphanCake = thanhphanCake;
	}

	public int getGiaCake() {
		return giaCake;
	}

	public void setGiaCake(int giaCake) {
		this.giaCake = giaCake;
	}

	public int getIdCake() {
		return idCake;
	}

	public void setIdCake(int idCake) {
		this.idCake = idCake;
	}

	public byte[] getAnhCake() {
		return anhCake;
	}

	public void setAnhCake(byte[] anhCake) {
		this.anhCake = anhCake;
	}

}
