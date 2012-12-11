package lea.generator;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterT {

	private FileWriter testW;
	
	public FileWriterT() throws IOException
	{
		testW = new FileWriter("test.java");
	}

	public void generate(String l) throws IOException
	{
		this.testW.write(l);
		this.testW.close();
	}
}
