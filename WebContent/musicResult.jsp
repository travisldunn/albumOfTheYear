<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC>
<html>
<head>


<link rel="stylesheet" type="text/css" href="musicresultStyleSheet.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="//fonts.googleapis.com/css?family=Coda+Caption" />
<title>MusicResult</title>
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

	<div id="Container">
		<div id="Header">
			<img id="header" src="Grammy/head.jpg" />
		</div>

		<div id="Menu">
			<form id="getyear" action="getYearList.do" method="POST">
				<select name="year">
					<c:forEach var="album" items="${albums}">
						<option value="${album.year}">${album.year}</option>
					</c:forEach>
				</select>
				<button id="pickayear" type="submit">Pick A New Year</button>
			</form>
			
			<form action="deleteFavorite.do" method="GET">
				
				<button id="tofavorite2" type="submit" name="input">
					Delete</button>
			</form>
			
			<form action="favorite.do" method="GET">
				<button id="tofavorite1" type="submit">Favorite</button>
			</form>
			
			<form id="favorite" action="goToFavorite.do" method="GET">
				<button type="submit">View Favorites</button>
			</form>
	</div>

		<div id="MainBody">
			<p id="bigyear">${bean.year}</p>
			<p id="smallyear">
				The Album of the Year for ${bean.year}: <br>
				${bean.albumName}<br> <br>By the Artist:<br> ${bean.name}
			</p>
			<img id="album" src="Grammy/${bean.albumLink}" />
			<br>
			<audio controls autoplay>
				<source src="Tunes/${bean.tune}" type="audio/mpeg">
			</audio>
			<form action="button.do" method="GET">
				<button class="changeyear1" type="submit" name="input"
					value="Previous">Previous</button>
				<button class="changeyear2" type="submit" name="input" value="Next">
					Next</button>
				<br>
			</form>
		</div>

		<div id="Sidebar">
			<iframe
				src="https://widgets.itunes.apple.com/
				widget.html?c=us&brc=FFFFFF&blc=FFFFFF&trc=FFFFFF&tlc=FFFFFF&d=&t
				=&m=music&e=album&w=250&h=300&ids=
		${bean.itunesLink}&wt=discovery&partnerId=&affiliate_id=&at=&ct="
				style="overflow-x: hidden; overflow-y: hidden; width: 250px; 
				height: 300px; border: 0px">
			</iframe>
		</div>
		<div id="Footer">
			<form action="comment.do" method="get">
				<h3>Leave A Comment</h3>
				<input type="text" name="comment" />
				<button type="submit">Submit</button>
				<c:forEach var="comment" items="${bean.comments}">
					<p>${comment}</p>
				</c:forEach>
			</form>

			<form action="deletebutton.do" method="GET">
				<button type="submit" name="input">Delete</button>
			</form>
		</div>
	</div>
</body>
</html>




