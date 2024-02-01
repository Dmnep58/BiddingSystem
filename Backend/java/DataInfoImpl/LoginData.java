package DataInfoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.biddingsystem.utill.DBConnect;

public class LoginData {
	Connection connection= null;
	PreparedStatement preparedStatement= null;
	
	
	public boolean admin(String username,String password){
		boolean isexists = false;
		
		String sql = "select * from admin where Adminusername = ? and Adminpassword = ?";
		
		try {
			connection = DBConnect.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				isexists = true;
			}
		} catch (SQLException e) {
			// TODO: handle exception
		}
		finally {
			try {
				connection.close();
				preparedStatement.close();
			}
			catch(Exception e) {
				
			}
		}

		return isexists;
	}
	
	
	public boolean user(String id,String password){
		boolean isexists = false;
		String sql = "select * from bidder where bidderid = ? and password =?";
		
		try {
			connection = DBConnect.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1,Integer.parseInt(id));
			preparedStatement.setString(2, password);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				isexists = true;
			}
		} catch (SQLException e) {
			// TODO: handle exception
		}
		finally {
			try {
				connection.close();
				preparedStatement.close();
			}
			catch(Exception e) {
				
			}
		}

		
		return isexists;
	}
	
	public boolean isSeller(String id,String password){
		boolean isexists = false;
		String sql = "select * from sellers where Seller_id = ? and spassword =?";
		
		try {
			connection = DBConnect.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1,Integer.parseInt(id));
			preparedStatement.setString(2, password);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				isexists = true;
			}
		} catch (SQLException e) {
			// TODO: handle exception
		}
		finally {
			try {
				connection.close();
				preparedStatement.close();
			}
			catch(Exception e) {
				
			}
		}
		
		return isexists;
	}

}
