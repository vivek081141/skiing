package com.metricstream.surefire;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * The job of this class is to take the list of file and read the XML This will
 * read all the XMLS for a file and calculate the number of passed/failed test
 * case for the module
 * 
 * @author vivek.agrawal
 *
 */
public class XMLReader {
	private Integer totaltestCases = 0;
	private Integer passedTestCase = 0;
	private Integer errorTestCase = 0;
	private Integer failedTestCase = 0;

	public Bean xmlProcesser(List<String> filePathList) throws FileNotFoundException, SAXException, IOException,
			ParserConfigurationException, XPathExpressionException {
		Bean bean = new Bean();
		for (String filePath : filePathList) {
			DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = builderFactory.newDocumentBuilder();
			Document document = builder.parse(new FileInputStream(filePath));
			XPath xPath = XPathFactory.newInstance().newXPath();
			String expression = "/testsuite";
			NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(document, XPathConstants.NODESET);
			for (int i = 0; i < nodeList.item(0).getAttributes().getLength(); i++) {
				if ("tests".equalsIgnoreCase(nodeList.item(0).getAttributes().item(i).getNodeName())) {
					totaltestCases = totaltestCases
							+ Integer.parseInt(nodeList.item(0).getAttributes().item(i).getNodeValue());
				}
				if ("errors".equalsIgnoreCase(nodeList.item(0).getAttributes().item(i).getNodeName())) {
					errorTestCase = errorTestCase
							+ Integer.parseInt(nodeList.item(0).getAttributes().item(i).getNodeValue());
				}
				if ("failures".equalsIgnoreCase(nodeList.item(0).getAttributes().item(i).getNodeName())) {
					failedTestCase = failedTestCase
							+ Integer.parseInt(nodeList.item(0).getAttributes().item(i).getNodeValue());
				}
			}

		}

		passedTestCase = totaltestCases - (errorTestCase + failedTestCase);
		bean.setRunDate(new Date());
		bean.setTotalPassedTests(passedTestCase);
		bean.setTotalTests(totaltestCases);
		return bean;
	}

}
