package DataInfoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



import com.biddingsystem.utill.DBConnect;

public class CheckDupliacteData {
	
	static Connection conn = null;
	static PreparedStatement preparedstatement = null;
	
	
	// check the admin is already registered or not
	public static boolean isAdminPresent(long AdminTelephone) {
		boolean ispresent = false;
		
		String query = "select AdminTelephone from admin";
		
		try {
			conn = DBConnect.getConnection();
			preparedstatement = conn.prepareStatement(query);
			
			ResultSet r = preparedstatement.executeQuery();
			
			while(r.next()) {
				if(AdminTelephone == r.getLong(1)){
					ispresent = true;
				}
			}
			
		}
		catch(SQLException e) {
			
		}
		finally {
			try {
				if(conn != null) {
					conn.close();
				}
				if(preparedstatement != null) {
					preparedstatement.close();
				}
			}
			catch(SQLException e) {
				
			}
		}
		
		
		return ispresent;
	}
	
	
	// check duplicate entry for the bidder
	public static boolean isBidderPresent(String Bidderemail) {
		boolean ispresent= false;
		
		
		String query= "select email from Bidder";
		try {
			conn = DBConnect.getConnection();
			preparedstatement = conn.prepareStatement(query);
			
			ResultSet r = preparedstatement.executeQuery();
			
			while(r.next()) {
				if(Bidderemail.equals(r.getString(1))){
					ispresent = true;
				}
			}
			
		}
		catch(SQLException e) {
			
		}
		finally {
			try {
				if(conn != null) {
					conn.close();
				}
				if(preparedstatement != null) {
					preparedstatement.close();
				}
			}
			catch(SQLException e) {
				
			}
		}
		
		return ispresent;
	}
	
	
	// check duplicate entry for seller
	public static boolean isSellerPresent(String selleremail) {
       boolean ispresent= false;
		
		
		String query= "select semail from Sellers";
		try {
			conn = DBConnect.getConnection();
			preparedstatement = conn.prepareStatement(query);
			
			ResultSet r = preparedstatement.executeQuery();
			
			while(r.next()) {
				if(selleremail.equals(r.getString(1))){
					ispresent = true;
				}
			}
			
		}
		catch(SQLException e) {
			
		}
		finally {
			try {
				if(conn != null) {
					conn.close();
				}
				if(preparedstatement != null) {
					preparedstatement.close();
				}
			}
			catch(SQLException e) {
				
			}
		}
		
		return ispresent;
	}
	

}
