package da;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import dataobject.Category;

public class CategoryDA extends WHConnection{
	
	

	public Vector<Category> getAllCategory() {
		String sql = "SELECT * FROM category";
		Vector<Category> categoryList = new Vector<>();
		try (Connection conn = connect();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			while (rs.next()) {
				Category cat = new Category();
				cat.setCategoryId(rs.getInt("id"));
				cat.setCategoryName(rs.getString("categoryname"));

				categoryList.add(cat);
			}
			return categoryList;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return categoryList;
	}
	
}
