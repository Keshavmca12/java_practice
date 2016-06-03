package com.fileUploadComponent;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import org.springframework.web.multipart.MultipartFile;


public abstract class UploadButton {
	
	public static final String NOTE_FILE_FORMAT = "Note";
	public static final String DRAFT_FILE_FORMAT = "Draft";
	public static final String ISSUE_FILE_FORMAT = "Issue";
	public static final String RECEIPT_FILE_FORMAT = "Receipt";
	
	public static final String LOCAL_REFERENCE_FILE_FORMAT = "TocReference";

	public static final String ALL = "ALL";
	public static final String PDF = "application/pdf";
	public static final String DOC = "application/msword";
	public static final String OPENDOC = "application/vnd.ms-word";
	public static final String OCTET = "application/octet-stream";
	public static final String DOCX = "application/vnd.openxmlformats-officedocument.wordprocessingml.document";
	public static final String ODT = "application/vnd.oasis.opendocument.text";
	
	public static final String XLS = "application/vnd.ms-excel";
	public static final String XLSX = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
	public static final String PPT = "application/vnd.ms-powerpoint";
	public static final String PPTX = "application/vnd.openxmlformats-officedocument.presentationml.presentation";
	public static final String PPSX = "application/vnd.openxmlformats-officedocument.presentationml.slideshow";
	
	
	public Map<String, String> formatNames;

	private Long maxFileSize;
	private String[] allowedFileExtentions;
	private String uploadLocation;
	private String fileNameFormat;
	private String buttonLabel;
	private String fileNamePrefix;
	
	public String getFileNamePrefix() {
		return fileNamePrefix;
	}

	public void setFileNamePrefix(String fileNamePrefix) {
		this.fileNamePrefix = fileNamePrefix;
	}

	public Long getMaxFileSize() {
		return maxFileSize;
	}

	public void setMaxFileSize(Long maxFileSize) {
		this.maxFileSize = maxFileSize;
	}

	public String[] getAllowedFileExtentions() {
		return allowedFileExtentions;
	}

	public void setAllowedFileExtentions(String[] allowedFileExtentions) {
		this.allowedFileExtentions = allowedFileExtentions;
	}

	public String getUploadLocation() {
		return uploadLocation;
	}

	public void setUploadLocation(String uploadLocation) {
		this.uploadLocation = uploadLocation;
	}

	public void setFileNameFormat(String fileNameFormat) {
		this.fileNameFormat = fileNameFormat;
	}

	public String getFileNameFormat() {
		return fileNameFormat;
	}

	private void initDefaultModel() {
		//ReceiptService receiptService = (ReceiptService) WebUtils.getSpringBean("receiptService");
		if (this.getMaxFileSize() == null || this.getMaxFileSize() <= 0)
			try {
				this.setMaxFileSize(Long.parseLong("500"/*receiptService.getMaxUploadSize()*/));
			} catch (Exception e) {
				this.setMaxFileSize(5l);
			}

			if (StringUtils.isEmpty(getUploadLocation())) {
				//this.setUploadLocation(AppConfig.getProperty("upload.temp.path"));
			}

			if (null == getAllowedFileExtentions()) {
				String[] extention = { PDF };
				this.setAllowedFileExtentions(extention);
			}
			formatNames = new LinkedHashMap<String, String>();
			formatNames.put(PDF, "PDF");
			formatNames.put(DOC, "DOC");
			formatNames.put(DOCX, "DOCX");
			formatNames.put(ODT, "ODT");
			formatNames.put(OPENDOC, "OPENDOC");
			formatNames.put(OCTET, "OCTET");
			
			formatNames.put(XLS, "XLS");
			formatNames.put(XLSX, "XLSX");
			formatNames.put(PPT, "PPT");
			formatNames.put(PPTX, "PPTX");
			formatNames.put(PPSX, "PPSX");
	};
	
