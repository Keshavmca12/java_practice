<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- <html ng-app="dynamicContentApp"> -->
<html ng-app="treeViewApp">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tree view</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link rel="stylesheet" href="resources/css/angular.treeview.css">
</head>
<body ng-controller="TreeViewCtrl" class="container">
	<h2>Tree view ::</h2>
	<br>
	
	 <div>
      <input type="button" value="TREE MODEL 1" data-ng-click="roleList = roleList1" /> <input type="button" value="TREE MODEL 2" data-ng-click="roleList = roleList2" />
    </div>

    <div style="margin:10px 0 30px 0; padding:10px; background-color:#EEEEEE; border-radius:5px; font:12px Tahoma;">
      <span><b>Selected Node</b> : {{currentNode.roleName}}</span>
    </div>

    <!--
      [TREE attribute]
      angular-treeview: the treeview directive
      tree-model : the tree model on $scope.
      node-id : each node's id
      node-label : each node's label
      node-children: each node's children
    -->
    
    <div
      data-angular-treeview="true"
      data-tree-id="tree"
      data-tree-model="roleList"
      data-node-id="roleId"
      data-node-label="roleName"
      data-node-children="children" >
    </div>
    
    <h1>Tree view from ajax data ::</h1>
    
     <div
      data-angular-treeview="true"
      data-tree-id="tree"
      data-tree-model="userTree"
      data-node-id="id"
      data-node-label="name"
      data-node-children="children" >
    </div>

	<script
		src="https://ajax.googleapis.com/ajax/libs/angularjs/1.3.14/angular.min.js"></script>
	<script type="text/javascript" src="resources/lib/angular.treeview.checkbox.js"></script>
	<script type="text/javascript" src="resources/js/TreeViewCtrl.js"></script>
</body>
</html>