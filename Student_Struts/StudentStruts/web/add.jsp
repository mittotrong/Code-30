<%-- 
    Document   : add
    Created on : Apr 21, 2015, 12:36:36 AM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="html" uri="/WEB-INF/struts-html.tld" %>
<!DOCTYPE html>
<html style="background-color: bisque">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Student</title>
    </head>
    <body>
    <center>
        <h1>Add Student Information !</h1>
        <html:form action="save.do" method="POST">
            <table border="1" cellspacing="2" cellpadding="2">
                 <tr>
                    <td>Student Name</td>
                    <td>
                        <html:text property="name"  value=""/>
                    </td>
                </tr>
                 <tr>
                    <td>Age</td>
                    <td>
                        <html:text property="age" value=""/>
                    </td>
                </tr>
                 <tr>
                    <td>Email</td>
                    <td>
                        <html:text property="email" value=""/>
                    </td>
                </tr>
                 <tr>
                    <td>Address</td>
                    <td>
                        <html:text property="address" value=""/>
                    </td>
                </tr>
                 <tr>
                    <td>Phone</td>
                    <td>
                        <html:text property="phone" value="" />
                    </td>
                </tr>
                 <tr>
                    <td>
                        <html:submit value="Save Student"/>
                    </td>
                    <td><html:link action="list" > Back </html:link></td>
                   
                </tr>
            </table>
        </html:form>
    </center>
</body>
</html>
