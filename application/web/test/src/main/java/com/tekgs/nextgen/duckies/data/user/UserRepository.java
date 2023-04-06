package com.tekgs.nextgen.duckies.data.user;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    public static final String USER_DATA_PATH = "../source/src/data/user.json";
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    
    public static UserRepository getInstance() {
        return new UserRepository();
    }
    
    public User query(UserCalibratable definition) {
        System.out.println("\n======================== gson.toJson(definition) ========================\n");
        System.out.println(gson.toJson(definition));
        System.out.println("\n======================== gson.toJson(definition) ========================\n");
        for (User candidate : query()) {
            System.out.println("\n======================== gson.toJson(candidate) ========================\n");
            System.out.println(gson.toJson(candidate));
            System.out.println("\n======================== gson.toJson(candidate) ========================\n");
            if (candidate.equivalent(definition)) {
                return candidate;
            }
        }
        return null;
    }
    
    public List<User> query() {
        List<User> userList = new ArrayList<>();
        try(BufferedReader reader = Files.newBufferedReader(Paths.get(USER_DATA_PATH))) {
            userList = new Gson().fromJson(reader, new TypeToken<List<User>>() {}.getType());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println(userList.get(0).getUsername());
        return userList;
    }
}
