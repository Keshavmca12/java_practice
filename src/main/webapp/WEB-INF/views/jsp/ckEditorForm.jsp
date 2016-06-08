<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="ckAPP">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>University Form</title>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
</head>
<body ng-controller="ckController">
	<div class="container">
		<h1>Product details</h1>
		<br>
		<!-- <form role="form"> -->
		<div class="form-group">
			<label for="usr">Name:</label> <input type="text"
				class="form-control" id="usr" ng-model="product.name" required>
		</div>
		<div class="form-group">
			<label for="pwd">Address:</label>
			<textarea ng-model="product.address" ck-editor></textarea>
		</div>
		<button class="btn btn-primary" ng-click="submitProdDetails(product)">Submit</button>
		<!-- </form> -->
	</div>
	<strong> Product details :: name : {{prod.name}} and address
		<span ng-bind-html="prod.address"></span></strong>
	<script src="//cdn.ckeditor.com/4.5.6/standard/ckeditor.js"></script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/angularjs/1.3.14/angular.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.4.3/angular-sanitize.min.js"></script>
	<script type="text/javascript" src="resources/js/ckController.js"></script>
</body>
</html>