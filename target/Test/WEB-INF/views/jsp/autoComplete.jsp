<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="autoComplete">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>autoComplete</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.3.14/angular.min.js"></script>
</head>
<body ng-controller="autoCompleteCtrl">
	<h1>now play with auto complete :</h1>
	<form action="/displayData">
		Name :: <input type="text" name="name" ng-model="user.name" /> <br>

		<br> Country :: <input type="text" name="country"
			ng-model="country"  ng-change="getContainingTag(country)" ><br> <br> 
			<!-- <input type="submit"  value="click here" /> -->
				<input type="button"  ng-click="submitForm()" value="click here" />
	</form>
	
	<h2>Tags :::::</h2><br>
	<span ng-repeat="tag in tags.filter track by $index" ng-click="assignId(tag)">{{$index+1}}.{{tag.tagName}} <br></span>

	<script type="text/javascript" src="resources/js/autoComplete.js"></script>
</body>
</html>