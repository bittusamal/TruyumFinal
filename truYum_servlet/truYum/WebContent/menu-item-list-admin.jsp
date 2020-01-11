<%@ page language="java" isELIgnored="false"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="styles/style.css">
<script src="js/script.js"></script>
</head>
<body>
	<div class="topnav">
		<div class="home">
			<h3>truyum</h3>
		</div>
		<img src="image/truyum-logo-light.png"> <a href="http://localhost:8082/truYum/ShowMenuItemListAdmin">Menu</a>
	</div>
	<div class="page-title">MenuItem</div>
	<div>

		<table>
			<tr>
				<th><h4>Name</h4></th>
				<th><h4>Price</h4></th>
				<th><h4>Active</h4></th>
				<th><h4>Date of launch</h4></th>
				<th><h4>Category</h4></th>
				<th><h4>Free Delivery</h4></th>
				<th><h4>Action</h4></th>
			</tr>

			<c:forEach items="${menuItemList}" var="menuItem">

				<tr>
					<td>${menuItem.name}</td>
					<td class="currency">RS.<fmt:formatNumber value="${menuItem.price}" pattern="#,##,##,###.00"/></td>
					<td><c:if test="${menuItem.active}">Yes</c:if> <c:if
							test="${!menuItem.active}">No</c:if></td>
					<td><fmt:formatDate type="date" pattern="dd/MM/yyyy"
							value="${menuItem.dateOfLaunch}" /></td>
					<td>${menuItem.category}</td>
					<td><c:if test="${menuItem.freeDelivery }">Yes</c:if> <c:if
							test="${!menuItem.freeDelivery }">No</c:if></td>

					<td><a href="ShowEditMenuItem?id=${menuItem.id}">Edit</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>

	<div class="footer">
		<h3>Copyright@2019</h3>
	</div>

</body>
</html>