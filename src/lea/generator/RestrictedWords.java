/*This class is use only when we create new functions/class, to check if the name function/class is available*
 * if not, we format the name */

package lea.generator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RestrictedWords {

	List<String> restrictedList;
	NameGenerator ng;
	
	public RestrictedWords()
	{
		ng = new NameGenerator();
		
		this.restrictedList = new ArrayList <String> ();
		
		this.restrictedList.add("abstract");
		this.restrictedList.add("assert");
		this.restrictedList.add("boolean");
		this.restrictedList.add("break");
		this.restrictedList.add("byte");
		this.restrictedList.add("case");
		this.restrictedList.add("catch");
		this.restrictedList.add("char");
		this.restrictedList.add("class");
		this.restrictedList.add("class");
		this.restrictedList.add("const");
		this.restrictedList.add("continue");
		this.restrictedList.add("default");
		this.restrictedList.add("do");
		this.restrictedList.add("double");
		this.restrictedList.add("else");
		this.restrictedList.add("enum");
		this.restrictedList.add("extends");
		this.restrictedList.add("false");
		this.restrictedList.add("final");
		this.restrictedList.add("finally");
		this.restrictedList.add("float");
		this.restrictedList.add("for");
		this.restrictedList.add("goto");
		this.restrictedList.add("if");
		this.restrictedList.add("implements");
		this.restrictedList.add("import");
		this.restrictedList.add("instanceof");
		this.restrictedList.add("int");
		this.restrictedList.add("interface");
		this.restrictedList.add("long");
		this.restrictedList.add("native");
		this.restrictedList.add("new");
		this.restrictedList.add("null");
		this.restrictedList.add("package");
		this.restrictedList.add("private");
		this.restrictedList.add("protected");
		this.restrictedList.add("public");
		this.restrictedList.add("return");
		this.restrictedList.add("short");
		this.restrictedList.add("static");
		this.restrictedList.add("strictfp");
		this.restrictedList.add("super");
		this.restrictedList.add("switch");
		this.restrictedList.add("synchronized");
		this.restrictedList.add("this");
		this.restrictedList.add("throw");
		this.restrictedList.add("throws");
		this.restrictedList.add("transient");
		this.restrictedList.add("true");
		this.restrictedList.add("try");
		this.restrictedList.add("void");
		this.restrictedList.add("volatile");
		this.restrictedList.add("while");
	}
	
	public void deleteDouble()
	{
		Set<String> mySet = new HashSet<String>(this.restrictedList);
		this.restrictedList=new ArrayList<String>(mySet);
	}
	
	public boolean findWord(String word)
	{
		for (String w : this.restrictedList)
		{
			if (word == w)
				return true;
		}
		return false;
	}
	
	
	public void addWord(String word)
	{
		if (findWord(word) == false)
			this.restrictedList.add(word);
		/*if true, we need to see if the word does not exist with the format name*/
		else
		{
			this.restrictedList.add(ng.generateName(word));
		}
	}
	
	public List<String> getRestrictedWord()
	{
		deleteDouble();
		return this.restrictedList;
	}
	
}
