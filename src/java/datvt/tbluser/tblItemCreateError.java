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
public class tblItemCreateError {
    private String UsernameLengError;
    private String PasswordLengError;
    private String ConfirmNotMatched;
    private String FullnameLengError;
    private String UsernameIsExisted;

    public tblItemCreateError() {
    }

    public tblItemCreateError(String UsernameLengError, String PasswordLengError, String ConfirmNotMatched, String FullnameLengError, String UsernameIsExisted) {
        this.UsernameLengError = UsernameLengError;
        this.PasswordLengError = PasswordLengError;
        this.ConfirmNotMatched = ConfirmNotMatched;
        this.FullnameLengError = FullnameLengError;
        this.UsernameIsExisted = UsernameIsExisted;
    }

    /**
     * @return the UsernameLengError
     */
    public String getUsernameLengError() {
        return UsernameLengError;
    }

    /**
     * @param UsernameLengError the UsernameLengError to set
     */
    public void setUsernameLengError(String UsernameLengError) {
        this.UsernameLengError = UsernameLengError;
    }

    /**
     * @return the PasswordLengError
     */
    public String getPasswordLengError() {
        return PasswordLengError;
    }

    /**
     * @param PasswordLengError the PasswordLengError to set
     */
    public void setPasswordLengError(String PasswordLengError) {
        this.PasswordLengError = PasswordLengError;
    }

    /**
     * @return the ConfirmNotMatched
     */
    public String getConfirmNotMatched() {
        return ConfirmNotMatched;
    }

    /**
     * @param ConfirmNotMatched the ConfirmNotMatched to set
     */
    public void setConfirmNotMatched(String ConfirmNotMatched) {
        this.ConfirmNotMatched = ConfirmNotMatched;
    }

    /**
     * @return the FullnameLengError
     */
    public String getFullnameLengError() {
        return FullnameLengError;
    }

    /**
     * @param FullnameLengError the FullnameLengError to set
     */
    public void setFullnameLengError(String FullnameLengError) {
        this.FullnameLengError = FullnameLengError;
    }

    /**
     * @return the UsernameIsExisted
     */
    public String getUsernameIsExisted() {
        return UsernameIsExisted;
    }

    /**
     * @param UsernameIsExisted the UsernameIsExisted to set
     */
    public void setUsernameIsExisted(String UsernameIsExisted) {
        this.UsernameIsExisted = UsernameIsExisted;
    }
    
}
