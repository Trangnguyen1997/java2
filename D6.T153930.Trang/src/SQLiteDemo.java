import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 
 */

/**
 * @author Trang
 *
 */
public class SQLiteDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// insert("TV", 5, 5500, 5);
		// update("TV", 5, 6000, 7, 79);
		delete(79);
		getAllProducts();

	}

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

	private static void getAllProducts() {
		String sql = "SELECT * FROM products";

		try (Connection conn = connect();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			// loop through the result set
			while (rs.next()) {
				System.out.format("%3d %-40s %7.2f %4d\n", rs.getInt("productid"), rs.getString("productname"),
						rs.getDouble("unitprice"), rs.getInt("unitinstock"));

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


	public static void update(String name, int categoryid, double pPrice, int pUnitInStock, int pProductid) {
		String sql = "UPDATE products SET productname = ?, categoryid = ?, unitprice = ?, unitinstock = ? WHERE productid = ?";
		try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, name);
			pstmt.setInt(2, categoryid);
			pstmt.setDouble(3, pPrice);
			pstmt.setInt(4, pUnitInStock);
			pstmt.setInt(5, pProductid);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			
		}
	}

	public static void delete(int pProductid) {
		String sql = "DELETE FROM products WHERE productid = ?";
		try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, pProductid);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

}
