package ba.bicamp.tools;

public class WriteIntegers extends Thread{

	private String name;
	
	public WriteIntegers(String name)
	{
		this.name = name;
	}
	
	public void run()
	{
		for (int i=0; i<100; i++)
		{
			System.out.println(name + " " + i);
		}
	}
}
