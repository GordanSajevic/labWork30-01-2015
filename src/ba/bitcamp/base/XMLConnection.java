package ba.bitcamp.base;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import ba.bitcamp.share.Article;

public class XMLConnection {
	
	private DocumentBuilder docReader;
	private Document xmlDoc;
	
	public void setDocument(String tableName) throws ParserConfigurationException
	{
		String path = "/Users/gordansajevic/Documents/workspace/LabWork30-01-2015/src/ba/bitcamp/base/xml/"
				+ tableName + ".xml";
		try {
			setDocumentBuilder();
			xmlDoc = docReader.parse(new File(path));
		} catch (SAXException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void setDocumentBuilder() throws ParserConfigurationException
	{
		docReader = DocumentBuilderFactory.newInstance().newDocumentBuilder();
	}
	
	public NodeList query(String tableName, String queryName) throws ParserConfigurationException, XPathExpressionException
	{
		setDocument(tableName);
		XPath xPath = XPathFactory.newInstance().newXPath();
		NodeList xmlNodeList = (NodeList) xPath.compile(queryName).evaluate(xmlDoc, XPathConstants.NODESET);
		return xmlNodeList;
		
	}
	
	public boolean test() throws XPathExpressionException, ParserConfigurationException
	{
		XMLConnection connection = new XMLConnection();
		if(!(query("Articles", "//item") instanceof NodeList))
		{
			return false;
		}
		Node testItem = xmlDoc.getElementsByTagName("item").item(0);
		Article testArticle = new Article(testItem);
		if (testArticle.getId() != 1)
		{
			return false;
		}
		if (testArticle.getPubDate() != 0)
		{
			return false;
		}
		if (testArticle.getAuthorId() != 1)
		{
			return false;
		}
		return true;
	}
	
	public static void main(String[] args) throws XPathExpressionException, ParserConfigurationException {
		XMLConnection connection = new XMLConnection();
		System.out.println(connection.test());
	}

}
