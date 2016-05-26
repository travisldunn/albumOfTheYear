<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC>
<html>
<head>
<link rel="stylesheet" type="text/css" href="getYearStyleSheet.css">
<title>Music</title>
</head>
<body>
	<img class="banner" src="Grammy/g.jpg" />
	<br>
	<div id="mainbody">
		<form action="getYearList.do" method="POST">
			<select name="year">
				<c:forEach var="album" items="${albums}">
					<option value="${album.year}">${album.year}</option>
				</c:forEach>
			</select>
			<button type="submit">Pick a Year</button>
		</form>
		</div>
		
		<div id="Footer"></div>
	
</body>
</html>