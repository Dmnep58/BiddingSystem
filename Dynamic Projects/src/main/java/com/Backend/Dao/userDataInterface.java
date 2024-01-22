package com.Backend.Dao;

import com.Backend.model.User;

import java.util.List;

public interface userDataInterface {
    List<User> getAllUserData();
    boolean isvalidUser(long userid, String userpasswprd);
}
