package com.controller;

import java.io.File;

import org.artofsolving.jodconverter.OfficeDocumentConverter;
import org.artofsolving.jodconverter.office.DefaultOfficeManagerConfiguration;
import org.artofsolving.jodconverter.office.OfficeManager;


public class Converter {

	public static void main(String[] args) {
		int servicePort=5400;
		String officeHome="C:"+System.getProperty("file.separator")+"Program Files (x86)"+System.getProperty("file.separator")+"OpenOffice 4";
	/*	DocumentFormatRegistry registry = new DefaultDocumentFormatRegistry();*/
		DefaultOfficeManagerConfiguration configuration = new DefaultOfficeManagerConfiguration();
		configuration.setOfficeHome(officeHome);
		configuration.setPortNumber(servicePort);
		configuration.setTaskQueueTimeout(120000L);
		configuration.setTaskExecutionTimeout(240000L);
		OfficeManager officeManager = configuration.buildOfficeManager();
		officeManager.start();
		File inputFile=new File("C:"+System.getProperty("file.separator")+"Users"+System.getProperty("file.separator")+"NICSI"+System.getProperty("file.separator")+"Downloads"+System.getProperty("file.separator")+"pl.docx");
		File outputFile=new File("C:"+System.getProperty("file.separator")+"Users"+System.getProperty("file.separator")+"NICSI"+System.getProperty("file.separator")+"Downloads"+System.getProperty("file.separator")+"otputpl.pdf");
		System.out.println("Open Office Port " + servicePort + " Stated ");
		//DocumentFormat outputFormat=new DocumentFormat("Portable Document Format", "pdf", "application/pdf");
		OfficeDocumentConverter converter=new OfficeDocumentConverter(officeManager);
		converter.convert(inputFile, outputFile);
	}
}
