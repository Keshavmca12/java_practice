<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- <html ng-app="dynamicContentApp"> -->
<html ng-app="dynamicContentApp">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Text change dynamically</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
</head>
<body ng-controller="AppController" class="container">
<h1>click here to <a href="/Test/logout">logout</a></h1>
	Name
	 <ng-view></ng-view>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/angularjs/1.3.14/angular.min.js"></script>
		<script
		src="https://code.angularjs.org/1.3.14/angular-route.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.4.3/angular-sanitize.min.js"></script>
	<script type="text/javascript" src="https://tinymce.cachefly.net/4.0/tinymce.min.js"></script>
	<script type="text/javascript" src="https://tinymce.cachefly.net/4.0/plugins/jbimages/plugin.min.js"></script>
	<script type="text/javascript">
	tinymce.init({
		  selector: "textarea",
		  
		  // ===========================================
		  // INCLUDE THE PLUGIN
		  // ===========================================
			
		  plugins: [
		    "image charmap print preview anchor",
		    "searchreplace visualblocks code fullscreen",
		    "insertdatetime media table contextmenu paste"
		  ],
			
		  // ===========================================
		  // PUT PLUGIN'S BUTTON on the toolbar
		  // ===========================================
			
		  toolbar: "insertfile undo redo | styleselect | bold italic | alignleft aligncenter alignright alignjustify | bullist numlist outdent indent | link image",
			
		  // ===========================================
		  // SET RELATIVE_URLS to FALSE (This is required for images to display properly)
		  // ===========================================
			
		  relative_urls: false
			
		});
	</script>
	<script type="text/javascript" src="resources/js/tinymce.js"></script>
	<script type="text/javascript" src="resources/js/dynamicApp.js"></script>
	<!--  <script src="https://cdnjs.cloudflare.com/ajax/libs/require.js/2.1.20/require.min.js" data-main="resources/js/main.js"></script> -->
	 <script type="text/javascript">//alert("here");
	/*  require.config({
		   
	 }); */
	/*  require(
	 		[
	 	        'resources/js/dynamicApp'
	 	    ], function (dynamicContentApp) {
	 	        angular.element(document).ready(function () {
	 	        //	alert("starting app");
	 	            angular.bootstrap(document, ['dynamicContentApp']);
	 	        });
	 	    }

	 ); */
	</script>
	<!-- <script type="text/javascript" src="resources/js/primary.js"></script> -->
</body>
</html>