package com.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.fileUploadComponent.FileUpload;
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
	public String upload(@RequestParam("file") final MultipartFile file) {
		System.out.println("upload file name from file  "+file.getOriginalFilename());
	//	fileValidator.validate(file, result);

		FileUpload fileUpload = new FileUpload() {
			@Override
			public void onUpload(String fileName,String path) {
				System.out.println("file name :: " +fileName +" uploaded successfully : update path "+path);
			}

			@Override
			public void onError(String message) {
				System.out.println("On Error ::: "+message);
			}
			
			
		};
		
		fileUpload.submit(file, file.getOriginalFilename());;
		return "fileUpload";
	}

}
