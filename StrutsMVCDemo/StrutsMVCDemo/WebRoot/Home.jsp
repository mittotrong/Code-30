<%@ page language="java" pageEncoding="ISO-8859-1"%>


<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html lang="true">
  <head>
    <html:base />
    
    <title>Home</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
		window.history.forward();
		function noBack()
		{
			window.history.forward();
		}
	</script>
  </head>
  
  <body onload="noBack();"  >
    <html:form action="/loginBean">
    	
    	<table	width="500" align="center" >
    		<tr>
    			<td width="180" align="right">User Name :-</td>
   			  <td width="133"> <html:text  name="loginBean" property="userName"></html:text> </td>
    			<td width="171"><%=(request.getAttribute("uName")!=null?request.getAttribute("uName"):"")%></td>
    		</tr>
    		<tr>
    			<td align="right">Password :-</td>
    			<td> <html:password name="loginBean" property="password"></html:password> </td>
    			<td><%=(request.getAttribute("passwd")!=null?request.getAttribute("passwd"):"")%></td>
    		</tr>
    		
    		<tr>
    			<td ></td>
    			<td> <html:submit value="Login" ></html:submit> </td>
    			<td></td>
    		</tr>
    		<tr>
			<td colspan="3"> <div align="center"><%=(request.getAttribute("invaidPasswd")!=null?request.getAttribute("invaidPasswd"):"")%> </div></td>
   			</tr>
    	</table>
    	
    </html:form>
  </body>
</html:html>
