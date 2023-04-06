package com.tekgs.nextgen.duckies.view.login;

import com.softwareonpurpose.uinavigator.UiElement;
import com.softwareonpurpose.uinavigator.UiLocatorType;
import com.softwareonpurpose.uinavigator.UiView;
import com.tekgs.nextgen.duckies.data.user.UserDefinition;
import com.tekgs.nextgen.duckies.view.DuckiesView;

public class UserLoginView extends DuckiesView implements UserLoginViewCalibratable {
    public static final String RELATIVE_URL = "login";
    public static final String DESCRIPTION = "login";
    public static final String LOCATOR_TYPE = UiLocatorType.ID;
    public static final String LOCATOR_VALUE = "login";
    
    public UserLoginView() {
        super(RELATIVE_URL, UiElement.getInstance(DESCRIPTION, LOCATOR_TYPE, LOCATOR_VALUE));
    }
    
    public static UserLoginView directNav() {
        new UserLoginView().load();
        return UiView.expect(UserLoginView.class);
    }
    
    @Override
    public String getTitle() {
        return getTitleElement().getText();
    }
    
    @Override
    public String getPasswordField() {
        return getPasswordFieldElement().getText();
    }
    
    @Override
    public String getUsernameField() {
        return getUsernameFieldElement().getText();
    }
    
    @Override
    public String getSubmitButton() {
        return getSubmitButtonElement().getText();
    }
    
    
    @Override
    public String getLoginStatusMessage() {
        return this.getLoginStatusMessageElement().getText();
    }
    
    public UserLoginView login(UserDefinition userDefinition) {
        this.getUsernameFieldElement().set(userDefinition.getUsername());
        this.getPasswordFieldElement().set(userDefinition.getPassword());
        this.getSubmitButtonElement().click();
        return UiView.expect(UserLoginView.class);
    }
    
    private UiElement getLoginStatusMessageElement() {
        return UiElement.getInstance("desc", UiLocatorType.ID, "login-status-message", this.getElement());
    }
    
    
    private UiElement getSubmitButtonElement() {
        return UiElement.getInstance("submit button", UiLocatorType.ID, "submit-button", this.getElement());
    }
    
    private UiElement getUsernameFieldElement() {
        return UiElement.getInstance("Username Field", UiLocatorType.NAME, "username-field", this.getElement());
    }
    
    private UiElement getPasswordFieldElement() {
        return UiElement.getInstance("Password Field", UiLocatorType.NAME, "password-field", this.getElement());
    }
    
    private UiElement getTitleElement() {
        return UiElement.getInstance("Login Title", UiLocatorType.ID, "login-title", this.getElement());
    }
}
