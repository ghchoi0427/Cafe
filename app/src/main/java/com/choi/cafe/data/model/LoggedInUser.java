package com.choi.cafe.data.model;

import com.choi.cafe.ui.login.UserType;

/**
 * Data class that captures user information for logged in users retrieved from LoginRepository
 */
public class LoggedInUser {

    private String userId;
    private String displayName;
    private UserType userType;

    public LoggedInUser(String userId, String displayName, UserType userType) {
        this.userId = userId;
        this.displayName = displayName;
        this.userType = userType;
    }

    public String getUserId() {
        return userId;
    }

    public String getDisplayName() {
        return displayName;
    }

    public UserType getUserType(){
        return userType;
    }
}