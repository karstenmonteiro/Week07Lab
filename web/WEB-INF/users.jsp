<%-- 
    Document   : users
    Created on : 17-Oct-2022, 4:50:48 PM
    Author     : Karsten Monteiro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manage Users</title>
    </head>
    <body>
        <h1>Manage Users</h1>
        <p>
            <c:if test="${message eq 'error'}">Sorry, something went wrong.</c:if>
        </p>
        
        <table style="border: 1px solid black">
            <tr style="border: 1px solid black">
                <th style="border: 1px solid black">Email</th>
                <th style="border: 1px solid black">First Name</th>
                <th style="border: 1px solid black">Last Name</th>
                <th style="border: 1px solid black">Role</th>
                <th style="border: 1px solid black"></th>
                <th style="border: 1px solid black"></th>
            </tr>
            <c:forEach items="${users}" var="user">
                <tr style="border: 1px solid black">
                    <td style="border: 1px solid black">${user.email}</td>
                    <td style="border: 1px solid black">${user.firstName}</td>
                    <td style="border: 1px solid black">${user.lastName}</td>
                    <td style="border: 1px solid black">${user.role.getRoleName()}</td>
                    <td style="border: 1px solid black"><a href="user?email=${user.email}&action=edit" name="edit">Edit</a></td>
                    <input type="hidden" name="action" value="delete">
                    <td style="border: 1px solid black"><a href="user?email=${user.email}&action=delete" name="delete">Delete</a></td>
                </tr>
            </c:forEach>
        </table>
        <c:if test="${editUser eq null}">
            <h2>Add User</h2>
            <form action="user" method="post">
                Email: <input type="text" name="email"><br>
                First Name: <input type="text" name="firstname"><br>
                Last Name: <input type="text" name="lastname"><br>
                Password: <input type="password" name="password"><br>
                Role: <select name="rolename">
                        <option>system admin</option>
                        <option>regular user</option>
                      </select><br>
                <input type="hidden" name="action" value="insert">
                <input type="submit" value="Add user">
            </form>
        </c:if>
        <c:if test="${editUser ne null}">
            <h2>Edit User</h2>
            <form action="" method="post">
                Email: ${editUser.email}<br>
                First Name: <input type="text" name="firstname"><br>
                Last Name: <input type="text" name="lastname"><br>
                Password: <input type="password" name="password"><br>
                Role: <select name="rolename">
                        <option>system admin</option>
                        <option>regular user</option>
                      </select><br>
                <input type="hidden" name="action" value="edit">
                <input type="submit" value="Update">
                <a href="/"><input type="button" value="Cancel"></a>
            </form>
        </c:if>
    </body>
</html>
