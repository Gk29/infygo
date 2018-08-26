<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<body>

<form action="authenticateLogin" method="post" >
userName: <input type="text" name="userName"/>
<br>
password: <input type="password" name="password"/>
<input type="submit" value="Login"/>
</form>
</body>
</html>
