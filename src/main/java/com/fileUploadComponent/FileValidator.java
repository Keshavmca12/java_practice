package com.fileUploadComponent;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.multipart.MultipartFile;
@Component
public class FileValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void validate(Object multipartFile, Errors errors) {
		// TODO Auto-generated method stub

		  MultipartFile file = (MultipartFile) multipartFile;

		  if (file.getSize() == 0) {
		   errors.rejectValue("file", "uploadForm.salectFile",
		     "Please select a file!");
		  }
	}

}
