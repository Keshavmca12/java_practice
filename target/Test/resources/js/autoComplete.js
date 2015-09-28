var autoCompleteApp=angular.module("autoComplete",[]);

autoCompleteApp.controller("autoCompleteCtrl",function($scope,$http){
	$scope.user={};
	$scope.tags={};
	
	var getAllTags=function(){
		$http({
			url:'/Test/getAllTags', 
			method: "GET"
			}).then(function(response){
			console.log("getAllTags reponse",response.data);
			$scope.tags.all=response.data;	
		});;
	};
	var init=function(){
		getAllTags();
	};
	init();
	$scope.getContainingTag=function(data){
		if(data==''){
			$scope.tags.filter=[];
			return;
		}
		filterTags(data);
	//	getContainingTags(data);
	};
	
	var filterTags=function(data){
		$scope.tags.filter=[];
		for(var i=0;i<$scope.tags.all.length;i++){
		//	console.log("tag",$scope.tags.all[i]);
			if($scope.tags.all[i].tagName.indexOf(data)>-1){
				$scope.tags.filter.push($scope.tags.all[i]);
			}
		//	console.log("$scope.tags.filter",$scope.tags.filter);
		}
	};
	
	var getContainingTags=function(data){
		$http({
			url:'/Test/getTags', 
			method: "GET",
			params: {text: data}
		}).then(function(response){
			console.log("reponse",response.data);
			$scope.tags=response.data;	
		});;
	};
	
	$scope.assignId=function(tag){
		$scope.user.country=tag.id;
		$scope.country=tag.tagName;
		console.log("$scope.user $scope.assignId",$scope.user);
		$scope.tags.filter=[];
	};

	/*$scope.$watch('user.country', function(newVal,oldVal) {
		alert('hey, myVar has changed!  newVal  :'+newVal  +"   oldval  :"+oldVal);
		if(newVal==''){
			alert("newVal"+newVal);
			return;
		}
		return;
		$http({
			url:'/Test/getTags', 
			method: "GET",
			params: {text: data}
		}).then(function(response){
			console.log("reponse",response.data);
			$scope.tags=response.data;	
		});
	});*/


	$scope.submitForm=function(){
		//alert("DAta"+JSON.stringify($scope.user));
		console.log("$scope.user",$scope.user);
	};

});