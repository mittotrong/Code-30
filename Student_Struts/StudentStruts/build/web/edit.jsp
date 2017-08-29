<%-- 
    Document   : edit
    Created on : Apr 21, 2015, 1:07:49 AM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="html" uri="/WEB-INF/struts-html.tld" %>
<%@taglib prefix="logic" uri="/WEB-INF/struts-logic.tld" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Student </title>
    </head>
    <body>
    <center>
        <h1>Update Student Information !</h1>
        <html:form action="update.do" method="POST">
            <table border="1" cellspacing="2" cellpadding="2">
                <logic:iterate id="l" collection="${listEdit}">
                    <tr>
                        <td>Student ID</td>
                        <td>
                            <html:text property="id" name="l" readonly="true"/>
                        </td>
                    </tr>
                    <tr>
                        <td>Student Name</td>
                        <td>
                            <html:text property="name" name="l" />
                        </td>
                    </tr>
                    <tr>
                        <td>Age</td>
                        <td>
                            <html:text property="age" name="l"/>
                        </td>
                    </tr>
                    <tr>
                        <td>Email</td>
                        <td>
                            <html:text property="email" name="l" />
                        </td>
                    </tr>
                    <tr>
                        <td>Address</td>
                        <td>
                            <html:text property="address" name="l" />
                        </td>
                    </tr>
                    <tr>
                        <td>Phone</td>
                        <td>
                            <html:text property="phone" name="l"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <html:submit value="Update Student"/>
                        </td>
                        <td><html:link action="list" > Back </html:link></td>
               
                    </tr>
                </logic:iterate>
            </table>
        </html:form>
    </center>
</body>
</html>
