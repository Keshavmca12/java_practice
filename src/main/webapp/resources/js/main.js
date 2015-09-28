alert("in main js");
require.config({
	   
});
require(
		[
	        'resources/js/dynamicApp'
	    ], function (dynamicContentApp) {
	        angular.element(document).ready(function () {
	        	alert("starting app main");
	            angular.bootstrap(document, ['dynamicContentApp']);
	        });
	    }

);