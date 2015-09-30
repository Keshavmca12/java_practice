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
	$scope.backendPagination=false;
	var convertToPixel=function(data){
		return data*7+'px';
	};

	$scope.changeToBackendPagination=function(){
		$scope.backendPagination=!$scope.backendPagination;
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
		});
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







smartTableApp.controller('backendPaginationCtrl', ['Resource','$scope','$http', function (service,$scope,$http) {
	$scope.displayed = [];

	$scope.callServer = function callServer(tableState) {
		console.log("tableState",tableState);
		$scope.isLoading = true;

		var pagination = tableState.pagination;

		var start = pagination.start || 0;     // $scope is NOT the page number, but the index of item in the list that you want to use to display the table.
		var number = pagination.number || 10;  // Number of entries showed per page.

		service.getPage(start, number, tableState).then(function (result) {
			$scope.displayed = result.data;
			tableState.pagination.numberOfPages = result.numberOfPages;//set the number of pages so the pagination can update
			console.log("updated table state"+tableState);
			$scope.isLoading = false;
		});
	};

}])




smartTableApp.factory('Resource', ['$q', '$filter', '$timeout','$http', function ($q, $filter, $timeout,$http) {
//console.log("in service");
	//this would be the service to call your server, a standard bridge between your model an $http

	// the database (normally on your server)
	var randomsItems = [];

	function createRandomItem(id) {
		var heroes = ['Batman', 'Superman', 'Robin', 'Thor', 'Hulk', 'Niki Larson', 'Stark', 'Bob Leponge'];
		return {
			id: id,
			name: heroes[Math.floor(Math.random() * 7)],
			age: Math.floor(Math.random() * 1000),
			saved: Math.floor(Math.random() * 10000)
		};

	}

	for (var i = 0; i < 1000; i++) {
		randomsItems.push(createRandomItem(i));
	}


	//fake call to the server, normally this service would serialize table state to send it to the server (with query parameters for example) and parse the response
	//in our case, it actually performs the logic which would happened in the server
	function getPage(start, number, paramsData) {
		var deferred = $q.defer();
		$http({
			url:'/Test/getTablePaginatedData', 
			method: "GET",
			params:{start:start,number:number,paramsData:paramsData}
		}).then(function(response){
			console.log("originalData length",response.data.length);
			deferred.resolve({
				data: response.data.list,
				numberOfPages: response.data.pages
			});
			console.log("deffered",deferred);

		});
		return deferred.promise;

		/*var deferred = $q.defer();

		var filtered = params.search.predicateObject ? $filter('filter')(randomsItems, params.search.predicateObject) : randomsItems;

		if (params.sort.predicate) {
			filtered = $filter('orderBy')(filtered, params.sort.predicate, params.sort.reverse);
		}

		var result = filtered.slice(start, start + number);

		$timeout(function () {
			//note, the server passes the information about the data set size
			deferred.resolve({
				data: result,
				numberOfPages: Math.ceil(filtered.length / number)
			});
		}, 1500);


		return deferred.promise;
*/
}

	return {
		getPage: getPage
	};

}]);

