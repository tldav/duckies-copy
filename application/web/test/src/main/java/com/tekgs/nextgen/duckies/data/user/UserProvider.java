package com.tekgs.nextgen.duckies.data.user;

import java.util.List;

public class UserProvider {
    
    private final UserRepository userRepository = UserRepository.getInstance();
    
    public static UserProvider getInstance() {
        return new UserProvider();
    }

    public User get() {
        return userRepository.query(UserDefinition.getInstance());
    }
    
    public User get(UserDefinition userDefinition) {
        return userRepository.query(userDefinition);
    }
    
    public List<User> getAll() {
        return userRepository.query();
    }
}
