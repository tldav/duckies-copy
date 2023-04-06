package com.tekgs.nextgen.duckies.data.user;

public interface UserCalibratable {
    String getUsername();
    
    String getPassword();
    
    boolean equivalent(UserCalibratable comparator);
    
    String getId();
}
