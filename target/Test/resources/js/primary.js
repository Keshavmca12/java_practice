dynamicContentApp.controller("primaryController",function($scope,$http,$sce,$compile){
	alert("inside primary js controller");
	$http.get('/Test/getListContent').then(function(response){
		console.log("reponse",response.data);
//		$scope.primaryData=$sce.trustAsHtml(response.data);
		$scope.ListData=response.data;	
	});	
});
alert("loading primay js");