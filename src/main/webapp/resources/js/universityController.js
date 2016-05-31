var universityAPP=angular.module("universityAPP",[]);

universityAPP.controller("universityController",function($scope,$http){
	
$scope.university={};
$scope.universityList=[];
$scope.college={};
$scope.addCollege=false;
$scope.submitUniversityDetails=function(data){
	console.log("data",data);
	$http({
		url:'/Test/submitUniDetails', 
		method: "post",
		data: data
	}).then(function(response){
		console.log("reponse",response.data);
		$scope.university={};
	});
};

$scope.showCollegeForm=function(){
	$scope.addCollege=!$scope.addCollege;
	if($scope.addCollege){
		getUniversityList();
	}
};
$scope.submitCollegeDetails=function(college){
	console.log("college",college);
	$http({
		url:'/Test/submitCollegeDetails', 
		method: "post",
		params: {data: college}
	}).then(function(response){
		console.log("reponse",response);
		$scope.college={};
	});
};
var getUniversityList=function(){
	$http({
		url:'/Test/universityList', 
		method: "get"
	}).then(function(response){
		console.log("universityList response",response.data);
		$scope.universityList=response.data;
	});;
};
  
	
});