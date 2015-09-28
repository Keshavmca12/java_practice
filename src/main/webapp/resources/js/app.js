var formApp=angular.module("formApp",[]);

formApp.controller("formController",function($scope,$http){
	$scope.basicData="";
	$scope.primaryData="";
	$scope.activeData="";
	var init =function(){
		//getBasicDetails();
		$http.get('/Test/getBasic').then(function(response){
			console.log("reponse",response.data);
			$scope.basicData=response.data;	
			$scope.activeData="Hotels";
		});
	};
	$scope.getPrimarydetails=function(data){
		var id=$scope.basicData[data].id;
		$http({
			url:'/Test/getPrimary', 
			method: "GET",
			params: {basicId: id}
		}).then(function(response){
			console.log("reponse",response.data);
			$scope.primaryData=response.data;	
			$scope.activeBasic="basic";
		});;
	};
	init();
	 $scope.colors = [
	                  {name:'black', shade:'dark'},
	                  {name:'white', shade:'light', notAnOption: true},
	                  {name:'red', shade:'dark'},
	                  {name:'blue', shade:'dark', notAnOption: true},
	                  {name:'yellow', shade:'light', notAnOption: false}
	                ];
	/*	var getBasicDetails=function(){
		$http.get('/getBasic').success(function(response){
			alert("$scope.basicData",response.data);
			$scope.basicData=response.data;	
		});
	};*/
});