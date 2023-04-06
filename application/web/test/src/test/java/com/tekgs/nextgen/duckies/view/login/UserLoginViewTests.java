package com.tekgs.nextgen.duckies.view.login;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tekgs.nextgen.duckies.data.user.User;
import com.tekgs.nextgen.duckies.data.user.UserDefinition;
import com.tekgs.nextgen.duckies.data.user.UserProvider;
import org.softwareonpurpose.softwaregauntlet.GauntletTest;
import org.testng.annotations.Test;

@Test(groups = {GauntletTest.Application.DUCKIES, GauntletTest.View.AUTHENTICATION})
public class UserLoginViewTests extends GauntletTest {
    @Test(groups = {TestSuite.SMOKE})
    public void smoke() {
        UserLoginViewExpected expected = UserLoginViewExpected.getInstance();
        UserLoginView actual = UserLoginView.directNav();
        then(UserLoginViewCalibrator.getInstance(expected, actual));
    }
    
    @Test(groups = {TestSuite.DEBUG})
    public void login_success() {
        UserDefinition userDefinition = UserDefinition.getInstance().withUsername("username").withPassword("password");
        User user = UserProvider.getInstance().get(userDefinition);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        System.out.println(gson.toJson(user));
        UserLoginViewExpected expected = UserLoginViewExpected.getInstance(user);
        UserLoginView actual = UserLoginView.directNav().login(userDefinition);
        then(UserLoginViewCalibrator.getInstance(expected, actual));
    }
    
    @Test(groups = {TestSuite.DEBUG})
    public void login_failure() {
        UserDefinition userDefinition = UserDefinition.getInstance().withUsername("username").withPassword("lskdjflkj");
        User user = UserProvider.getInstance().get(userDefinition);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        System.out.println(gson.toJson(user));
        UserLoginViewExpected expected = UserLoginViewExpected.getInstance(user);
        UserLoginView actual = UserLoginView.directNav().login(userDefinition);
        then(UserLoginViewCalibrator.getInstance(expected, actual));
    }
}
