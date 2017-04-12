var actualCaretPositionBookmark;
tinymce.init({
		// General options
	//insert image use image
	//insert html use code
	 	mode : "exact",        
	 	elements : "noting",		
		//theme : "advanced",
		language :"en",
		browser_spellcheck: true,
		nonbreaking_force_tab : true,
		powerpaste_word_import: 'prompt',
		  powerpaste_html_import: 'prompt',
		//contextmenu: "link image inserttable bold | cell row column deletetable",
		plugins: [
			'pramukhime tabfocus  autosave advlist  lists link image charmap print preview hr anchor pagebreak powerpaste',
			'searchreplace wordcount visualblocks visualchars code fullscreen insertdatetime media nonbreaking save table  directionality',
			'emoticons textcolor colorpicker imagetools codesample toc fullpage paste  textpattern autolink spellchecker autoresize template'
		],  
		  paste_data_images: true,
				toolbar1: "bold italic underline strikethrough | alignleft aligncenter alignright alignjustify  | styleselect | justifyleft justifycenter justifyright | formatselect fontselect fontsizeselect",
				toolbar2: ' bullist numlist outdent indent blockquote | undo redo  | link unlink anchor cleanup nonbreaking',
				toolbar3:" cut copy paste pastetext | searchreplace | subscript superscript | hr | charmap emoticons media | ltr rtl",
				toolbar4: "table forecolor backcolor | preview print fullscreen | restoredraft pramukhime  pramukhimesettings pramukhimeresetsettings pramukhimetogglelanguage pramukhimehelp | image | insert | codesample insertdatetime fullpage template removeformat pagebreak rupee",
				image_advtab: true,
				templates: [
					{ title: 'Template 1', content: 'Test 1' },
					{ title: 'Template 2', content: 'Test 2' }
				],
				style_formats : [
					{title : 'Bold text', inline : 'b'},
					{title : 'Red text', inline : 'span', styles : {color : '#ff0000'}},
					{title : 'Red header', block : 'h1', styles : {color : '#ff0000'}},
					{title : 'Example 1', inline : 'span', classes : 'example1'},
					{title : 'Example 2', inline : 'span', classes : 'example2'},
					{title : 'Table styles'},
					{title : 'Table row 1', selector : 'tr', classes : 'tablerow1'}
				],
		
		content_css  :"css/greenNote.css",
		images_upload_base_path: 'showImageUploadDialog',
		//autosave_interval: "10s",
		//tinyautosave_minlength: 5,
		//tinyautosave_interval_seconds: 10,
		fullscreen_new_window : true,
        fullscreen_settings : {
                theme_advanced_path_location : "top"
        },
        //onchange_callback: "saveNotingDynamically",
		//tinyautosave_oninit: "configAutoSave",
		autosave_ask_before_unload:false,
		spellchecker_languages :"+English=en",
		fontsize_formats: "12px 13px 14px 16px 18px 20px",
		init_instance_callback: function (editor) {
		    editor.on('change', function (e) {
		      //saveNotingDynamically();
		    });
		    
		   
		},
        
		/*setup: function (editor) {
		    editor.addButton('rupee', {
		      text: '\u20B9',
		      icon: false,
		      onclick: function () {
		        editor.insertContent('\u20B9');
		      }
		    });
		  },*/
        external_plugins: {"nanospell": "nanospell/plugin.js"},
    	nanospell_server: "java",
    	 file_picker_types: 'image',
    	 image_title: true,
    	 automatic_uploads: false,
    	 file_picker_callback: function(cb, value, meta) {
    	    var input = document.createElement('input');	
    	    input.setAttribute('type', 'file');
    	    input.setAttribute('accept', 'image/*');
    	    input.setAttribute('name','fileUpload');
    	    input.onchange = function() {
    	    	alert("uploaing");
    	      var file = this.files[0];
    	     // saveImage(input);
    	     console.log("file",file); 
    	      var data = new FormData();
    	      data.append('fileUpload', file);

    	      $.ajax({
    	        url: '/Test/imagesUpload',
    	        type: 'POST',
    	        data: data,
    	        enctype: 'multipart/form-data',
    	        processData: false, // Don't process the files
    	        contentType: false, // Set content type to false as jQuery will tell the server its a query string request
    	        success: function(data, textStatus, jqXHR) {
    	        	console.log("data",data);
    	         // editor.insertContent('<img class="content-img" src="' + data.url + '"/>');
    	        },
    	        error: function(jqXHR, textStatus, errorThrown) {
    	          if(jqXHR.responseText) {
    	            errors = JSON.parse(jqXHR.responseText).errors
    	            alert('Error uploading image: ' + errors.join(", ") + '. Make sure the file is an image and has extension jpg/jpeg/png.');
    	          }
    	        }
    	      });
    	      /*var id = 'blobid' + (new Date()).getTime();
    	      var blobCache = tinymce.activeEditor.editorUpload.blobCache;
    	      var blobInfo = blobCache.create(id, file);
    	      blobCache.add(blobInfo);
    	      cb(blobInfo.blobUri(), { title: file.name });*/
    	      
//    	      cb("images/tinyMCEImages/ADMGLetterHead.jpg", { title: file.name });
//    	      images/tinyMCEImages/ADMGLetterHead.jpg
    	    };    
    	    input.click();
    	  }
	
});
