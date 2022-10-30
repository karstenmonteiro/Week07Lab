package services;

import dataaccess.UserDB;
import java.util.List;
import models.Role;
import models.User;

/**
 *
 * @author Karsten Monteiro
 */
public class UserService {
    
    // get all
    public List<User> getAll() throws Exception {
        UserDB userDB = new UserDB();
        List<User> users = userDB.getAll();
        
        return users;
    }
    
    // get
    public User get(String email) throws Exception {
        UserDB userDB = new UserDB();
        User user = userDB.get(email);
        
        return user;
    }
    
    // insert
    public void insert(String email, String firstName, String lastName, String password, int roleId) throws Exception {
        // determine role name
        String roleName = "";
        if (roleId == 1) {
            roleName = "system admin";
        }
        else if (roleId == 2) {
            roleName = "regular user";
        }
        Role role = new Role(roleId, roleName);
        
        User user = new User(email, firstName, lastName, password, role);
        UserDB userDB = new UserDB();
        userDB.insert(user);
    }
    
    // edit
    public void edit(String email, String firstName, String lastName, String password, int roleId) throws Exception {

        // determine role name
        String roleName = "";
        if (roleId == 1) {
            roleName = "system admin";
        }
        else if (roleId == 2) {
            roleName = "regular user";
        }
        Role role = new Role(roleId, roleName);
        
        User user = new User(email, firstName, lastName, password, role);
        UserDB userDB = new UserDB();
        userDB.edit(user);
        
    }
    
    // delete
    public void delete(String email) throws Exception {
        
        User user = get(email);
        UserDB userDB = new UserDB();
        userDB.delete(user);
        
    }
    
}