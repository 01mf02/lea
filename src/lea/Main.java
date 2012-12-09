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
    private static boolean hasCompileErrors = false;
    private static LeaLexer myLex;
    
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
			    myLex = new LeaLexer(file);
			    LeaParser myP = new LeaParser(myLex);
			    
			    Symbol result=null;
			    try 
			    {
					result=myP.parse();
					try 
					{
						if(!hasCompileErrors)
						{
							//CODE POUR LAETITIA
						}
						
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
	
	//Le level c'est :
	// 0 : WARNING
	// 1 : ERROR
	// 2 : FATAL ERROR
	public static void printError(String message, int level)
	{
		String outputMess;
		
		switch(level)
		{
		case 0:
			outputMess = "WARNING (ligne "+myLex.getLine()+", colonne "+myLex.getColumn()+") : " + message;
			break;
		case 1:
			outputMess = "ERROR (ligne "+myLex.getLine()+", colonne "+myLex.getColumn()+") : " + message;
			hasCompileErrors = true;
			break;
		case 2:
			outputMess = "FATAL ERROR (ligne "+myLex.getLine()+", colonne "+myLex.getColumn()+") : " + message;
			hasCompileErrors = true;
			break;
		default:
			outputMess = message;
			break;
		}
		
		System.out.println(outputMess);
	}
}
