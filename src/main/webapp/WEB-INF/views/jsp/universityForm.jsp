<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="universityAPP">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>University Form</title>
 <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
</head>
<body ng-controller="universityController">
<div class="container">
<h1>University details</h1><br>
  <!-- <form role="form"> -->
    <div class="form-group">
      <label for="usr">Name:</label>
      <input type="text" class="form-control" id="usr" ng-model="university.name" required>
    </div>
    <div class="form-group">
      <label for="pwd">Location:</label>
      <input type="text" class="form-control" id="pwd" ng-model="university.location" required>
    </div>
     <button class="btn btn-primary" ng-click="submitUniversityDetails(university)">Submit</button>
  <!-- </form> -->
</div>

<button ng-click="showCollegeForm()" class="btn btn-primary">Add college</button>
<div ng-if="addCollege" ng-include="'resources/views/College.html'"></div>
<script
		src="https://ajax.googleapis.com/ajax/libs/angularjs/1.3.14/angular.min.js"></script>
	<script type="text/javascript" src="resources/js/universityController.js"></script>
</body>
</html>