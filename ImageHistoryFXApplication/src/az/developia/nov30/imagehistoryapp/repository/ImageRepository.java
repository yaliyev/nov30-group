package az.developia.nov30.imagehistoryapp.repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import az.developia.nov30.imagehistoryapp.connection.JDBCConnection;
import az.developia.nov30.imagehistoryapp.model.ImageModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ImageRepository {

	private Connection conn;

	public void insertImage(ImageModel image) {
		conn = JDBCConnection.connect();

		try {
			String query = "INSERT images (path,insert_date,times_used) VALUES ('" + image.getPath() + "','"
					+ Date.valueOf(image.getInsertDate()) + "'," + image.getTimesUsed() + ")";

			Statement statement = conn.createStatement();
			statement.execute(query);
			System.out.println("INSERT: Image");

			statement.close();
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void editImageTimesUsed(Integer imageId, Integer timesUsed) {

		conn = JDBCConnection.connect();

		try {

			String query = "UPDATE images SET times_used = " + timesUsed + "  WHERE id = " + imageId;

			Statement statement = conn.createStatement();
			
			statement.execute(query);
			
			statement.close();
			
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public ImageModel findByPath(String path) {
		ImageModel imageModel = null;
		conn = JDBCConnection.connect();

		String query = "SELECT * FROM images WHERE path = '" + path + "' ";
		Statement statement;
		try {
			statement = conn.createStatement();

			ResultSet rs = statement.executeQuery(query);

			if(rs.next()) {
					
				
                imageModel = new ImageModel();
                
				imageModel.setId(rs.getInt("id"));
				imageModel.setPath(rs.getString("path"));
				imageModel.setInsertDate(rs.getDate("insert_date").toLocalDate());
				imageModel.setTimesUsed(rs.getInt("times_used"));
			}
			


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return imageModel;
	}

	public ObservableList<ImageModel> findAllImages() {
		ObservableList<ImageModel> list = FXCollections.observableArrayList();

		conn = JDBCConnection.connect();

		try {
			String query = "SELECT * FROM images";
			Statement statement = conn.createStatement();

			ResultSet rs = statement.executeQuery(query);

			while (rs.next()) {
				ImageModel imageModel = new ImageModel();
				imageModel.setId(rs.getInt("id"));
				imageModel.setPath(rs.getString("path"));
				imageModel.setInsertDate(rs.getDate("insert_date").toLocalDate());
				imageModel.setTimesUsed(rs.getInt("times_used"));

				list.add(imageModel);
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
}
