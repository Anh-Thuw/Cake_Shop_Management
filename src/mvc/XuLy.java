package mvc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class XuLy {
	// them moi du lieu 
	static boolean newStudent(Student student) {
		Connection connection;
		try {
			connection = Data.getConnection();
			String sql = "insert into Student (masinhvien,hoten,sdt,namsinh,diachi,anh,java, python, sql) values (?,?,?,?,?,?,?,?,?)";
			PreparedStatement pre = connection.prepareStatement(sql);
			pre.setString(1, student.getMaSV());
			pre.setString(2, student.getHoTen());
			pre.setString(3, student.getSdt());
			pre.setString(4, student.getNamSinh());
			pre.setString(5, student.getDiaChi());
			pre.setBytes(6, student.getAnh());
			pre.setInt(7, student.getJava());
			pre.setInt(8, student.getPython());
			pre.setInt(9, student.getSql());
			
			sql = "insert into login(tendangnhap,matkhau,chucvu) values(?,?,?)";
			PreparedStatement prepared = connection.prepareStatement(sql);
			prepared.setString(1, student.getMaSV());
			prepared.setString(2, student.getMaSV());
			prepared.setString(3, "Student");
			
			return (pre.executeUpdate() > 0) && (prepared.executeUpdate() > 0) ;
		} catch(Exception e) {
//			e.printStackTrace();
//			JOptionPane.showMessageDialog(null, "Ä�Ã£ tá»“n táº¡i ");
			return false;
		}
	}
	public boolean updateStudent(Student student) {
		Connection connection;
		try {
			connection = Data.getConnection();
			
			String sql = "update Student set hoten = ?,sdt = ?,namsinh = ?,diachi = ? where masinhvien = ?";
			PreparedStatement prepared = connection.prepareStatement(sql);
			prepared.setString(5, student.getMaSV());
			prepared.setString(1, student.getHoTen());
			prepared.setString(2, student.getSdt());
			prepared.setString(3, student.getNamSinh());
			prepared.setString(4, student.getDiaChi());
			prepared.executeUpdate() ;
			return true;
		} catch(Exception e) {
//			e.printStackTrace();
			return false;
		}
	}
	
	static Student findStudent(String maSinhVien) {
		Connection connection;
		try {
			connection = Data.getConnection();
			String sql = "select * from Student where masinhvien = '"+maSinhVien+"'";
			Statement pre = connection.createStatement();
			
			Student student = new Student();
			ResultSet rs = pre.executeQuery(sql);
			if(rs.next()) {
				student.setMaSV(maSinhVien);;
				student.setHoTen(rs.getString("HOTEN"));
				student.setSdt(rs.getString("SDT"));
				student.setNamSinh(rs.getString("NAMSINH"));
				student.setDiaChi(rs.getString("DIACHI"));
				student.setAnh(rs.getBytes("ANH"));
			}
		
			return student;
		} catch(Exception e) {
//			e.printStackTrace();
			return null;
		}
	}
	static boolean deleteStudent(String maSinhVien) {
		Connection connection;
		try {
			connection = Data.getConnection();
			String sql = "delete from Student where masinhvien = ?";
			PreparedStatement pre = connection.prepareStatement(sql);
			pre.setString(1, maSinhVien);
			
			sql = "delete from login where tendangnhap = ?";
			PreparedStatement prepared = connection.prepareStatement(sql);
			prepared.setString(1, maSinhVien);
			
			return (pre.executeUpdate() > 0) && (prepared.executeUpdate() > 0);
		} catch(Exception e) {
//			e.printStackTrace();
			return false;
		}
	}
	
	
	
	static boolean newTeacher(Teacher teacher) {
		Connection connection;
		try {
			connection = Data.getConnection();
			String sql = "insert into Teacher (magiangvien,hoten,sdt,namsinh,diachi,anh, mon) values (?,?,?,?,?,?,?)";
			PreparedStatement pre = connection.prepareStatement(sql);
			pre.setString(1, teacher.getMaGV());
			pre.setString(2, teacher.getHoTen());
			pre.setString(3, teacher.getSdt());
			pre.setString(4, teacher.getNamSinh());
			pre.setString(5, teacher.getDiaChi());
			pre.setBytes(6, teacher.getAnh());
			pre.setString(7, teacher.getMon());
			
			sql = "insert into login (tendangnhap,matkhau,chucvu) values (?,?,?)";
			PreparedStatement prepared = connection.prepareStatement(sql);
			prepared.setString(1, teacher.getMaGV());
			prepared.setString(2, teacher.getMaGV());
			prepared.setString(3, "Teacher");
			
			return (pre.executeUpdate() > 0) && (prepared.executeUpdate() >0);
		} catch(Exception e) {
			e.printStackTrace();
//			JOptionPane.showMessageDialog(null, "Ä�Ã£ tá»“n táº¡i ");
			return false;
		}
	}
	public boolean updateTeacher(Teacher teacher) {
		Connection connection;
		try {
			connection = Data.getConnection();
			
			String sql = "update Teacher set hoten = ?,sdt = ?,namsinh = ?,diachi = ?, mon = ? where magiangvien = ?";
			PreparedStatement prepared = connection.prepareStatement(sql);
			prepared.setString(6, teacher.getMaGV());
			prepared.setString(1, teacher.getHoTen());
			prepared.setString(2, teacher.getSdt());
			prepared.setString(3, teacher.getNamSinh());
			prepared.setString(4, teacher.getDiaChi());
			prepared.setString(5, teacher.getMon());
			prepared.executeUpdate() ;
			return true;
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	static Teacher findTeacher(String maGiangVien) {
		Connection connection;
		try {
			connection = Data.getConnection();
			String sql = "select * from teacher where magiangvien = '"+maGiangVien+"'";
			Statement pre = connection.createStatement();
			
			Teacher teacher = new Teacher();
			ResultSet rs = pre.executeQuery(sql);
			if(rs.next()) {
				teacher.setMaGV(maGiangVien);;
				teacher.setHoTen(rs.getString("HOTEN"));
				teacher.setSdt(rs.getString("SDT"));
				teacher.setNamSinh(rs.getString("NAMSINH"));
				teacher.setDiaChi(rs.getString("DIACHI"));
				teacher.setAnh(rs.getBytes("ANH"));
				teacher.setMon(rs.getString("MON"));
			}
			return teacher;
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	static boolean deleteTeacher(String maGiangVien) {
		Connection connection;
		try {
			connection = Data.getConnection();
			String sql = "delete from Teacher where magiangvien = ?";
			PreparedStatement pre = connection.prepareStatement(sql);
			pre.setString(1, maGiangVien);
			
			sql = "delete from login where tendangnhap = ?";
			PreparedStatement prepared = connection.prepareStatement(sql);
			prepared.setString(1, maGiangVien);
			return (pre.executeUpdate() > 0) && (prepared.executeUpdate() > 0);
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
