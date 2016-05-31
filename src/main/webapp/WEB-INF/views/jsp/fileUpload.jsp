<html ng-app="fileUploadApp">
<head>
<title>Upload Multiple File Request Page</title>

</head>
<body>
	<!-- <form method="POST" id="uploadFile" action="upload"
		enctype="multipart/form-data">
		<input type="file" id="file" name="file" value="upload"> 
				<input type="submit" value="Upload"> 
	</form> -->
	
	<file-upload url="upload"></file-upload>

	<script type="text/javascript">
	/* document.getElementById("file").onchange = function() {
	    document.getElementById("uploadFile").submit();
	}; */
	</script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/angularjs/1.3.14/angular.min.js"></script>
		<script type="text/javascript" src="resources/js/fileUploadApp.js"></script>
</body>
</html>