package mvc;
public class Student {
	String maSV, hoTen, diaChi, namSinh, sdt, xeploai, matKhau;
	int java, python, sql;
	byte[] anh;
	public Student() {
		java = 0;
		python = 0;
		sql = 0;
	}
	public Student(String maSV, String hoTen, String diaChi, String namSinh, String sdt, String xeploai, int java,
			int python, int sql, byte[] anh, String matKhau) {
		this.maSV = maSV;
		this.hoTen = hoTen;
		this.diaChi = diaChi;
		this.namSinh = namSinh;
		this.sdt = sdt;
		this.xeploai = xeploai;
		this.java = java;
		this.python = python;
		this.sql = sql;
		this.anh = anh;
		this.matKhau = matKhau;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public String getMaSV() {
		return maSV;
	}
	public void setMaSV(String maSV) {
		this.maSV = maSV;
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
	public String getXeploai() {
		return xeploai;
	}
	public void setXeploai(String xeploai) {
		this.xeploai = xeploai;
	}
	public int getJava() {
		return java;
	}
	public void setJava(int java) {
		this.java = java;
	}
	public int getPython() {
		return python;
	}
	public void setPython(int python) {
		this.python = python;
	}
	public int getSql() {
		return sql;
	}
	public void setSql(int sql) {
		this.sql = sql;
	}
	public byte[] getAnh() {
		return anh;
	}
	public void setAnh(byte[] anh) {
		this.anh = anh;
	}
	
	
}
