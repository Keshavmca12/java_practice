package com.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.fileUploadComponent.UploadButton;
import com.fileUploadComponent.FileValidator;

@Controller
public class FileUploadController {
	
	 @Autowired
	 FileValidator fileValidator;
	 
	@RequestMapping(value = "/fileUploadPage", method = RequestMethod.GET)
	public String printWelcome() {
		System.out.println("serving upload page");
		return "fileUpload";
	}

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public @ResponseBody Object upload(@RequestParam(value="file", required=true) MultipartFile file) {
		System.out.println("upload file name from file  "+file.getOriginalFilename());
	//	fileValidator.validate(file, result);
		final HashMap<String, String> hm=new HashMap<String, String>();
		UploadButton uploadButton = new UploadButton() {
			@Override
			public void onUpload(String fileName,String path) {
				System.out.println(path);
				hm.put("path12",path);
			}
			@Override
			public void onError(String message) {
				System.out.println("On Error ::: "+message);
			}
		};
		uploadButton.onSubmit(file, file.getOriginalFilename());;
		return hm;
	}

}
