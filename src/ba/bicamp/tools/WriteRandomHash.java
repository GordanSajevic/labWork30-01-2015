package ba.bicamp.tools;

import java.util.ArrayList;

public class WriteRandomHash implements Runnable{

	public void run()
	{
		ArrayList<String> strings = new ArrayList<String>();
		strings.add("Tarik");
		strings.add("Davor");
		strings.add("Edib mačić");
		strings.add("Mirza");
		strings.add("Šemsa");
		
		for(String s:strings)
		{
			System.out.println(s);
		}
	}

}
