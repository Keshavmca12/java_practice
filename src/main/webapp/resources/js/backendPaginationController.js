app.controller('backendPaginationCtrl', function ($scope,$http) {
	$scope.displayed = [];

	$scope.callServer = function callServer(tableState) {
		alert("tableState"+tableState);
		$scope.isLoading = true;

		var pagination = tableState.pagination;

		var start = pagination.start || 0;     // $scope is NOT the page number, but the index of item in the list that you want to use to display the table.
		var number = pagination.number || 10;  // Number of entries showed per page.

		$http.get(start, number, tableState).then(function (result) {
			$scope.displayed = result.data;
			tableState.pagination.numberOfPages = result.numberOfPages;//set the number of pages so the pagination can update
			$scope.isLoading = false;
		});
	};

})