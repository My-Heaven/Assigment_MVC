/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datvt.tbluser;

/**
 *
 * @author Tan DaT
 */
public class updateUserError {
    private String passwordLengError;

    public updateUserError() {
    }

    public updateUserError(String passwordLengError) {
        this.passwordLengError = passwordLengError;
    }

    /**
     * @return the passwordLengError
     */
    public String getPasswordLengError() {
        return passwordLengError;
    }

    /**
     * @param passwordLengError the passwordLengError to set
     */
    public void setPasswordLengError(String passwordLengError) {
        this.passwordLengError = passwordLengError;
    }
    
}
