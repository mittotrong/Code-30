<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@ page import="com.bean.PersonBean" %>
<%@ page import="java.util.ArrayList" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Register Person List</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="css/default.css">
		<script type="text/javascript">
			function edit(id)
			{
				//this function is call when click on edit;
				//alert(id);
				//document.forms[0].action="./personSelect.do?pid="+id;
				//document.forms[0].submit();
			}
			function deletePerson()
			{
				window.history.forward();
			}
			function generatePDF()
			{
				
			}
		</script>
  </head>
  
  <body  >
  <form name="listOfPerson" method="post">
  	
      
			<display:table  name="personDetail" id="currentRowObject" defaultsort="5" pagesize="5" requestURI="./personList.do" >
				
				<display:setProperty name="paging.banner.placement" value="both"  />
					<display:column property="firstName" title="First Name" sortable="true"  />
					<display:column property="lastName" title="Last Name" sortable="true" />
					<display:column property="gender" title="Gender" sortable="true" />
					<display:column property="dateOfBirth" title="Birth Date" sortable="true" />
					<display:column property="address" title="Address"  sortable="true" />
			  		<display:column property="mobileNo" title="Mobile No"  sortable="true" />
			  		<display:column title="EDIT" sortable="true" style="text-align:center;" >
			  		<!-- 
			  			<a href="./personSelect.do?pid=<%=((PersonBean)currentRowObject).getPid()%>" onclick="javascript:edit()" >Edit</a>
			  		 -->
			  		 <!--
			  		 <a href="./personSelect.do?pid=<%=((PersonBean)currentRowObject).getPid()%>"> <img  src="icon/Edit.png"></a>
			  		 -->
			  		 <a href="./personSelect.do?pid=<%=((PersonBean)currentRowObject).getPid()%>"> <img onclick="javascript:edit()" src="icon/edit.png"></a>
			  		</display:column>
			  		<display:column title="DELETE" sortable="true" style="text-align:center;" >
			  			<a href="./personDelete.do?pid=<%=((PersonBean)currentRowObject).getPid()%>"> <img onclick="javascript:deletePerson()" src="icon/delete.png"></a>
			  		</display:column>
			  		<display:column title="PDF" sortable="true" style="text-align:center;" >
			  			<a href="./personPDF.do?pid=<%=((PersonBean)currentRowObject).getPid()%>" target="_blank" > <img onclick="javascript:generatePDF()"  src="icon/pdf.png"></a>
			  		</display:column>
			</display:table>
		
      
    
  </form>
  </body>
</html>
