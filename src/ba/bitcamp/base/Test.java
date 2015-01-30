package ba.bitcamp.base;

import java.awt.event.ItemEvent;
import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import ba.bitcamp.share.Article;

public class Test {

	private static boolean testArticleConstructor() throws ParserConfigurationException, SAXException, IOException
	{
		DocumentBuilder docReader = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		String path ="/Users/gordansajevic/Documents/workspace/LabWork30-01-2015/src/ba/bitcamp/base/xml/Articles.xml";
		Document xmldoc = docReader.parse(new File(path));
		Node testItem = xmldoc.getElementsByTagName("item").item(0);
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
	
	public static void main(String[] args) {
		
		try {
			System.out.println(testArticleConstructor());
		} catch (ParserConfigurationException | SAXException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
