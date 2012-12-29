package lea.syntax;

import lea.generator.CodeWriter;

public class Case extends Instruction 
{
	protected SyntaxTree left, right;
	
	public Case(SyntaxTree a1, SyntaxTree a2)
	{
		super(a1, a2);
		left = a1;
		right = a2;
	}
	
	
	public String toString()
	{
		return "Case"+super.toString();
	}
	
	public String toDotString()
	{
		return "Case";
	}
	
	public void toJava(CodeWriter cw)
	{
		
		cw.writeLine("\nLEFT !!!\n" + "Left type : " + left.getType() + "\n left to string : " + left.toString() + "\n get class : " + left.getClass());
	}
}