	public void onSubmit(MultipartFile file,String name){
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
	

	private String prepareFileName(String  name) {
		String fileName = name;
		String postDetailId="11";//SecurityUtils.getCurrentPostDetailId();
		String extension = fileName.substring(fileName.lastIndexOf("."), fileName.length());
		if(StringUtils.contains(fileName, ".PDF")){
			fileName=fileName.replace(".PDF", ".pdf");
		}
		if(StringUtils.isNotEmpty(getFileNamePrefix())){
			return getFileNamePrefix()+"_"+fileName;
		}
		if (StringUtils.equalsIgnoreCase(getFileNameFormat(), RECEIPT_FILE_FORMAT)) {
			fileName = "R_" +postDetailId + "_" + String.valueOf(System.currentTimeMillis())+ extension;//"_" + fileName;
		} else if (StringUtils.equalsIgnoreCase(getFileNameFormat(), ISSUE_FILE_FORMAT)) {
			fileName = "I_" +postDetailId + "_" + String.valueOf(System.currentTimeMillis())+ extension;//"_" + fileName;
		} else if (StringUtils.equalsIgnoreCase(getFileNameFormat(), DRAFT_FILE_FORMAT)) {
			fileName = "D_" +postDetailId + "_" + String.valueOf(System.currentTimeMillis())+extension;//"_" + fileName;
		} else if (StringUtils.equalsIgnoreCase(getFileNameFormat(), NOTE_FILE_FORMAT)) {
			fileName = "N_" +postDetailId + "_" + String.valueOf(System.currentTimeMillis())+ extension;//"_" + fileName;
		}else if (StringUtils.equalsIgnoreCase(getFileNameFormat(), LOCAL_REFERENCE_FILE_FORMAT)) {
			fileName = "LOCAL_REF_" +postDetailId + "_" + String.valueOf(System.currentTimeMillis())+ extension;//"_" + fileName;
		}else {
			fileName =postDetailId + "_" + String.valueOf(System.currentTimeMillis())+ extension;//"_" + fileName;
		}
		return fileName;
	}

	private boolean copyFile(/*FileUpload fileUpload,*/ String outputFile) {
		try {
			//LogUtils.info(this.getClass(), "outputFile:" + outputFile);
			File outFile = new File(outputFile);
			boolean created = outFile.createNewFile();
			FileOutputStream fos = new FileOutputStream(outputFile, true);
			InputStream fis = null;//fileUpload.getInputStream();

			byte[] buf = new byte[512];
			while (true) {
				int len = fis.read(buf);
				if (len == -1) {
					break;
				}
				fos.write(buf, 0, len);
			}
			fis.close();
			fos.close();
		} catch (FileNotFoundException e) {
			//LogUtils.error(this.getClass(), e);
			//LogUtils.info(this.getClass(), "Exception: Unable to Copy PdfUploadPanel.copyFile(" + fileUpload.getClientFileName() + "," + outputFile
				//	+ ")");
			return false;
		} catch (IOException e) {
			/*LogUtils.error(this.getClass(), e);
			LogUtils.info(this.getClass(), "Exception: Unable to Copy PdfUploadPanel.copyFile(" + fileUpload.getClientFileName() + "," + outputFile
					+ ")");*/
			return false;
		}
		return true;
	}

	private String getFileFormat(){
		List<String> formats = new ArrayList<String>();
		if(this.allowedFileExtentions!=null){
			for(String format:this.allowedFileExtentions){
				formats.add(formatNames.get(format));
			}
		}
		return formats.toString();
	}

	/**
	 * @return the buttonLabel
	 */
	public String getButtonLabel() {
		return buttonLabel;
	}

	/**
	 * @param buttonLabel the buttonLabel to set
	 */
	public void setButtonLabel(String buttonLabel) {
		this.buttonLabel = buttonLabel;
	}
	/*public void setVisibility(boolean visible){
		this.setVisible(visible);
		uploadField.setVisible(visible);
		uploadField.getForm().setMultiPart(visible);
	}
	public void setVisibility(){
		uploadField.getForm().setMultiPart(false);
	}
	public void setEnable(boolean enable){

		this.setEnabled(enable);
		uploadField.setEnabled(enable);
		uploadField.getForm().setMultiPart(enable);

	}*/
	
	public static boolean isExecutableFile(FileInputStream input) {
		  byte[] firstBytes = new byte[4];
		  try {
		    input.read(firstBytes);
		    // Check for Windows executable
		    if (firstBytes[0] == 0x4d && firstBytes[1] == 0x5a) {
		      return true;
		    }
		    return false;
		  }
		  catch (Exception e) {
		    e.printStackTrace();
		  }
		  return false;
		}
	public boolean isPdfFile() {
		if(StringUtils.equalsIgnoreCase(/*AppConfig.getProperty("pdf.validation.enable")*/"true","true")){
			/*	PDFParser parser = new PDFParser(upload.getInputStream());
			parser.parse();
			PDDocument pdfDocument = parser.getPDDocument();
			pdfDocument.close();*/
			return true;
		}
		return true;
	}
	
	private String subFolderPath() {
		int limit=1000000000;
		String subFolderPath=null;
		Calendar calendar = Calendar.getInstance();
		String year = String.valueOf(calendar.get(Calendar.YEAR));
		String strMonth = String.valueOf(calendar.get(Calendar.MONTH)+1);
		final String uploadLocation = getUploadLocation();
		final String subPath = File.separatorChar + year + File.separatorChar
				+ strMonth;
		File folder = new File(uploadLocation + subPath);

		if (!folder.exists()) {
			folder.mkdirs();
			subFolderPath=folder.getPath();
		} else {
			int size = folder.getParentFile().listFiles().length;
			for (int i = 1; i <= size; i++) {
				File allFolder=new File(folder+""+((i-1)==0?"":"-"+(i-1)));
				if (allFolder.listFiles().length == limit) {
					File subFolder=new File(folder+"-"+i);
					if(!subFolder.exists()){
						subFolder.mkdir();
						subFolderPath=subFolder.getPath();
					}
				}else if(allFolder.listFiles().length < limit){
					subFolderPath=allFolder.getPath();
					break;
				}
			}
		}
		String path = subFolderPath.substring(nthLastIndexOf(subFolderPath, File.separatorChar, 2),subFolderPath.length());
		return path;
	}
	
	public static int nthLastIndexOf(String str, char c, int n) {
		if (str == null || n < 1)
			return -1;
		int pos = str.length();
		while (n-- > 0 && pos != -1)
			pos = str.lastIndexOf(c, pos - 1);
		return pos;
	}

}
