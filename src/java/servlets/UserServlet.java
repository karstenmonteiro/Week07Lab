package servlets;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.User;
import services.UserService;

/**
 *
 * @author Karsten Monteiro
 */
public class UserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
//        HttpSession session = request.getSession();
        UserService us = new UserService();
        
        // get all
        try {
            List<User> users = us.getAll();
            request.setAttribute("users", users);
        }
        catch (Exception ex) {
            Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("message", "error");
        }
        
        // display edit form
        String action = request.getParameter("action");
        if (action != null && action.equals("edit")) {
            try {
                String email = request.getParameter("email");
                User user = us.get(email);
                request.setAttribute("editUser", user);
            } catch (Exception ex) {
                Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if ("delete".equals(action)) {
            try {
                String email = request.getParameter("email");
                us.delete(email);
            } catch (Exception ex) {
                Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        getServletContext().getRequestDispatcher("/WEB-INF/users.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        UserService us = new UserService();

        String action = request.getParameter("action");
        String email = request.getParameter("email");
        String firstName = request.getParameter("firstname");
        String lastName = request.getParameter("lastname");
        String password = request.getParameter("password");
        String roleName = request.getParameter("rolename");
        int roleId = 0;

        // determine role id
        if (roleName.equals("system admin")) {
            roleId = 1;
        }
        else if (roleName.equals("regular user")) {
            roleId = 2;
        }

        try {
            switch (action) {
                case "insert":
                    us.insert(email, firstName, lastName, password, roleId);
                    break;
                case "edit":
                    us.edit(email, firstName, lastName, password, roleId);
                    /** ADD SECURITY FOR PASSWORD */
                    
//                    if (password.equals(request.getParameter("editpassword"))) {
//                        us.edit(email, firstName, lastName, password, roleId);
//                    }
//                    else {
//                        request.setAttribute("invalidPass", "Incorrect password.<br>");
//                    }
                    break;
                case "delete":
                    us.delete(email);
            }
        }
        catch (Exception ex) {
            Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            List<User> users = us.getAll();
            request.setAttribute("users", users);
        }
        catch (Exception ex) {
            Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("message", "error");
        }
        
        getServletContext().getRequestDispatcher("/WEB-INF/users.jsp").forward(request, response);
    }

}
