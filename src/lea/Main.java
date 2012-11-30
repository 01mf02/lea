package lea;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map;
import lea.syntax.*;

import java_cup.runtime.Symbol;

public class Main 
{
    public static FunctionTable fctTable = new FunctionTable();
    public static ConstantTable constTable = new ConstantTable();
    public static TypeTable typeTable = new TypeTable();
    public static SyntaxTree currentNode = null;	//Le noeud courant dans lequel on est rendu
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {

			// TODO: set up type and function table here
			// add functions like writeln() and read() to function table

			System.out.println("Lea compiler initialized.");

			FileReader file;
			try 
			{
				file = new FileReader(args[0]);
			    LeaLexer myLex = new LeaLexer(file);
			    LeaParser myP = new LeaParser(myLex);
			    
			    Symbol result=null;
			    try 
			    {
					result=myP.parse();
					try 
					{
					    //AbSynt root=(AbSynt)result.value;
					    //System.out.println(root.toString());
					    //root.toDot("detruire");
					}	
					catch (Exception e) 
					{
					    System.out.println("result error");
					}
			    }
			    catch (Exception e) 
			    {
					System.out.println("parse error...");
					e.printStackTrace();
			    }    
			} 
			catch (FileNotFoundException e) 
			{
				System.err.println("File not found!");
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}
