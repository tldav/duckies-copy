package com.tekgs.nextgen.duckies.view.login;

import com.softwareonpurpose.calibrator4test.Calibrator;

public class UserLoginViewCalibrator extends Calibrator {
    private static final String DESCRIPTION = "'User-Authentication' View";
    private final UserLoginViewExpected expected;

    private final UserLoginView actual;
    private UserLoginViewCalibrator(UserLoginViewExpected expected, UserLoginView actual) {
        super(DESCRIPTION, expected, actual);
        this.expected = expected;
        this.actual = actual;
    }

    public static UserLoginViewCalibrator getInstance(UserLoginViewExpected expected, UserLoginView actual) {
        return new UserLoginViewCalibrator(expected, actual);
    }


    @Override
    protected void executeVerifications() {
        verify("login", expected.getTitle(), actual.getTitle());
        verify("submit-button", expected.getSubmitButton(), actual.getSubmitButton());
        verify("'Login Status' message", expected.getLoginStatusMessage(), actual.getLoginStatusMessage());
    }
}
