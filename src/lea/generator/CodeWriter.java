package lea.generator;

import java.io.FileWriter;
import java.io.IOException;

public class CodeWriter {
	
	private String result = "";
	private int indentation = 0;
	
	public void writeLine(String s) {
		for (int i = 0; i < indentation; i++)
			result += "\t";
		
		result += s;
		result += "\n";
	}
	
	public void increaseIndentation() {
		indentation++;
	}
	
	public void decreaseIndentation() {
		indentation--;
	}
	
	public void saveFile(String filename) throws IOException {
		FileWriter writer = new FileWriter(filename);
		writer.write(result);
		writer.close();		
	}
	
	public String toString() {
		return result;
	}
}
