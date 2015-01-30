package ba.bicamp.tools;

import java.util.ArrayList;

public class WriteStrings extends Thread{
	
	private String name;
	
	public WriteStrings(String name)
	{
		this.name = name;
	}
	
	public void run()
	{
		ArrayList<String> strings = new ArrayList<String>();
		strings.add("Vedad");
		strings.add("Mustafa");
		strings.add("Emir");
		strings.add("Gordan");
		strings.add("Haris");
		
		for(String s:strings)
		{
			System.out.println(name + " " + s);
		}
	}

}
