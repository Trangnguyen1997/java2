package da;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import dataobject.Brand;
import dataobject.Category;
import dataobject.UnitOfMeasure;

/**
 * 
 */

/**
 * @author Trang
 *
 */
public class SQLiteDB {

	/**
	 * @param args
	 */

	private static Connection connect() {
		String url = "jdbc:sqlite:foc2warehouse.db";
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}

	public Vector<Category> getAllCategory() {
		String sql = "SELECT * FROM categories";
		Vector<Category> categoryList = new Vector<>();
		try (Connection conn = connect();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			while (rs.next()) {
				Category cat = new Category();
				cat.setCategoryId(rs.getInt("ID"));
				cat.setCategoryName(rs.getString("Categoryname"));

				categoryList.add(cat);
			}
			return categoryList;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return categoryList;
	}
	public Vector<Brand> getAllBrand() {
		String sql = "SELECT * FROM brand";
		Vector<Brand> brandlist = new Vector<>();
		try (Connection conn = connect();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			while (rs.next()) {
				Brand bra = new Brand(rs.getInt("ID"), rs.getString("brandname"));

				brandlist.add(bra);
			}
			return brandlist;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return brandlist;
	}
	public Vector<UnitOfMeasure> getAllUnitofmeasure() {
		String sql = "SELECT * FROM unitofmeasure";
		Vector<UnitOfMeasure> unitofmeasurelist= new Vector<>();
		try (Connection conn = connect();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			while (rs.next()) {
				UnitOfMeasure unit = new UnitOfMeasure(rs.getInt("ID"), rs.getString("Name"));

				unitofmeasurelist.add(unit);
			}
			return unitofmeasurelist;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return unitofmeasurelist;
	}
	
	public void getAllProducts() {
		String sql = "SELECT * FROM products";

		try (Connection conn = connect();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			// loop through the result set
			while (rs.next()) {
			System.out.format("%3d %-40s\n", rs.getInt("id"), rs.getString("productname"));
					
			}
				
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void insert(String pCode, String name, int categoryid, int brandid, int unitiOfMeasure, double unitprice, String description){
		String sql = "INSERT INTO products (productcode, productname, categoryid, brandid, unitofmeasure)" + "VALUES(?,?,?,?,?,?)";
		try(Connection conn = connect();
				PreparedStatement pstmt = conn.prepareStatement(sql)){
					pstmt.setString(1, pCode);
					pstmt.setString(2, name);
					pstmt.setDouble(3, categoryid);
					pstmt.setInt(4, brandid);
					pstmt.setInt(5, unitiOfMeasure);
					pstmt.setDouble(6, unitprice);
					pstmt.setString(7, description);
					pstmt.executeUpdate();
		}catch (SQLException e){
			System.out.println(e.getMessage());
				}
	}
	
	public static void update(String name, int categoryid, double pPrice, int pUnitInStock, int pProductid){
		String sql = "UPDATE products SET productname = ?, categoryid = ?, unitprice = ?, unitinstock = ? WHERE id = ?";
		try(Connection conn = connect();
				PreparedStatement pstmt = conn.prepareStatement(sql)){
					pstmt.setString(1, name);
					pstmt.setInt(2, categoryid);
					pstmt.setDouble(3, pPrice);
					pstmt.setInt(4, pUnitInStock);
					pstmt.setInt(5, pProductid);
					pstmt.executeUpdate();
		}catch (SQLException e){
			System.out.println(e.getMessage());
				}
	}
	
	public static void delete(int pProductid){
		String sql = "DELETE FROM products WHERE productid = ?";
		try(Connection conn = connect();
				PreparedStatement pstmt = conn.prepareStatement(sql)){
					pstmt.setInt(1, pProductid);
					pstmt.executeUpdate();
		}catch (SQLException e){
			System.out.println(e.getMessage());
				}
	}
	
}
