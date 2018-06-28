package Utilities;

import java.io.File;
import java.lang.reflect.Method;



import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;



public class XMLUtilities {
	
	static String string=null;
	public static void main(String[] args) {
		String xml=getXMLvalues("testdatapath");
		System.out.println(xml);
	}
	
	public static String getXMLvalues(String tagstring) {
		
		try{
			
			String configFilename=TestCaseRunner.getTestConfig().getConfigpath();
			
			System.out.println(configFilename);
			File file=new File(configFilename);
			
			DocumentBuilderFactory document=DocumentBuilderFactory.newInstance();
			DocumentBuilder documentbuilder=document.newDocumentBuilder();
			Document doc=documentbuilder.parse(file);
			
			doc.getDocumentElement().normalize();
			
			NodeList nList=doc.getElementsByTagName("param");
			
			for (int i = 0; i < nList.getLength(); i++) 
			{
				Node node=nList.item(i);
				
				if(node.getNodeType()==Node.ELEMENT_NODE)
				{
					Element element=(Element)node;
					
					string =element.getElementsByTagName(tagstring).item(0).getTextContent();
										
				}
							
			}
			
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		if(tagstring.contains("testdatapath"))
		{
			return TestCaseRunner.getTestConfig().getTestdatapath();
		}
		
		else if(tagstring.contains("screenshotpath"))
		{
			return TestCaseRunner.getTestConfig().getScreenshotpath();
		}
		
		
		else
			return string;
		
		
		
	}
	
	
	
	

}
