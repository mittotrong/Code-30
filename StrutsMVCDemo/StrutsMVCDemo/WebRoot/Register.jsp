<%@ page language="java" pageEncoding="ISO-8859-1"%>
<%@page import="com.bean.PersonBean"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ page import="com.bean.HigestQulificationBean" %>
<%@ page import="java.util.ArrayList" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html lang="true">
  <head>
    <html:base />
    
    <title>Register</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	<link rel="stylesheet" href="css/flora.datepick.css" media="screen" />
	<script type="text/javascript" src="javascript/jquery-1.3.2.js"></script>
	<script type="text/javascript" src="javascript/jquery.datepick.js"></script>
	<script language="javascript">
	$( function() {
		$('#popupDatepicker').datepick( {
			//dateFormat : 'dd/mm/yy'
			dateFormat : 'yy/mm/dd'
		});
		$('#popupDatepicker').datepick();
	});
	</script>

  </head>
  
  <body>
   <html:form action="/personBean">
   <br/><br/><br/><br/><br/><br/><br/>
    	<table	width="541" align="center" >
    	<%
    		PersonBean personBean=(PersonBean)request.getAttribute("bean");
    		
    		String dob=null;
    		if(personBean!=null)
    		{
    			dob=personBean.getDateOfBirth();
    		}  
    	%>
    		<tr>
    			<td></td>
    			<td><%=(request.getAttribute("firstName")!=null?request.getAttribute("firstName"):"")%></td>
    			<td><%=(request.getAttribute("lastName")!=null?request.getAttribute("lastName"):"")  %></td>
    			<td></td>
    		</tr>
    		<tr>
    			<td width="134" align="right">User Name :-</td>
   			  	<td width="105"> <html:text  name="personBean" property="firstName"></html:text> </td>
   			  	<td width="137"> <html:text  name="personBean" property="lastName"></html:text> </td>
    			<td width="104">    			</td>
    		</tr>
    		
    		<tr>
    			<td width="134" align="right">Gender :-</td>
   			  	<td colspan="2"> <html:radio name="personBean" property="gender" value="MALE" />Male
				 <html:radio name="personBean" property="gender" value="FEMALE"/>Female
				 <%=(request.getAttribute("gender")!=null?request.getAttribute("gender"):"")  %>				 </td>
				 
   			  	<td width="104">   			  	</td>
    		</tr>
    		<tr>
    			<td width="134" align="right">Date Of Birth :-</td>
   			  	<td> <input type="text" name="dob" id="popupDatepicker" value="<%=(dob!=null)?dob:""  %>" > </td>
   			  	<td width="137"> <%=(request.getAttribute("dob")!=null?request.getAttribute("dob"):"")  %>  </td>
   			  	<td width="104"></td>
    		</tr>
    		
    		<tr>
    			<td width="134" valign="top" align="right">Address :-</td>
   			  	<td colspan="3" valign="top" > <html:textarea name="personBean" property="address" rows="4" ></html:textarea>
   			  	<%=(request.getAttribute("address")!=null?request.getAttribute("address"):"")  %>   			  	</td>
		  	</tr>
    		
    		<tr>
    			<td width="134"  align="right">Mobile No :-</td>
   			  	<td width="105"  > <html:text name="personBean" property="mobileNo"></html:text>  </td>
   			  	<td width="137"><%=(request.getAttribute("mobileNo")!=null?request.getAttribute("mobileNo"):"")  %>  </td>
    			<td width="104"></td>
    		</tr>
				<tr>
	    			<td width="134" align="right">Higest Qulification :-</td>
	    			
	    			<%
	    				ArrayList list=(ArrayList)application.getAttribute("listOfQulification");
	    			 %>
	   			  	<td>
	   			  			<html:select name="personBean" property="higestQulification">
	   			  			<html:option value="--Select--">--Select--</html:option>
	   			  				<%
	   			  					if(list!=null||list.size()<0)
	   			  					{
		   			  					for(int i=0;i<list.size();i++)
		   			  					{
		   			  						HigestQulificationBean bean=(HigestQulificationBean)list.get(i);
		   			  						%>
		   			  							<html:option value="<%=bean.getQulificationId() %>"><%=bean.getQulificationName()%></html:option>
		   			  						<%		
		   			  					}
		   			  				}
	   			  				 %>
	   			  			</html:select>	   			  	</td>
	   			  	<td colspan="2"><%=(request.getAttribute("hq")!=null?request.getAttribute("hq"):"")  %>  </td>
   			  	</tr>    		
	    		
	    		<tr>
    			<td width="134"  align="right"></td>
   			  	<td width="105"  > <html:submit value="    OK   " ></html:submit>  </td>
   			  	<td width="137">  </td>
    			<td width="104"></td>
    		</tr>
   	 </table>
    	
  </html:form>
  </body>
</html:html>
