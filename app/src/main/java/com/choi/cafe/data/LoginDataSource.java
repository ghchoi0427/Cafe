package com.choi.cafe.data;

import com.choi.cafe.data.model.LoggedInUser;
import com.choi.cafe.data.model.UserType;

import java.io.IOException;

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
public class LoginDataSource {

    public Result<LoggedInUser> login(String username, String password) {

        try {
            // TODO: handle loggedInUser authentication
            LoggedInUser loggedInUser =
                    new LoggedInUser(
                            java.util.UUID.randomUUID().toString(),
                            username, UserType.Staff);
            //TODO: set username to actual user name retrieved from server
            return new Result.Success<>(loggedInUser);
        } catch (Exception e) {
            return new Result.Error(new IOException("Error logging in", e));
        }
    }

    public void logout() {
        // TODO: revoke authentication
    }
}