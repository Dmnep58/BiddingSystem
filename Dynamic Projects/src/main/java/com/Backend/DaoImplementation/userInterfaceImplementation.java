package com.Backend.DaoImplementation;

import com.Backend.Dao.userDataInterface;
import com.Backend.Function.UserData;
import com.Backend.model.User;

import java.util.List;

public class userInterfaceImplementation implements userDataInterface {
    @Override
    public List<User> getAllUserData() {
        return UserData.fetchAllUserData();
    }
    
}
