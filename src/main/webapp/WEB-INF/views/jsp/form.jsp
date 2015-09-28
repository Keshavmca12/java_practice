<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="formApp">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<title>Enter details</title>
</head>
<body class="container" ng-controller="formController">

	<h3>SELECT DETAILS ::</h3>
	<br>


	<%-- <form:form method="POST" commandName="colour">
		<table>
			<tr>
				<td>Please select:</td>
				<td><form:select path="colourName">
					  <form:option value="" label="...." />
					  <form:options items="${colours}" />
				       </form:select>
                                </td>
				<td><form:errors path="colourName" cssStyle="color: #ff0000;" /></td>
			</tr>
			<tr>
				<td><input type="submit" name="submit" value="Submit"></td>
			</tr>
			<tr>
		</table>
	</form:form> --%>

	<form action="/displayDetails" class="form">
		Name :: <input type="text" name="name" /><br> Age :: <input
			type="text" name="age" /><br> Select your country :: <select
			name="country" ng-change="getPrimarydetails(activeData)"
			ng-model="activeData">
			<option ng-selected="true">{{activeData}}</option>
			<option ng-repeat="data in basicData" id="basicOption"
				n-show="data.subject!='Hotels'">{{data.subject}}</option>
		</select><br> Select your city :: <select name="city"
			ng-model="activeBasic">
			<option ng-selected="true">{{activeBasic}}</option>
			<option ng-repeat="data in primaryData">{{data}}</option>
		</select><br> 
		ngoptions:  <select ng-model="myColor" ng-options="data for data in basicData"></select>

	</form>
	<script
		src="https://ajax.googleapis.com/ajax/libs/angularjs/1.3.14/angular.min.js"></script>
	<script type="text/javascript" src="resources/js/app.js"></script>
</body>
</html>