package ba.bitcamp.share;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Article {
	
	private int id;
	private String title;
	private String content;
	private int pubDate;
	private int authorId;
	
	public Article(int id, String title, String content, int pubDate, int authorId) 
	{
		this.id = id;
		this.title = title;
		this.content = content;
		this.pubDate = pubDate;
		this.authorId = authorId;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getPubDate() {
		return pubDate;
	}

	public void setPubDate(int pubDate) {
		this.pubDate = pubDate;
	}

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}
	
	@Override
	public String toString() {
		return "Article [id=" + id + ", title=" + title + ", content="
				+ content + ", pubDate=" + pubDate + ", authorId=" + authorId
				+ "]";
	}
	
	public Article (Node current)
	{
		if (current instanceof Element)
		{
			
			Element currentElement = (Element) current;
			this.id = Integer.parseInt(currentElement.getAttribute("id"));
			NodeList xmlChildren = current.getChildNodes();
			for(int i=0; i<xmlChildren.getLength(); i++)
			{
				Node currentChild = xmlChildren.item(i);
				if (currentChild instanceof Element)
				{
					Element currentChildElement = (Element)currentChild;
					if (currentChildElement.getTagName().equals("title"))
					{
						this.title = currentChildElement.getTextContent();
					}
					if (currentChildElement.getTagName().equals("content"))
					{
						this.content = currentChildElement.getTextContent();
					}
					if (currentChildElement.getTagName().equals("pubDate"))
					{
						this.pubDate = Integer.parseInt(currentChildElement.getTextContent());
					}
					if (currentChildElement.getTagName().equals("autor"))
					{
						this.authorId = Integer.parseInt(currentChildElement.getAttribute("id"));
					}
				}
			}
		}
		else
		{
			System.err.println("Not instance of element!");
		}
	}
	

}
