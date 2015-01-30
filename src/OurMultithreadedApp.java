import ba.bicamp.tools.WriteIntegers;
import ba.bicamp.tools.WriteRandomHash;
import ba.bicamp.tools.WriteStrings;


public class OurMultithreadedApp {

	public static void main(String[] args) {
		WriteIntegers wi = new WriteIntegers("Intefers");
		WriteStrings ws = new WriteStrings("Strings");
		WriteRandomHash wrh = new WriteRandomHash();
		wi.start();
		ws.start();
		wrh.start();
	}
	
}
