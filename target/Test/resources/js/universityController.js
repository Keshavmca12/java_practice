var universityAPP=angular.module("universityAPP",[]);

universityAPP.controller("universityController",function($scope,$http){
	
$scope.university={};
$scope.submitUniversityDetails=function(data){
	console.log("data",data);
	$http({
		url:'/Test/submitUniDetails', 
		method: "post",
		params: {data: data}
	}).then(function(response){
		console.log("reponse",response.data);
	});;
};
  
	
});