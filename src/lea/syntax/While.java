package lea.syntax;

import lea.generator.CodeWriter;

public class While extends Instruction 
{
	Expression while_condition;
	Instruction while_instruction;
	
	public While(Expression a1, Instruction a2)
	{
		super(a1, a2);
		while_condition = a1;
		while_instruction = a2;
	}
	
	public String toString()
	{
		return "While"+super.toString();
	}
	
	public String toDotString()
	{
		return "While";
	}
	
	public void toJava(CodeWriter w)
	{
		w.writeLine("while (" + while_condition.toJava() + ")");
		w.openBlock();
		while_instruction.toJava(w);
		w.closeBlock();
	}
}
