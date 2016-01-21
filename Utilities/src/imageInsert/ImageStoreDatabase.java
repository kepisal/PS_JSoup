package imageInsert;

import java.io.*;
import java.sql.*;

public class ImageStoreDatabase {
	
	
	
	
	
	public static void main(String args[]) {
		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/imagedb", "postgres",
					"0231");
			System.out.println(con.getMetaData().getDatabaseProductName());

			PreparedStatement pstmt = con.prepareStatement("insert into tbimage values(?,?)");
			FileInputStream fis = new FileInputStream("C:\\Users\\Pisal\\Pictures\\Picture1.png");
			pstmt.setInt(1, 21);
			pstmt.setBinaryStream(2, fis, fis.available());
			pstmt.executeUpdate();
			System.out.println("Completed");
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			// pstmt.close();
		}
	}

}
