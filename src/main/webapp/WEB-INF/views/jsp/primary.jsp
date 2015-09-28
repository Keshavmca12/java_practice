<!-- <script type="text/javascript">
var headID = document.getElementsByTagName("body")[0];         
var newScript = document.createElement("script");
newScript.type = "text/javascript";
newScript.src = "resources/js/primary.js";
headID.appendChild(newScript);
</script> -->
<script type="text/javascript">
dynamicContentApp.controller("primaryController",function($scope,$http,$sce){
	alert("Hhhh");
	$http.get('/Test/getListContent').then(function(response){
		console.log("reponse",response.data);
//		$scope.primaryData=$sce.trustAsHtml(response.data);
		$scope.ListData=response.data;	
	});	
});

</script> 
<div ng-controller="primaryController">


	this is primary html

	<h2>here we have text boxes and button</h2>
	<br>
	<button type="button" class="btn btn-primary" ng-click="shownName()">inside
		Basic</button>
	<br>
	<button type="button" class="btn btn-primary" ng-click="showAge()">inside
		Primary</button>
	<br> Name inside <input type="text" name="namein"
		ng-model="namein" id="nameinside" /> <br> Age indise :: <input
		type="text" name="agein" ng-model="agein" id="ageinside" /> <br>

	<br> Select your city :: <select name="city" >
	<span ng-repeat="data in ListData">
		<option ng-if="ListData.length>1" ng-repeat="data in ListData">{{data}}11</option>
		 <optgroup label="hello" ng-if="ListData.length<1">
         <option >{{data}}22</option>
		</optgroup>
		</span>
	</select> <br>
</div>
