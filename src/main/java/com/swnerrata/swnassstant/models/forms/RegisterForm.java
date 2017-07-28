package com.swnerrata.swnassstant.models.forms;

import javax.validation.constraints.NotNull;

/**
 * Created by seanburk on 7/27/17.
 */
public class RegisterForm extends LoginForm {

    @NotNull(message = "Passwords to not match")
    private String verifyPassword;

    @NotNull
    private String gameMaster;

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

    public String getGameMaster() {
        return gameMaster;
    }

    public void setGameMaster(String gameMaster) {
        this.gameMaster = gameMaster;
    }
}
