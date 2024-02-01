package DataInfoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.biddingsystem.utill.DBConnect;

public class CustomerDashboard {
	public static Datainfo df = new Datainfo();
	public static Connection connection= null;
	public static PreparedStatement preparedstatement = null;
	
	
	
	// find the last alloted product
	public String lastallotedproduct(long bidderid) {
		String name = null;
		String query = "SELECT productid FROM bids WHERE status = 'alloted' and bidderid = ?  ORDER BY productid DESC LIMIT 1";
		 try {
			 connection = DBConnect.getConnection();
			 preparedstatement = connection.prepareStatement(query);
			 preparedstatement.setLong(1, bidderid);
			 
			 ResultSet r = preparedstatement.executeQuery();
			 
			 while(r.next()) {
				 name = df.prname((int) r.getLong(1));
			 }
			 
		 }
		 catch(SQLException e) {
			 
		 }
		 finally {
			 try {
				 if(connection != null) {
					 connection.close();
				 }
				 if(preparedstatement != null) {
					 preparedstatement.close();
				 }
			 }
			 catch(SQLException e) {
				 
			 }
		 }
		
		
		return name;
	}
	
	 
	public List<String> LastThreeProducts(int bidderid){
		List<String> s = new ArrayList<>();
		String query = "SELECT productid FROM bids WHERE status = 'pending' and bidderid = ?  ORDER BY id DESC LIMIT 3";
		 try {
			 connection = DBConnect.getConnection();
			 preparedstatement = connection.prepareStatement(query);
			 preparedstatement.setLong(1, bidderid);
			 
			 ResultSet r = preparedstatement.executeQuery();
			 
			 while(r.next()) {
				 s.add(df.prname(r.getInt(1)));
			 }
			 
		 }
		 catch(SQLException e) {
			 
		 }
		 finally {
			 try {
				 if(connection != null) {
					 connection.close();
				 }
				 if(preparedstatement != null) {
					 preparedstatement.close();
				 }
			 }
			 catch(SQLException e) {
				 
			 }
		 }
		
		return s;
	}
	
	
	

}
