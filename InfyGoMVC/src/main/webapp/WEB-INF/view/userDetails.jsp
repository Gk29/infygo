<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<body>
	<form:errors path="command.*"></form:errors>

	<h1>Find your details below</h1>
${message} <br>
Hi ${user.name} find yourdetails below :<br>
Email :${user.email} <br>
Phone :${user.phone }
City :${user.city} 

	

</body>
</html>