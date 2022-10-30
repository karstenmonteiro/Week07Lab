package models;

import java.io.Serializable;


/**
 *
 * @author Karsten Monteiro
 */
public class Role implements Serializable {
    
    private int roleId;
    private String roleName;
    
    /* constructors */
    public Role() {
        
    }
    
    public Role(int roleId, String roleName) {
        this.roleId = roleId;
        this.roleName = roleName;
    }
    
    /* getters and setters */
    //  roleId
    public int getRoleId() {
        return roleId;
    }
    public void setRoleId(int newRoleId) {
        this.roleId = newRoleId;
    }
    
    // roleName
    public String getRoleName() {
        return roleName;
    }
    public void setRoleName(String newRoleName) {
        this.roleName = newRoleName;
    }
    
}