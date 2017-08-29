<%-- 
    Document   : ShowList
    Created on : Apr 21, 2015, 12:10:41 AM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@taglib  uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<!DOCTYPE html>
<html style="background-color: bisque">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student Information</title>
    </head>
    <body>
    <center>
        <h1>Student Information</h1>
        <table border="1" cellspacing="2" cellpadding="2" >
                <tr>
                    <th>Student ID</th>
                    <th>Student Name</th>
                    <th>Age</th>
                    <th>Email</th>
                    <th>Address</th>
                    <th>Phone</th>
                    <th>Edit</th>
                    <th>Delete</th>
                </tr>
                <logic:iterate id="l" collection="${list}" >
                <tr>
                    <td>${l.id}</td>
                    <td>${l.name}</td>
                    <td>${l.age}</td>
                    <td>${l.email}</td>
                    <td>${l.address}</td>
                    <td>${l.phone}</td>
                    <td>
                        <html:link action="edit?id=${l.id}" > Edit </html:link>
                    </td>
                    <td>
                    <html:link action="delete?id=${l.id}"  onclick="return confirm('Are you sure ?')"> Delete </html:link>
                    </td>
                </tr>
                </logic:iterate>
        </table>
        <html:link action="add" >Add New Student</html:link>

    </center>
    </body>
</html>
