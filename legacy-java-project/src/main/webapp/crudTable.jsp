<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="java.util.List, my.model.Product"%>

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
                    <div class="col-sm-2" style="text-align:right">
                        <a href="/legacy-java-project/insertProduct.jsp">
                        	<button type="button" class="btn btn-info"><i class="fa fa-plus"></i> Add New</button>
                        </a>
                    </div>
                </div>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Description</th>
                        <th>Price</th>
                      	<th>Quantity</th>
                     	<th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach items="${products}" var="product">
					<tr>
                        <td>${product.id}</td>
                        <td>${product.name}</td>
                        <td>${product.description}</td>
                        <td><fmt:formatNumber type="CURRENCY"  value="${product.price}" /></td>
                      	<td>${product.quantity}</td>
                        <td>
                          	<a href="/legacy-java-project//ProductShow?id=${product.id}&name=${product.name}&description=${product.description}&price=${product.price}&quantity=${product.quantity}"><i class="fa fa-pencil"></i>  </a>
                            <a href="/legacy-java-project/productDelete?id=${product.id}"><i class="fa fa-trash">  </i></a>
                        </td>
                    </tr>	
			</c:forEach>
                </tbody>
            </table>
</div>     

</body></html>