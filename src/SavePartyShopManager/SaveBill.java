package SavePartyShopManager;

public class SaveBill {
	String DateOrderder , DatePay , PaymenMethod , Goods ;
	int idbill , iduser;
	long price ;
	public SaveBill(String dateOrderder, String datePay, String paymenMethod, String goods, int idbill, int iduser,
			long price) {
		super();
		DateOrderder = dateOrderder;
		DatePay = datePay;
		PaymenMethod = paymenMethod;
		Goods = goods;
		this.idbill = idbill;
		this.iduser = iduser;
		this.price = price;
	}
	public String getDateOrderder() {
		return DateOrderder;
	}
	public void setDateOrderder(String dateOrderder) {
		DateOrderder = dateOrderder;
	}
	public String getDatePay() {
		return DatePay;
	}
	public void setDatePay(String datePay) {
		DatePay = datePay;
	}
	public String getPaymenMethod() {
		return PaymenMethod;
	}
	public void setPaymenMethod(String paymenMethod) {
		PaymenMethod = paymenMethod;
	}
	public String getGoods() {
		return Goods;
	}
	public void setGoods(String goods) {
		Goods = goods;
	}
	public int getIdbill() {
		return idbill;
	}
	public void setIdbill(int idbill) {
		this.idbill = idbill;
	}
	public int getIduser() {
		return iduser;
	}
	public void setIduser(int iduser) {
		this.iduser = iduser;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
}
