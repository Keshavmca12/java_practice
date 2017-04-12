package com.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class TinyMCE4_5_ {
	@RequestMapping(value = "/tinyMCE4", method = RequestMethod.GET)
	public String printWelcome() {
		System.out.println("tinyMCE4 page");
		return "tinyMCE4";
	}
	
	/**
	 * Upload single file using Spring Controller
	 */
	@RequestMapping(value = "/imagesUpload", method = RequestMethod.POST)
	public @ResponseBody
	String uploadFileHandler(
			@RequestParam("fileUpload") MultipartFile file) {
		System.out.println("file"+file);
		String name=file.getOriginalFilename();
		System.out.println("name"+name);
		System.out.println("name"+file.getName());
		if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();

				// Creating the directory to store file
				/*String rootPath = System.getProperty("catalina.home");
				File dir = new File(rootPath + File.separator + "temp");
				
				if (!dir.exists())
					dir.mkdirs();*/

				// Create the file on server
				File serverFile = new File("F:"
						+ File.separator +name);
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();

				System.out.println("Server File Location="+serverFile.getAbsolutePath());

				return "You successfully uploaded file=" + name;
			} catch (Exception e) {
				return "You failed to upload " + name + " => " + e.getMessage();
			}
		} else {
			return "You failed to upload " + name
					+ " because the file was empty.";
		}
	}

}
