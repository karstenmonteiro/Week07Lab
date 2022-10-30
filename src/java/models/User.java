package models;

import java.io.Serializable;

/**
 *
 * @author Karsten Monteiro
 */
public class User implements Serializable {
    
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private Role role;
    
    /* constructors */
    public User() {
        
    }
    
    public User(String email, String firstName, String lastName, String password, Role role) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.role = role;
    }
    
    /* getters and setters */
    // email
    public String getEmail() {
        return email;
    }
    public void setEmail(String newEmail) {
        this.email = newEmail;
    }
    
    // firstName
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String newFirstName) {
        this.firstName = newFirstName;
    }
    
    // lastName
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String newLastName) {
        this.lastName = newLastName;
    }
    
    // password
    public String getPassword() {
        return password;
    }
    public void setPassword(String newPassword) {
        this.password = newPassword;
    }
    
    // role
    public Role getRole() {
        return role;
    }
    public void setRole(Role newRole) {
        this.role = newRole;
    }
    
}