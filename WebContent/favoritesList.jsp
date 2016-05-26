<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC>
<html>
<head>
<link rel="stylesheet" type="text/css" href="favoriteStyleSheet.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Favorite List</title>

<style type="text/css">
body {
	 margin-left: 0px;
	 margin-top: 0px;
	 margin-right: 0px;
	 margin-bottom: 0px;
}
</style>
</head>


<body>
	<div id="Header">
		<img id="header" src="Grammy/head.jpg"/>
	</div>
	<div id="wrapper">
		<form>
			<c:forEach var="favorite" items="${list}">
				<a href="http://52.89.184.150:8080/Music/Year.do?year=${favorite.year}">
					<img src="Grammy/${favorite.albumLink}" />
				</a>
			</c:forEach>
		</form>
	</div>
</body>
</html>
