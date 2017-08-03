package com.swnerrata.swnassstant.models.forms;

import javax.validation.constraints.NotNull;

/**
 * Created by seanburk on 7/27/17.
 */
public class RegisterForm extends LoginForm {

    @NotNull(message = "Passwords to not match")
    private String verifyPassword;

    private boolean gameMaster;

    @Override
    public void setPassword(String password) {
        super.setPassword(password);
        checkPasswordForRegistration();
    }

    public String getVerifyPassword() {
        return verifyPassword;
    }

    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
        checkPasswordForRegistration();
    }

    private void checkPasswordForRegistration() {
        if (!getPassword().equals(verifyPassword)) {
            verifyPassword = null;
        }
    }

    public boolean isGameMaster() {
        return gameMaster;
    }

    public void setGameMaster(boolean gameMaster) {
        this.gameMaster = gameMaster;
    }
}
