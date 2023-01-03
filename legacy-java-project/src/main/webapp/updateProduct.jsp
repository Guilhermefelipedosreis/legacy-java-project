<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="java.util.List, my.model.Product, my.servlet.ProductInsertServlet, my.servlet.ProductUpdateServlet"%>
<c:url value="productUpdate" var="linkProductUpdate"/>

<%
Product product = (Product)request.getAttribute("product");
%>


<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<title>Product</title>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">

</head>
<body>
<div class="container-lg">
	<div class="row">
	    <div class="col-sm-10"><h2><b>Products</b></h2></div>
	    <div class="col-sm-2" style="text-align:right"></div>
	</div>
	<form action="${linkProductUpdate}" method="post" id="form1">
	<table class="table table-bordered">
	    <thead>
	        <tr>
	            <th>Name</th>
	            <th>Description</th>
	            <th>Price</th>
	          	<th>Quantity</th>
	         	<th>Actions</th>
	        </tr>
	    </thead>
	    <tbody>
	    	<tr>
	            <td><input type="hidden" name="id" value="${product.id}"/>
	            	<input type="text" name="name" value="${product.name}"/></td>
	            <td><input type="text" name="description" value="${product.description}"/></td>
	            <td><input type="text" name="price" value="<fmt:formatNumber minFractionDigits="2" maxFractionDigits="2" value="${product.price}"/>"/></td>
	            <td><input type="text" name="quantity"value="${product.quantity}"/></td>
	          	<td><button type="submit" form="form1" class="btn btn-info">Update</button></td>
	        </tr>	
	    </tbody>
	</table>
	</form>
</div>     
</body>
</html>