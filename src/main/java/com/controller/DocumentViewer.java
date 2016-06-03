package com.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DocumentViewer {
	  @RequestMapping("/viewPDF")
	    public void pdfViewerAction(@RequestParam(value="pdfPath") String pdfPath, HttpServletRequest request, HttpServletResponse response) throws IOException {  
	        
	            File file = new File(pdfPath);
	            ServletOutputStream stream = null;
	            BufferedInputStream buf = null;
	       
	        try {           
	            
	       
	            stream = response.getOutputStream();
	            buf = new BufferedInputStream(new FileInputStream(file));
	            int readBytes = 0;
	            while ((readBytes = buf.read()) != -1)
	                stream.write(readBytes);
	            
	            stream.close();
	            stream.flush();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }   
	        
	        
	    }
	  
	  @RequestMapping("/popUpContent")
	    public String popContent() throws IOException {  
	        
	            return "popup";
	        
	    }
	  
	  @RequestMapping("/one")
	    public String one() throws IOException {  
	        
	            return "one";
	        
	    }
	  
	  @RequestMapping("/two")
	    public String two() throws IOException {  
	        
	            return "two";
	        
	    }
}
