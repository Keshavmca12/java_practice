var ckAPP=angular.module("ckAPP",['ngSanitize']);

ckAPP.controller("ckController",function($scope,$http){
	
$scope.product={};
$scope.submitProdDetails=function(data){
	console.log("data",data);
	$http({
		url:'/Test/submitProdDetails', 
		method: "post",
		data: data
	}).then(function(response){
		console.log("reponse",response.data);
		$scope.prod=response.data;
		$scope.product={};
	});
};
});

ckAPP.directive('ckEditor', function () {
    return {
        require: '?ngModel',
        link: function (scope, elm, attr, ngModel) {
            var ck = CKEDITOR.replace(elm[0]);
            if (!ngModel) return;
            ck.on('instanceReady', function () {
                ck.setData(ngModel.$viewValue);
            });
            function updateModel() {
                scope.$apply(function () {
                ngModel.$setViewValue(ck.getData());
            });
        }
        ck.on('change', updateModel);
        ck.on('key', updateModel);
        ck.on('dataReady', updateModel);

        ngModel.$render = function (value) {
            ck.setData(ngModel.$viewValue);
        };
    }
};
});