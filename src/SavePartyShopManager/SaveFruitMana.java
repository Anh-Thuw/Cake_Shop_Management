package SavePartyShopManager;

public class SaveFruitMana {
	int giaFruit , idFruit  ;
	String tenFruit;
	public SaveFruitMana() {
		
	}
	public SaveFruitMana(int giaFruit, int idFruit, String tenFruit) {
		super();
		this.giaFruit = giaFruit;
		this.idFruit = idFruit;
		this.tenFruit = tenFruit;
	}
	public int getGiaFruit() {
		return giaFruit;
	}
	public void setGiaFruit(int giaFruit) {
		this.giaFruit = giaFruit;
	}
	public int getIdFruit() {
		return idFruit;
	}
	public void setIdFruit(int idFruit) {
		this.idFruit = idFruit;
	}
	public String getTenFruit() {
		return tenFruit;
	}
	public void setTenFruit(String tenFruit) {
		this.tenFruit = tenFruit;
	}
	
}