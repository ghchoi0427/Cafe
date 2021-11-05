package com.choi.cafe.ui.login;

import com.choi.cafe.data.model.UserType;

/**
 * Class exposing authenticated user details to the UI.
 */
class LoggedInUserView {
    private String displayName;
    private UserType userType;
    //... other data fields that may be accessible to the UI

    LoggedInUserView(String displayName, UserType userType) {
        this.displayName = displayName;
        this.userType = userType;
    }

    String getDisplayName() {
        return displayName;
    }

    UserType getUserType() {
        return userType;
    }
}