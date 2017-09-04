package org.launchcode.models;

import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class User {

    //fields
    @NotNull(message = "Username may only contain alpha characters")
    @Size(min=5, max=30, message = "Username is required and must be between 5 and 30 characters")
    private String username;

    @Email(message="Not a valid email")
    private String email;

    @NotNull
    @Size(min=5, max=20, message = "Password is required and must be between 5 and 20 characters")
    private String password;

    @NotNull(message = "Passwords do not match")
    @Size(min=1, max=20, message = "Password verification is required and passwords must match")
    private String verify;

    private int userId;
    private static int nextId = 1;

    //constructor
    public User(String username, String email, String password, String verify) {
        this();
        this.username = username;
        this.email = email;
        this.password = password;
        this.verify = verify;
    }

    //Don't forget password hashing and validation! Where does this go?! Not sure
    public User() {
        userId = nextId;
        nextId ++;
    }


    //getters + setters

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() { return username;
    }

    public void setUsername(String username) {
        this.username = username;
        checkUsername();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {

        this.password = password;
        checkPassword();
    }

    public String getVerify() {
        return verify;
    }

    public void setVerify(String verify) {

        this.verify = verify;
        checkPassword();
    }

    private void checkPassword() {
        if (password != null && verify != null
                && !password.equals(verify)) {
            verify = null;
        }
    }

    private String checkUsername() {
        char[] charArr = username.toCharArray();
        for (char eachChar : charArr) {
            if (!Character.isLetter(eachChar)) {
                username = null;
            }
        }
        return username;
    }
}
