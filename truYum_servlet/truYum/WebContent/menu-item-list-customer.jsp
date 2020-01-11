<%@ page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
		<div class="home">truyum</div>
		<img src="image/truyum-logo-light.png"> <a href="ShowCart">Cart</a> <a
			href="http://localhost:8082/truYum/ShowMenuItemListCustomer">Menu</a>

	</div>
	<!--<div class="page-title">MenuItem</div>  -->
	<c:if test="${addCartStatus}">
		<div class="success-message">Item Added to cart Successfully</div>
	</c:if>	
	<h1>Products</h1>
	<table style="width: 100%">
		<tr>
			<th>Name</th>
			<th>Free Delivery</th>
			<th>Price</th>
			<th>Category</th>
			<th>Action</th>
		</tr>
		
		<c:forEach items="${menuItemList}" var="menuItem">
			<tr>
				<td>${menuItem.name}</td>
				<td><c:if test="${menuItem.freeDelivery}">Yes</c:if> 
					<c:if test="${!menuItem.freeDelivery}">No</c:if></td>
				<td class="currency">RS.<fmt:formatNumber value="${menuItem.price}" pattern="#,##,##,###.00"/></td>
				<td>${menuItem.category}</td>
				<td><c:if test="${menuItem.active}">Yes</c:if> 
					<c:if test="${!menuItem.active}">No</c:if></td>
				<td><a href="AddToCart?id=${menuItem.id}">Add to Cart</a></td>
			</tr>
		
		</c:forEach>
	
	</table>
	
	<div class="footer">
		<h3>Copyright@2019</h3>
	</div>

</body>
</html>