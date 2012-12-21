package lea.syntax;

import lea.generator.CodeWriter;

public class Repeat extends Instruction 
{
	SyntaxTree left, right;
	public Repeat(SyntaxTree a1, SyntaxTree a2)
	{
		super(a1, a2);
		left = a1;
		right = a2;
	}
	
	public String toString()
	{
		return "Repeat"+super.toString();
	}
	
	public String toDotString()
	{
		return "Repeat";
	}
	
	public void tiJava(CodeWriter cw)
	{

			cw.writeLine(left +" repeat");
	}
}
