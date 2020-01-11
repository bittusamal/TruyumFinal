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
		<div class="home">truyum</div>
		<img src="image/truyum-logo-light.png"> <a href="ShowCart">Cart</a> <a href="ShowMenuItemListCustomer">Menu</a>
	</div>
	<h1>Cart</h1>
	

	<table style="width: 100%" id="tableID">
			<c:if test="${deleteCartStatus}">
		<div>
			<h2 class="success-message">Items remove from the cart successfully</h2> 
		</div>
	</c:if>
		<tr>
			<th><h4>Name</h4></th>
			<th><h4>Free Delivery</h4></th>
			<th class="currency"><h4>Price</h4></th>
			<th>Category</th>
			<th>Action</th>
		</tr>
		<c:forEach items="${cart.menuList}" var="menuItem">
		<tr>
		
			
					<td>${menuItem.name}</td>
					<td>
					<c:if test="${menuItem.freeDelivery}">Yes</c:if>
					<c:if test="${!menuItem.freeDelivery}">No</c:if>
					</td>
					<td class="currency">Rs.<fmt:formatNumber value="${menuItem.price}" pattern="#,##,##,##,###.00" />
					</td>
					<td>${menuItem.category}</td>
					
					<td><a href="RemoveCart?id=${menuItem.id}">Delete</a></td>
			
	
	
			</tr>
				</c:forEach>
		<tr>
			<td></td>
			<td class="total">Total</td>
			<td class="total">Rs.<fmt:formatNumber value="${cart.total}"
					pattern="#,##,##,##,###.00" />
			</td>
			<td></td>
		</tr>
	</table>
	<div class="footer">
		<h3>Copyright@2019</h3>
	</div>


</body>
</html>