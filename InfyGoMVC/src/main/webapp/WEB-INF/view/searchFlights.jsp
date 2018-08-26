<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<body>


LOGIN SUCCESSFULL
<p>Hi ${userModel.name} , your loggedin succefully with userId ${userModel.userId } and password ${userModel.password} 

<br>

<%--<form:label path="destination">Destination</form:label>
 <form:select id="dlist" path="destination1" title="select destination">
<form:option label ="--select destination--" value=""></form:option>
<form:options items="${destinationList} }"/>
</form:select> --%>

</body></html>