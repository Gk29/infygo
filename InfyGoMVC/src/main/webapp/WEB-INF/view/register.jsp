<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<body>
<form:errors path="command.*" ></form:errors>

	<h1>Enter your details below</h1>
 					<form action="registerUser" method="post" commndName="command">
					
					
					UserId   :<input type="text" name="userId" ><br/>
					Password :<input type="password" name="password"><br/>
					Name     :<input type="text" name="name"/><br/>
					City     :<input type="text" name="city"/><br/>
					Email    :<input type="email" name ="email"><br/>
					Phone    :<input type="text" name="phone"><br/>
					 <input type="submit" value="Submit" />
					</form>
					 
					
					<%-- <form action="registerUser"  method="post">
		             <input type="text" name="name"  /> 
		             <input type="submit" value="submit" />
	                 </form> --%>
					<div>
					${message}
					
					
					</div>			
						
</body>
</html>