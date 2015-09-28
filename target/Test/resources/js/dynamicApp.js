var dynamicContentApp=angular.module("dynamicContentApp",['ngRoute','ngSanitize','ui.tinymce']);
dynamicContentApp.config(function($routeProvider,$controllerProvider){
	dynamicContentApp.controller = $controllerProvider.register;
	$routeProvider.
	when('/dynamicContent', {
		templateUrl: 'resources/views/app.html',
	}).
	when('/primary', {
		//controller: 'primaryController',
		templateUrl: 'resources/views/primary.html',
		/*resolve:resolveController('resources/js/primary.js') *//*{
			resolver: ['$q','$rootScope', function($q, $rootScope)
			           {
				var deferred = $q.defer();
				require(['resources/js/primary.js'], function()
						{
					$rootScope.$apply(function()
							{
						deferred.resolve();
							});
						});
				return deferred.promise;
			           }]
		}*/
		/*templateUrl: 'resources/views/primary.html',
      resolve: resolveController('resources/js/primary.js')*/
		/*
      controller: 'primaryController',
      controllerUrl: 'resources/js/primary.js'*/
	}).
	otherwise({
		redirectTo: '/dynamicContent'
	});
});

dynamicContentApp.controller("AppController",function($scope,$http,$sce,$location){
	$scope.basicData="";
	$scope.primaryData="";
	$scope.activeData="";
	$scope.activeTab='';
	$scope.activateButton=function(flag){
		$scope.activeTab=flag;
		if(flag=='primary'){
			$location.path('/primary'); 
			$http.get('/Test/primaryHtmlContent').then(function(response){
				//	console.log("reponse",response.data);
//				$scope.primaryData=$sce.trustAsHtml(response.data);
				$scope.primaryData=response.data;	
			});
		}else if(flag!=''){
			init();
		}
	};
	var init =function(){
		//getBasicDetails();
		$http.get('/Test/getBasic').then(function(response){
			console.log("reponse",response);
			$scope.basicData=response.data;	
		});
	};

	$scope.from_one = {
			from_one :'<strong>bold data in controller in from_one.js</strong>'
	};
	$scope.getEditorData=function(data){
		alert("data"+data);
	};
	$scope.getPrimarydetails=function(data){
		//	var id=$scope.basicData[data].id;
		$http({
			url:'/Test/getPrimary', 
			method: "GET",
			params: {basicId: data}
		}).then(function(response){
			//console.log("reponse",response.data);
			$scope.primaryData=response.data;	
		});;
	};
//	init();
	$scope.shownName=function(){
		alert("name  ::  "+$scope.name);
	}
	$scope.showAge=function(){
		alert("age  ::  "+$scope.age);
	}
	$scope.showdetailsOfInside=function(){
		alert("namein"+$scope.namein);
		alert("namein :: "+$("#nameinside").val()  +"    agein   :: "+$("#ageinside").val());
	}
	/*	var getBasicDetails=function(){
		$http.get('/getBasic').success(function(response){
			alert("$scope.basicData",response.data);
			$scope.basicData=response.data;	
		});
	};*/
	$scope.$on('$routeChangeStart', function(next, current) {
		console.log("next",next);
		/*	var headID = document.getElementsByTagName("body")[0];         
		var newScript = document.createElement("script");
		newScript.type = "text/javascript";
		newScript.src = "resources/js/primary.js";
		headID.appendChild(newScript);*/
	});
});

dynamicContentApp.config(function($httpProvider) {
	$httpProvider.interceptors.push(function() {
		return {

			'response': function(response) {
				// same as above
				var responseStr = JSON.stringify(response);
//				console.log("Response as it is: "+response.data);
				if(responseStr.indexOf('SESSIONTIMEOUTDIVINVALIDSESSION') > -1){
					//alert(responseStr);
					window.location.href = "/Test/invalidSession";
				}
				return response;
			}
		};
	});


});

dynamicContentApp.directive('bindUnsafeHtml', ['$compile', function ($compile) {
	return function(scope, element, attrs) {
		scope.$watch(
				function(scope) {
					// watch the 'bindUnsafeHtml' expression for changes
					return scope.$eval(attrs.bindUnsafeHtml);
				},
				function(value) {
					// when the 'bindUnsafeHtml' expression changes
					// assign it into the current DOM
					element.html(value);

					// compile the new DOM and link it to the current
					// scope.
					// NOTE: we only compile .childNodes so that
					// we don't get into infinite loop compiling ourselves
					$compile(element.contents())(scope);
				}
		);
	};
}]);


function resolveController(dependencies){
	return{
		resolver: ['$q','$rootScope', function($q, $rootScope)
		           {
			var deferred = $q.defer();
			require([dependencies], function()
					{
				$rootScope.$apply(function()
						{
					deferred.resolve();
						});
					});
			return deferred.promise;
		           }]
	}	
}




