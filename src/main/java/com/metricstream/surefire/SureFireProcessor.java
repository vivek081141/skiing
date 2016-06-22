package com.metricstream.surefire;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.xml.sax.SAXException;

public class SureFireProcessor {
	private DBHandler dbHandler=new DBHandler();
	
	public void processSureFirePlugins(String folderLocation,String moduleName) {
		validateInputs(folderLocation, moduleName);
		
		XMLReader xmlReader=new XMLReader();
		List<String> filePathList=new ArrayList<String>();
		try{
			File folder = new File(folderLocation);
			for (final File file : folder.listFiles()) {
		        if (file.isFile() && file.getName().endsWith(".xml")) { 
		        	filePathList.add(file.getPath());
		        }
		    }
			Bean bean=xmlReader.xmlProcesser(filePathList);
			bean.setModuleName(moduleName);
			dbHandler.persistTestResult(bean);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
	}

	private void validateInputs(String folderLocation, String moduleName) {
		if(folderLocation==null || folderLocation.isEmpty() || moduleName==null || moduleName.isEmpty()){
			throw new IllegalArgumentException("The input parameters are incorrect!");
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException, XPathExpressionException, ParserConfigurationException, SAXException, IOException {
		SureFireProcessor surefire=new SureFireProcessor();
		surefire.processSureFirePlugins("D:\\SVN\\REG\\ms_reg\\lib\\surefire-reports", "REG");
	}
}
