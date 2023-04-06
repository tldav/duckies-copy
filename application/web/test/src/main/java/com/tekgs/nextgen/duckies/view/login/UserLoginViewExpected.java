package com.tekgs.nextgen.duckies.view.login;

import com.tekgs.nextgen.duckies.data.user.User;
import com.tekgs.nextgen.duckies.data.user.UserProvider;

import java.util.List;

public class UserLoginViewExpected implements UserLoginViewCalibratable {
    public static final String LOGIN_FAILURE = "Invalid username or password";
    public static final String LOGIN_SUCCESS = "Logged in";
    private final User user;
    private final String username;
    private final String password;
    private final List<User> userList;
    
    public UserLoginViewExpected(User user, String username, String password) {
        this.user = user;
        this.username = username;
        this.password = password;
        this.userList = UserProvider.getInstance().getAll();
    }
    
    public static UserLoginViewExpected getInstance(User user) {
        return new UserLoginViewExpected(user, null, null);
    }
    
    public static UserLoginViewExpected getInstance(String username, String password) {
        return new UserLoginViewExpected(null, username, password);
    }
    
    public static UserLoginViewExpected getInstance() {
        return new UserLoginViewExpected(null, null, null);
    }
    
    private boolean areCredentialsValid() {
        if (this.user == null) {
            return false;
        }
        boolean isValid = this.getUserByName() != null && this.getUserByName().getPassword().equals(this.password);
        System.out.println("\n======================== isValid ========================\n");
        System.out.println(isValid);
        System.out.println("\n======================== isValid ========================\n");
        return isValid;
    }
    
    private User getUserByName() {
        User user = null;
        for (User u : userList) {
            if (this.user != null && u.getUsername().equals(this.user.getUsername())) {
                user = u;
            }
        }
        return user;
    }
    
    @Override
    public String getTitle() {
        return "Login";
    }
    
    @Override
    public String getPasswordField() {
        return "Password";
    }
    
    @Override
    public String getUsernameField() {
        return "Username";
    }
    
    @Override
    public String getSubmitButton() {
        return "Submit";
    }
    
    @Override
    public String getLoginStatusMessage() {
        return this.areCredentialsValid() ? LOGIN_SUCCESS : LOGIN_FAILURE;
    }
    
    
}
