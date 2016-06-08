var fileUploadApp=angular.module("fileUploadApp",['ui.bootstrap']);
fileUploadApp.config(['$compileProvider', function ($compileProvider) {
	$compileProvider.debugInfoEnabled(false);
}]);
fileUploadApp.service('popUpService', function($uibModal){
	this.openPopup =function(action) {
		var modalInstance = $uibModal.open({
			animation: false,
			templateUrl:'/Test/'+action,
			size:'sm'
		});

		modalInstance.result.then(function(selectedItem) {
			scope.selected = selectedItem;
			console.log("pop up opened");
		}, function() {
			console.log("pop up closed");
		});
	};
	
});

fileUploadApp.controller('AppCtrl', function ($scope, $uibModal,popUpService,$http) {
	console.log("$uibModal controller",$uibModal);
	$scope.openPopup=function(flag){
		console.log("flag",flag);
		popUpService.openPopup(flag);
	};
	
	$http({
		url:'/Test/userTree', 
		method: "GET"
		}).then(function(response){
		console.log("userTree reponse",response.data);
		$scope.userTree=response.data;	
	});;
});


fileUploadApp.directive('uploadDocument',function( $http) {
	return {
		restrict: 'ECA',
		scope: {
			actionUrl: '@'
		},
		template: '<form method="POST" id="uploadFile"  enctype="multipart/form-data"><input type="file" id="file" name="file" value="upload"></form>',
		link: function(scope, el, attrs) {
			console.log("url   :: "+scope.actionUrl);
			console.log("el",el);
			document.getElementById("file").onchange = function() {
				//	document.getElementById("uploadFile").submit();
				
				var formData=new FormData();
				console.log(file.files[0]);
			    formData.append("file",file.files[0]);
			    console.log("formData",formData);
			    $http.post(scope.actionUrl, formData, {
			        transformRequest: function(data, headersGetterFunction) {
			            return data;
			        },
			        headers: { 'Content-Type': undefined }
			        }).success(function(data, status) {  
			        	console.log("success data ",data);
			            //alert("Success ... " + status);
			        }).error(function(data, status) {
			        	console.log("error data ",data);
			         //   alert("Error ... " + status);
			        });
			}; 
		}  
	}
});


fileUploadApp.directive('showDocument',function() {
	return {
		restrict: 'ECA',
		scope: {
			documentUrl: '@'
		},
		template: '<object data="{{documentUrl}}" type="application/pdf" width="50%" height="50%"></object>',
		link: function(scope, el, attrs) {
			console.log("url   :: "+scope.documentUrl);
		}  
	}
});


fileUploadApp.directive('showPopUp', function($uibModal,$http) {
	return {
		restrict: 'EA',
		scope: {
			popUpUrl: '@pageUrl'
		},
		link: function($scope, el, attrs) {
			console.log("popUpUrl"+$scope.popUpUrl);
			var modalInstance = $uibModal.open({
				animation: false,
				templateUrl:$scope.popUpUrl,
				size:'lg'
			});

			modalInstance.result.then(function(selectedItem) {
				scope.selected = selectedItem;
			}, function() {});

		}
	}
});

