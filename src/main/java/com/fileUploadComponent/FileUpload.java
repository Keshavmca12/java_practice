package com.fileUploadComponent;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import org.springframework.web.multipart.MultipartFile;


public abstract class FileUpload {
	/*	private MultipartFile file;
	private String name;
	private String result;
	 */
	public void submit(MultipartFile file,String name){

		// TODO Auto-generated method stub
		String result=null;
		if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();

				// Creating the directory to store file
				String rootPath = System.getProperty("catalina.home");
				File dir = new File(rootPath + File.separator + "tmpFiles");
				if (!dir.exists())
					dir.mkdirs();
				String filePath=dir.getAbsolutePath()+ File.separator + name;
				System.out.println("path of file "+filePath);
				// Create the file on server
				File serverFile = new File(filePath);
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();

				System.out.println("Server File Location="
						+ serverFile.getAbsolutePath());

				result="You successfully uploaded file=" + name;
				onUpload(name,filePath);

			} catch (Exception e) {
				result="You failed to upload " + name + " => "+ e.getMessage();
				onError(result);
				e.printStackTrace();
			}
		} else {
			result= "You failed to upload " + name
					+ " because the file was empty.";
			onError(result);
		}
		System.out.println("result    :   "+result);
		
	}
	public abstract void onUpload(String fileName,String path);
	public abstract void onError(String result);


	/*public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}*/


}
