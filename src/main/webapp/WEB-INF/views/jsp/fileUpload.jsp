<html ng-app="fileUploadApp">
<head>
<link href="//netdna.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
<title>Upload File Request Page</title>
</head>
<body ng-controller="AppCtrl">
	 <upload-document action-url="upload"></upload-document><br>
	
	
	<strong>Uploaded Document</strong><br>
	
	<show-document document-url="/Test/viewPDF?pdfPath=C:\Program Files (x86)\Apache Software Foundation\Tomcat 7.0\tmpFiles\eRMS_ERdiagram231015.pdf"></show-document>
	
	 <show-pop-up page-url="/Test/popUpContent"></show-pop-up>
	 
	 
	 <strong ng-click="openPopup('one')">Pop up one </strong><br>
	 
	 <strong ng-click="openPopup('two')">Pop up two</strong><br>
	 
	<!-- <script type="text/javascript" src="resources/lib/jquery-1.10.2.min.js"></script>-->
	<!-- <script
		src="resources/lib/angular.js"></script> -->
	<script src="//ajax.googleapis.com/ajax/libs/angularjs/1.5.3/angular.js"></script>
    <script src="//angular-ui.github.io/bootstrap/ui-bootstrap-tpls-1.3.3.js"></script>
	<script type="text/javascript" src="resources/js/fileUploadApp.js"></script>
</body>
</html>