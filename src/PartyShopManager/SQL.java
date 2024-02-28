package PartyShopManagerThuQuynh;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;
import SavePartyShopManager.SavaDrinkMana;
import SavePartyShopManager.SaveCakeMana;
import SavePartyShopManager.SaveColorMana;
import SavePartyShopManager.SaveCookieMana;
import SavePartyShopManager.SaveEmployee;
import SavePartyShopManager.SaveFruitMana;
import SavePartyShopManager.SavePartMana;
import SavePartyShopManager.SaveShapeMana;
import SavePartyShopManager.SaveTasteMana;
import SavePartyShopManager.SaveTierMana;
import mvc.Data;

public class SQL {
	//employees
	public boolean saveEmployee( SaveEmployee ep) {
		try {
			Connection con = DataSQL.getConnection();
			String sql = " insert into Employee (Name,Date,Sex,Cccd,Phone,Salary,Shifts,Note) values (?,?,?,?,?,?,?,?)";
			PreparedStatement pre = con.prepareStatement(sql);
			pre.setString(1, ep.getName());
			pre.setString(2,ep.getDate());
			pre.setString(3, ep.getSex());
			pre.setLong(4, ep.getCccd());
			pre.setLong(5, ep.getPhone());
			pre.setLong(6, ep.getSalary());
			pre.setString(7, ep.getShifts());
			pre.setString(8, ep.getNote());
			pre.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	static boolean deleteEmp(String ID) {
		Connection connection;
		try {
			connection = DataSQL.getConnection();
			String sql = "delete from Employee where Id = ?";
			PreparedStatement pre = connection.prepareStatement(sql);
			pre.setString(1, ID);
			pre.executeUpdate();
			return true;
		} catch(Exception e) {
//			e.printStackTrace();
			return false;
		}
	}

	public boolean updateEmp(SaveEmployee emp) {
		Connection con;
		try {
			con = DataSQL.getConnection();
			String sql = "update Employee set Name=? ,Date=? , Sex=? , Cccd=? , Phone=? , Salary=? , Shifts=? , Note=? where Id=?";
			PreparedStatement pre = con.prepareStatement(sql);
			pre.setString(1, emp.getName());
			pre.setString(2, emp.getDate());
			pre.setString(3, emp.getSex());
			pre.setLong(4, emp.getCccd());
			pre.setLong(5, emp.getPhone());
			pre.setLong(6, emp.getSalary());
			pre.setString(7, emp.getShifts());
			pre.setString(8, emp.getNote());
			pre.setInt(9, emp.getId());
			pre.executeUpdate();
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	// drink
	
	static boolean deleteDrink(String tenDrink) {
		Connection con;
		try {
			con = DataSQL.getConnection();
			String sql = "delete from DrinkMana where tendrink = ?";
			PreparedStatement pre = con.prepareStatement(sql);
			pre.setString(1, tenDrink);
			pre.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean updateDrink(SavaDrinkMana drink) {
		Connection con;
		try {
			con = DataSQL.getConnection();
			String sql = "update DrinkMana set tendrink=? ,sizedrink=? , thanhphandrink=? , giadrink=? where Iddrink=?";
			PreparedStatement pre = con.prepareStatement(sql);
			pre.setString(1, drink.getTenDrink());
			pre.setString(2, drink.getSizeDrink());
			pre.setString(3, drink.getThanhphanDrink());
			pre.setInt(4, drink.getGiaDrink());
			pre.setInt(5, drink.getId());
			pre.executeUpdate();
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean updataDrink1(byte[] anhdrink, int iddrink) {
		Connection con;
		try {
			con = DataSQL.getConnection();
			String sql = "updata DrinkMana set anhdrink=? where Iddrink= ?";
			PreparedStatement pre = con.prepareStatement(sql);
			pre.setBytes(1, anhdrink);
			pre.setInt(2, iddrink);
			pre.executeUpdate();
			pre.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	// cookie
	static boolean deleteCookie(String tenCookie) {
		Connection con;
		try {
			con = DataSQL.getConnection();
			String sql = "delete from CookieMana where Name = ?";
			PreparedStatement pre = con.prepareStatement(sql);
			pre.setString(1, tenCookie);
			pre.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean updateCookie1(int id, byte[] anh) {
		Connection con;
		try {
			con = DataSQL.getConnection();
			String sql = "update CookieMana set Image=? where ID = ?";
			PreparedStatement pre = con.prepareStatement(sql);
			pre.setBytes(1, anh);
			pre.setInt(2, id);

			pre.executeUpdate();
			pre.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean updateCookie(SaveCookieMana cookie) {
		Connection con;
		try {
			con = DataSQL.getConnection();
			String sql = "update CookieMana set Name = ?, MainIngredients = ? , Price = ? where ID = ?";
			PreparedStatement pre = con.prepareStatement(sql);
			pre.setInt(4, cookie.getIdCookie());
			pre.setString(2, cookie.getThanhphanCookie());
			pre.setInt(3, cookie.getGiaCookie());
			pre.setString(1, cookie.getTenCookie());
			pre.executeUpdate();
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	// cake
	static boolean deleteCake(String tenCake) {
		Connection con;
		try {
			con = DataSQL.getConnection();
			String sql = "delete from CakeMana where Name = ?";
			PreparedStatement pre = con.prepareStatement(sql);
			pre.setString(1, tenCake);
			pre.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean updateCake1(int id, byte[] anh) {
		Connection con;
		try {
			con = DataSQL.getConnection();
			String sql = "update CakeMana set Image=? where Idcake = ?";
			PreparedStatement pre = con.prepareStatement(sql);
			pre.setBytes(1, anh);
			pre.setInt(2, id);

			pre.executeUpdate();
			pre.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean updateCake(SaveCakeMana cake) {
		Connection con;
		try {
			con = DataSQL.getConnection();
			String sql = "update CakeMana set Name = ? ,MainIngredients = ? , Price = ? where Idcake = ?";
			PreparedStatement pre = con.prepareStatement(sql);
			pre.setString(1, cake.getTenCake());
			pre.setString(2, cake.getThanhphanCake());
			pre.setInt(3, cake.getGiaCake());
			pre.setInt(4, cake.getIdCake());
			pre.executeUpdate();
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	// fruit Mana
	public boolean saveFruit(SaveFruitMana fruit) {
		try {
			Connection con = DataSQL.getConnection();
			PreparedStatement pre = con.prepareStatement("insert into Fruits(Name,Price) values (?,?)");
			pre.setInt(2, fruit.getGiaFruit());
			pre.setString(1, fruit.getTenFruit());
			pre.executeUpdate();
			JOptionPane.showMessageDialog(null, "Add Successfully");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public boolean deleteFruit(String tenFruit) {
		Connection con;
		try {
			con = DataSQL.getConnection();
			String sql = "delete from Fruits where Name = ?";
			PreparedStatement pre = con.prepareStatement(sql);
			pre.setString(1, tenFruit);
			pre.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean updateFruit(SaveFruitMana fruit) {
		Connection con;
		try {
			con = DataSQL.getConnection();
			String sql = "update Fruits set Price = ? where Name = ?";
			PreparedStatement pre = con.prepareStatement(sql);
			pre.setString(2, fruit.getTenFruit());
			pre.setInt(1, fruit.getGiaFruit());
			// pre.setInt(3, fruit.getIdfruit());

			pre.executeUpdate();
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	// Shape
	public boolean saveColor(SaveColorMana color) {
		try {
			Connection con = DataSQL.getConnection();
			PreparedStatement pre = con.prepareStatement("insert into Colors(Name,Price) values (?,?)");
			pre.setInt(2, color.getGiaColor());
			pre.setString(1, color.getTenColor());
			pre.executeUpdate();
			JOptionPane.showMessageDialog(null, "Add Successfully");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public boolean deleteColor(String tenColor) {
		Connection con;
		try {
			con = DataSQL.getConnection();
			String sql = "delete from Colors where Name = ?";
			PreparedStatement pre = con.prepareStatement(sql);
			pre.setString(1, tenColor);
			pre.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean updateColor(SaveColorMana color) {
		Connection con;
		try {
			con = DataSQL.getConnection();
			String sql = "update Colors set Price = ? where Name = ?";
			PreparedStatement pre = con.prepareStatement(sql);
			pre.setString(2, color.getTenColor());
			pre.setInt(1, color.getGiaColor());
			pre.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	// shape
	public boolean saveShape(SaveShapeMana shape) {
		try {
			Connection con = DataSQL.getConnection();
			PreparedStatement pre = con.prepareStatement("insert into Shapes(Name,Price) values (?,?)");
			pre.setInt(2, shape.getGiaShape());
			pre.setString(1, shape.getTenShape());
			pre.executeUpdate();
			JOptionPane.showMessageDialog(null, "Add Successfully");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public boolean deleteShape(String tenShape) {
		Connection con;
		try {
			con = DataSQL.getConnection();
			String sql = "delete from Shapes where Name = ?";
			PreparedStatement pre = con.prepareStatement(sql);
			pre.setString(1, tenShape);
			pre.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean updateShape(SaveShapeMana shape) {
		Connection con;
		try {
			con = DataSQL.getConnection();
			String sql = "update Shapes set Price = ? where Name = ?";
			PreparedStatement pre = con.prepareStatement(sql);
			pre.setString(2, shape.getTenShape());
			pre.setInt(1, shape.getGiaShape());
			pre.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	// PArt 
	public boolean savePart(SavePartMana part) {
		try {
			Connection con = DataSQL.getConnection();
			PreparedStatement pre = con.prepareStatement("insert into Parts(Name,Price) values (?,?)");
			pre.setInt(2, part.getGiaPart());
			pre.setString(1, part.getTenPart());
			pre.executeUpdate();
			JOptionPane.showMessageDialog(null, "Add Successfully");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public boolean deletePart(String tenPart) {
		Connection con;
		try {
			con = DataSQL.getConnection();
			String sql = "delete from Parts where Name = ?";
			PreparedStatement pre = con.prepareStatement(sql);
			pre.setString(1, tenPart);
			pre.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean updateParts(SavePartMana part) {
		Connection con;
		try {
			con = DataSQL.getConnection();
			String sql = "update Parts set Price = ?, Name = ? where IdPart = ?";
			PreparedStatement pre = con.prepareStatement(sql);
			pre.setString(2, part.getTenPart());
			pre.setInt(1, part.getGiaPart());
			pre.setInt(3, part.getIdPart());
			pre.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	//Taste
	public boolean saveTaste(SaveTasteMana taste) {
		try {
			Connection con = DataSQL.getConnection();
			PreparedStatement pre = con.prepareStatement("insert into Tastes(Name,Price) values (?,?)");
			pre.setInt(2, taste.getGiaTaste());
			pre.setString(1, taste.getTenTaste());
			pre.executeUpdate();
			JOptionPane.showMessageDialog(null, "Add Successfully");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public boolean deleteTaste(String tenTaste) {
		Connection con;
		try {
			con = DataSQL.getConnection();
			String sql = "delete from Tatses where Name = ?";
			PreparedStatement pre = con.prepareStatement(sql);
			pre.setString(1, tenTaste);
			pre.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean updateTaste(SaveTasteMana taste) {
		Connection con;
		try {
			con = DataSQL.getConnection();
			String sql = "update Tastes set Price = ? where Name = ?";
			PreparedStatement pre = con.prepareStatement(sql);
			pre.setString(2, taste.getTenTaste());
			pre.setInt(1, taste.getGiaTaste());
			pre.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	//Tier
	public boolean saveTiers(SaveTierMana tier) {
		try {
			Connection con = DataSQL.getConnection();
			PreparedStatement pre = con.prepareStatement("insert into Tiers(Name,Price) values (?,?)");
			pre.setInt(2, tier.getGiaTier());
			pre.setString(1, tier.getTenTierMana());
			pre.executeUpdate();
			JOptionPane.showMessageDialog(null, "Add Successfully");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public boolean deleteTiers(String tenTier) {
		Connection con;
		try {
			con = DataSQL.getConnection();
			String sql = "delete from Tiers where Name = ?";
			PreparedStatement pre = con.prepareStatement(sql);
			pre.setString(1, tenTier);
			pre.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean updateTiers(SaveTierMana tier) {
		Connection con;
		try {
			con = DataSQL.getConnection();
			String sql = "update Tiers set Price = ? where Name = ?";
			PreparedStatement pre = con.prepareStatement(sql);
			pre.setString(2, tier.getTenTierMana());
			pre.setInt(1, tier.getGiaTier());
			pre.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	// bill 
	public boolean getBillGetNow() {
		try {
			Connection con ;
			con = DataSQL.getConnection();
			String sql =" insert into Bill values (?,?,?,?,?,?) ";
			
			return true ;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
