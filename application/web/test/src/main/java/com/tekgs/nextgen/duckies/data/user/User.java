package com.tekgs.nextgen.duckies.data.user;

public class User implements UserCalibratable {
    private final String id;
    private final String password;
    private final String username;
    
    private User(String id, String password, String username) {
        this.id = id;
        this.password = password;
        this.username = username;
    }
    
    public String getPassword() {
        return this.password;
    }
    
    @Override
    public boolean equivalent(UserCalibratable comparator) {
        if (comparator == null) {
            return false;
        }
//        if (this.id != null && this.id.equals(comparator.getId())) {
//            return true;
//        }
        boolean isEquivalent = comparator.getUsername() == null || this.getUsername().equals(comparator.getUsername());
        isEquivalent &= comparator.getPassword() == null || this.getPassword().equals(comparator.getPassword());
        System.out.println("\n======================== isEquivalent ========================\n");
        System.out.println(isEquivalent);
        System.out.println("\n======================== isEquivalent ========================\n");
        return isEquivalent;
    }
    
    @Override
    public String getId() {
        return this.id;
    }
    
    public String getUsername() {
        return this.username;
    }
}
