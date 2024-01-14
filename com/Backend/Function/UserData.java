package com.Backend.Function;

import com.Backend.DataBase.DataBaseConnection;
import com.Backend.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserData {
    private static Connection connection;
    private static PreparedStatement preparedStatement;

//    fetch all the user data from the database.
    public static List<User> fetchAllUserData(){
        List<User> userDataExtract = new ArrayList<>();
        String query = "SELECT * FROM users";
        try
        {
            connection = DataBaseConnection.getDBConnection();
            preparedStatement = connection.prepareStatement(query);

            ResultSet r = preparedStatement.executeQuery();

            while(r.next()){
                User userData = new User();
                userData.setUserId(r.getLong("userId"));
                userData.setUserName(r.getString("userName"));
                userData.setUserEmail(r.getString("userEmail"));
                userData.setUserPhoneNumber(r.getLong("userPhoneNumber"));
                userData.setUserAddress(r.getString("userAddress"));
                userData.setUserImg(r.getString("userImg"));
                userDataExtract.add(userData);
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            try{
                if(connection != null) connection.close();
                if (preparedStatement!=null) preparedStatement.close();
            }
            catch (SQLException e){
                System.out.printf(e.getMessage());
            }

        }

        return userDataExtract;
    }

    // Insert the user data into the database.
    public static boolean fetchAllUserData(List<User> userDataInsertion){
        boolean isUserDataInserted = true;
        List<User> userAllData = new ArrayList<>();
        String query = "INSET INTO users values( ? , ? , ? , ? , ? , ? , ?)";
        try
        {
            connection = DataBaseConnection.getDBConnection();
            preparedStatement = connection.prepareStatement(query);
            // provide the data values to be inserted.

            int row = preparedStatement.executeUpdate();

            isUserDataInserted = row > 0;
        }
        catch (SQLException e){
            e.printStackTrace();
        }

        return isUserDataInserted;
    }
}