//running one

/*var dynamicContentApp=angular.module("dynamicContentApp",['ngRoute','ngSanitize','ui.tinymce']);
dynamicContentApp.config(function($routeProvider,$controllerProvider){
	dynamicContentApp.controller = $controllerProvider.register;
	$routeProvider.
	when('/dynamicContent', {
		templateUrl: 'resources/views/app.html',
	}).
	when('/primary', {
		controller: 'primaryController',
		templateUrl: 'resources/views/primary.html',
		resolve:resolveController('resources/js/primary.js') {
			resolver: ['$q','$rootScope', function($q, $rootScope)
			           {
				var deferred = $q.defer();
				require(['resources/js/primary.js'], function()
						{
					$rootScope.$apply(function()
							{
						deferred.resolve();
							});
						});
				return deferred.promise;
			           }]
		}
		templateUrl: 'resources/views/primary.html',
      resolve: resolveController('resources/js/primary.js')
		
      controller: 'primaryController',
      controllerUrl: 'resources/js/primary.js'
	}).
	otherwise({
		redirectTo: '/dynamicContent'
	});
});

dynamicContentApp.controller("AppController",function($scope,$http,$sce,$location){
	$scope.basicData="";
	$scope.primaryData="";
	$scope.activeData="";
	$scope.activeTab='';
	$scope.activateButton=function(flag){
		$scope.activeTab=flag;
		if(flag=='primary'){
			$location.path('/primary'); 
			$http.get('/Test/primaryHtmlContent').then(function(response){
				//	console.log("reponse",response.data);
//				$scope.primaryData=$sce.trustAsHtml(response.data);
				$scope.primaryData=response.data;	
			});
		}else if(flag!=''){
			init();
		}
	};
	var init =function(){
		//getBasicDetails();
		$http.get('/Test/getBasic').then(function(response){
			console.log("reponse",response);
			$scope.basicData=response.data;	
		});
	};

	$scope.from_one = {
			from_one :'<strong>bold data in controller in from_one.js</strong>'
	};
	$scope.getEditorData=function(data){
		alert("data"+data);
	};
	$scope.getPrimarydetails=function(data){
		//	var id=$scope.basicData[data].id;
		$http({
			url:'/Test/getPrimary', 
			method: "GET",
			params: {basicId: data}
		}).then(function(response){
			//console.log("reponse",response.data);
			$scope.primaryData=response.data;	
		});;
	};
//	init();
	$scope.shownName=function(){
		alert("name  ::  "+$scope.name);
	}
	$scope.showAge=function(){
		alert("age  ::  "+$scope.age);
	}
	$scope.showdetailsOfInside=function(){
		alert("namein"+$scope.namein);
		alert("namein :: "+$("#nameinside").val()  +"    agein   :: "+$("#ageinside").val());
	}
		var getBasicDetails=function(){
		$http.get('/getBasic').success(function(response){
			alert("$scope.basicData",response.data);
			$scope.basicData=response.data;	
		});
	};
	$scope.$on('$routeChangeStart', function(next, current) {
		console.log("next",next);
			var headID = document.getElementsByTagName("body")[0];         
		var newScript = document.createElement("script");
		newScript.type = "text/javascript";
		newScript.src = "resources/js/primary.js";
		headID.appendChild(newScript);
	});
});

dynamicContentApp.config(function($httpProvider) {
	$httpProvider.interceptors.push(function() {
		return {

			'response': function(response) {
				// same as above
				var responseStr = JSON.stringify(response);
//				console.log("Response as it is: "+response.data);
				if(responseStr.indexOf('SESSIONTIMEOUTDIVINVALIDSESSION') > -1){
					//alert(responseStr);
					window.location.href = "/Test/invalidSession";
				}
				return response;
			}
		};
	});


});

dynamicContentApp.directive('bindUnsafeHtml', ['$compile', function ($compile) {
	return function(scope, element, attrs) {
		scope.$watch(
				function(scope) {
					// watch the 'bindUnsafeHtml' expression for changes
					return scope.$eval(attrs.bindUnsafeHtml);
				},
				function(value) {
					// when the 'bindUnsafeHtml' expression changes
					// assign it into the current DOM
					element.html(value);

					// compile the new DOM and link it to the current
					// scope.
					// NOTE: we only compile .childNodes so that
					// we don't get into infinite loop compiling ourselves
					$compile(element.contents())(scope);
				}
		);
	};
}]);


function resolveController(dependencies){
	return{
		resolver: ['$q','$rootScope', function($q, $rootScope)
		           {
			var deferred = $q.defer();
			require([dependencies], function()
					{
				$rootScope.$apply(function()
						{
					deferred.resolve();
						});
					});
			return deferred.promise;
		           }]
	}	
}*/