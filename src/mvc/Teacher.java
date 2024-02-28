package mvc;

public class Teacher {
	String maGV, hoTen, diaChi, namSinh, sdt, mon, matKhau;
	byte[] anh;
	
	public Teacher() {
		
	}
	
	public Teacher(String maGV, String hoTen, String diaChi, String namSinh, String sdt, String mon, String matKhau,
			byte[] anh) {
		super();
		this.maGV = maGV;
		this.hoTen = hoTen;
		this.diaChi = diaChi;
		this.namSinh = namSinh;
		this.sdt = sdt;
		this.mon = mon;
		this.matKhau = matKhau;
		this.anh = anh;
	}


	public String getMaGV() {
		return maGV;
	}
	public void setMaGV(String maGV) {
		this.maGV = maGV;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getNamSinh() {
		return namSinh;
	}
	public void setNamSinh(String namSinh) {
		this.namSinh = namSinh;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getMon() {
		return mon;
	}
	public void setMon(String mon) {
		this.mon = mon;
	}
	public String getMatKhau() {
		return matKhau;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	public byte[] getAnh() {
		return anh;
	}
	public void setAnh(byte[] anh) {
		this.anh = anh;
	}

}
