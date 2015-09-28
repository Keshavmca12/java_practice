var smartTableApp=angular.module("smartTable",['smart-table']);

smartTableApp.controller("smartTableCtrl",function($scope,$http){
	$scope.firstNameLength=0;
	$scope.lastNameLength=0;
	$scope.emailLength=0;
	$scope.birthDateLength=26;
	$scope.balanceLength=10;
	$scope.showDynamicData=true;
	$scope.showFormatted=true;
	$scope.currentPage=-1;
	var convertToPixel=function(data){
		return data*7+'px';
	};
	
	$scope.changeTableCOntent=function(){
		$scope.showDynamicData=!$scope.showDynamicData;
	};
	
	var getAllData=function(){
		$http({
			url:'/Test/getFLCorrepondeceData', 
			method: "GET"
			}).then(function(response){
			console.log("originalData length",response.data.length);
			$scope.originalData=response.data;	
		});;
	};
	getAllData();
	
	$scope.showAction=function(data){
		alert("you want to show action"+event.x+"   ur first name is :: "+data.firstName);
	};
	
	$scope.predicates = ['firstName', 'lastName', 'birthDate', 'balance', 'email'];
	$scope.selectedPredicate = $scope.predicates[0];
	$scope.rowCollection = [
	                       {firstName: 'Laurent dsfgfv erdfh dfhfd dfhg', lastName: 'Renard', birthDate: new Date('1987-05-21'), balance: 102, email: 'whatever@gmail.com'},
	                       {firstName: 'Blandine andrew masdto', lastName: 'Faivre', birthDate: '1987-04-25', balance: -2323.22, email: 'oufblandou@gmail.com'},
	                       {firstName: 'Francoise', lastName: 'Frere andrew donti motya andtri donti', birthDate: new Date('1955-08-27'), balance: 42343, email: 'raymondef@gmail.com'}
	                       ];
	for(var i=0;i<$scope.rowCollection.length;i++){
		if($scope.firstNameLength<$scope.rowCollection[i].firstName.length){
			$scope.firstNameLength=$scope.rowCollection[i].firstName.length;
		}
		if($scope.lastNameLength<$scope.rowCollection[i].lastName.length){
			$scope.lastNameLength=$scope.rowCollection[i].lastName.length;
		}
		if($scope.emailLength<$scope.rowCollection[i].email.length){
			$scope.emailLength=$scope.rowCollection[i].email.length;
		}
		if($scope.birthDateLength<$scope.rowCollection[i].birthDate.length){
			$scope.birthDateLength=$scope.rowCollection[i].birthDate.length;
		}
		if($scope.balanceLength<$scope.rowCollection[i].balance.length){
			$scope.balanceLength=$scope.rowCollection[i].balance.length;
		}
	}
	$scope.firstNameLength=convertToPixel($scope.firstNameLength);
	$scope.lastNameLength=convertToPixel($scope.lastNameLength);

	$scope.emailLength=convertToPixel($scope.emailLength);
	$scope.birthDateLength=convertToPixel($scope.birthDateLength);
	$scope.balanceLength=convertToPixel($scope.balanceLength);
	
	/*console.log('$scope.firstNameLength'+$scope.firstNameLength);
	console.log('$scope.lastNameLength'+$scope.lastNameLength);
	console.log('$scope.emailLength'+$scope.emailLength);
	console.log('$scope.birthDateLength'+$scope.birthDateLength);
	console.log('$scope.balanceLength'+$scope.balanceLength);*/
	
	//copy the references (you could clone ie angular.copy but then have to go through a dirty checking for the matches)
    $scope.displayedCollection = [].concat($scope.rowCollection);
    $scope.displayedData = [].concat($scope.originalData);
});



smartTableApp.directive('ngRightClick', function($parse) {
    return function(scope, element, attrs) {
    	//console.log("attrs",attrs);
        var fn = $parse(attrs.ngRightClick);
        element.bind('contextmenu', function(event) {
            scope.$apply(function() {
                event.preventDefault();
                fn(scope, {$event:event});
            });
        });
    };
});