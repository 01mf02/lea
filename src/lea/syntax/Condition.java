package lea.syntax;

import lea.generator.CodeWriter;

public class Condition extends Instruction 
{
	Expression left;
	Instruction right;
	
	public Condition(SyntaxTree a1, SyntaxTree a2)
	{
		super(a1, a2);
		System.out.println(a1.getClass());
		left = (Expression) a1;
		right = (Instruction) a2;
	}
	
	public String toString()
	{
		return "If"+super.toString();
	}
	
	public String toDotString()
	{
		return "If";
	}
	
	public void toJava(CodeWriter w)
	{
		w.writeLine("if (" + left.toJava());
		w.openBlock();
		right.toJava(w);
		w.closeBlock();
	}
}
