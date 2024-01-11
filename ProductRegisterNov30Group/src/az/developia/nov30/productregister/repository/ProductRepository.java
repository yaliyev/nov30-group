package az.developia.nov30.productregister.repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import az.developia.nov30.productregister.connection.JDBCConnection;
import az.developia.nov30.productregister.model.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ProductRepository {

	private Connection conn;

	// CRUD(Create,Read,Update,Delete)

	public void createProduct(Product product) {
		conn = JDBCConnection.connect();

		try {
			PreparedStatement statement = conn.prepareStatement(
					"INSERT INTO productregister_products(name,category,quantity,price,arrival_date,status,image_path) VALUES (?,?,?,?,?,?,?)");

			statement.setString(1, product.getName());
			statement.setString(2, product.getCategory());
			statement.setInt(3, product.getQuantity());
			statement.setInt(4, product.getPrice());
			statement.setDate(5, Date.valueOf(product.getArrivalDate()));
			statement.setString(6, product.getStatus());
			statement.setString(7, product.getImagePath());

			statement.execute();

			System.out.println("CREATE: PRODUCT");

			statement.close();
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ObservableList<Product> getAllProducts() {
		ObservableList<Product> list = FXCollections.observableArrayList();

		conn = JDBCConnection.connect();

		try {
			PreparedStatement statement = conn.prepareStatement("SELECT * FROM productregister_products");

			ResultSet rs = statement.executeQuery();

			System.out.println("READ: PRODUCT");

			while (rs.next()) {
				Product product = new Product();

				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setCategory(rs.getString("category"));
				product.setQuantity(rs.getInt("quantity"));
				product.setPrice(rs.getInt("price"));
				product.setArrivalDate(rs.getDate("arrival_date").toLocalDate());
				product.setStatus(rs.getString("status"));
				product.setImagePath(rs.getString("image_path"));

				list.add(product);
			}

			rs.close();
			statement.close();
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}
	
	public ObservableList<Product> searchProducts(String searchString) {
		ObservableList<Product> list = FXCollections.observableArrayList();

		conn = JDBCConnection.connect();

		try {
			Statement statement = conn.createStatement();

			ResultSet rs = statement.executeQuery("SELECT * FROM productregister_products WHERE id LIKE "+searchString+" OR name LIKE '"+searchString+"' OR category LIKE '"+searchString+"' OR quantity LIKE '"+searchString+"' OR price LIKE '"+searchString+"' OR arrival_date LIKE '"+searchString+"' ");

			System.out.println("SEARCH: PRODUCT");

			while (rs.next()) {
				Product product = new Product();

				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setCategory(rs.getString("category"));
				product.setQuantity(rs.getInt("quantity"));
				product.setPrice(rs.getInt("price"));
				product.setArrivalDate(rs.getDate("arrival_date").toLocalDate());
				product.setStatus(rs.getString("status"));
				product.setImagePath(rs.getString("image_path"));

				list.add(product);
			}

			rs.close();
			statement.close();
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}
	
	

	public void updateStatus(Integer whichProductWillBeUpdatedId, String status) {
		conn = JDBCConnection.connect();

		try {
			PreparedStatement statement = conn
					.prepareStatement("UPDATE productregister_products SET status = ? WHERE id = ?");

			statement.setString(1, status);
			statement.setInt(2, whichProductWillBeUpdatedId);

			statement.executeUpdate();

			System.out.println("UPDATE: PRODUCT STATUS");

			statement.close();
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void updateProduct(Integer whichProductWillBeUpdatedId, Product product) {
		conn = JDBCConnection.connect();

		try {
			PreparedStatement statement = conn.prepareStatement(
					"UPDATE productregister_products SET name = ?,category = ?,quantity = ?,price = ?,arrival_date = ?,status = ?,image_path = ? WHERE id = ?");

			statement.setString(1, product.getName());
			statement.setString(2, product.getCategory());
			statement.setInt(3, product.getQuantity());
			statement.setInt(4, product.getPrice());
			statement.setDate(5, Date.valueOf(product.getArrivalDate()));
			statement.setString(6, product.getStatus());
			statement.setString(7, product.getImagePath());
			statement.setInt(8, whichProductWillBeUpdatedId);

			statement.executeUpdate();

			System.out.println("UPDATE: PRODUCT");

			statement.close();
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void deleteProduct(Integer whichProductWillBeDeletedId) {
		conn = JDBCConnection.connect();

		try {
			PreparedStatement statement = conn.prepareStatement("DELETE productregister_products WHERE id = ?");

			statement.setInt(1, whichProductWillBeDeletedId);

			statement.executeUpdate();

			System.out.println("DELETE: PRODUCT");

			statement.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void deleteAllProducts() {
		conn = JDBCConnection.connect();

		try {
			PreparedStatement statement = conn.prepareStatement("TRUNCATE productregister_products"); //

			statement.executeUpdate();

			System.out.println("TRUNCATE: PRODUCT");

			statement.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
