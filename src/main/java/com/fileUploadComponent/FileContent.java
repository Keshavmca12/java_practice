package com.fileUploadComponent;

import org.springframework.web.multipart.MultipartFile;

public class FileContent {
	MultipartFile file;

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}
}
