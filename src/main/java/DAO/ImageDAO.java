package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.SingleConnection;
import models.Image;

public class ImageDAO {
	
	private Connection connection;
	
	public ImageDAO() {
		connection = SingleConnection.getConnection();
	}
	
	public void create(Image image) throws SQLException{
		
		String sql = String.format("INSERT INTO uploaded_images (image64, name, type) VALUES('%s', '%s', '%s')", image.getImage64b(), image.getName(), image.getType());
		PreparedStatement sqlStatement = connection.prepareStatement(sql);
		int query = sqlStatement.executeUpdate();
		
		connection.commit();
		
		if(query == 1) {
			System.out.println("Query has created 1 row(s)");
		} else {
			System.out.println("Query has created 0 row(s)");
		}
	}
	
	public List<Image> select() throws SQLException{
		List<Image> images = new ArrayList<Image>();
		
		String sql = "SELECT * FROM uploaded_images";
		PreparedStatement sqlStatement = connection.prepareStatement(sql);
		ResultSet result = sqlStatement.executeQuery();
		
		while(result.next()) {
			Image img = new Image();
			img.setImage64b(result.getString(1));
			img.setName(result.getString(2));
			img.setType(result.getString(3));
			images.add(img);
		}
		
		return images;
	}

}
