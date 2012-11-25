package org.tp;

import java.io.FileReader;
import java_cup.runtime.Symbol;

public class Main {
	
    static Env firstEnv=null;
    static Env currentEnv=null;

    public static void main(String[] args) {
	try {
	    FileReader  myFile = new FileReader(args[0]);
	    TpLexer myLex = new TpLexer(myFile);
	    TpParser myP = new TpParser(myLex);
	    Symbol result=null;
	    try {
		result=myP.parse();
		try {
		    AbSynt root=(AbSynt)result.value;
		    System.out.println(root.toString());
		    //root.toDot("detruire");
		}	
		catch (Exception e) {
		    System.out.println("result error");
		}
	    }
	    catch (Exception e) {
		System.out.println("parse error...");
		e.printStackTrace();
	    }
	}
	catch (Exception e){
	    System.out.println("invalid file");	    
	}
    }
}