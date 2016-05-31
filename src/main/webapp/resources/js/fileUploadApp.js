var fileUploadApp=angular.module("fileUploadApp",[]);


fileUploadApp.directive('fileUpload',function() {
	return {
		restrict: 'E',
		scope: {
			url: '=url'
		},
		template: 'url::{{url}}<form method="POST" id="uploadFile" action="{{url}}" enctype="multipart/form-data"><input type="file" id="file" name="file" value="upload"></form>',
		link: function(scope, el, attrs) {
			alert("url   :: "+scope.url);
			document.getElementById("file").onchange = function() {
			    document.getElementById("uploadFile").submit();
			}; 
		}  
	}
});
