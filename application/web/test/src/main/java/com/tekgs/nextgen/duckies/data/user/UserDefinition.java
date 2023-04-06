package com.tekgs.nextgen.duckies.data.user;

public class UserDefinition implements UserCalibratable {
    
    private String username;
    private String password;
    private String id;
//    private boolean isValidUsername;
    
    private UserDefinition() {
    
    }
    
    public static UserDefinition getInstance() {
        return new UserDefinition();
    }
    
//    public UserDefinition withValidUsername(boolean isValidUsername) {
//        List<User> userList = UserProvider.getInstance().getAll();
//
//        for (User user : userList) {
//            if (user.getUsername().equals(this.username)) {
//                this.isValidUsername = true;
//            }
//        }
//        return this;
//    }
    
    
    public UserDefinition withUsername(String username) {
        this.username = username;
        return this;
    }
    
    public UserDefinition withPassword(String password) {
        this.password = password;
        return this;
    }
    
    public UserDefinition withId(String id) {
        this.id = id;
        return this;
    }
    
    
    @Override
    public String getUsername() {
        return this.username;
    }
    
    @Override
    public String getPassword() {
        return this.password;
    }
    
    @Override
    public boolean equivalent(UserCalibratable comparator) {
        return false;
    }
    
    @Override
    public String getId() {
        return this.id;
    }
}
