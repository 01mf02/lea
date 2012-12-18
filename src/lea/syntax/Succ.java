package lea.syntax;

import lea.generator.CodeWriter;

public class Succ extends Instruction 
{
	Instruction succ_left, succ_right;
	
	public Succ(Instruction a1, Instruction a2)
	{
		super(a1, a2);
		succ_left = a1;
		succ_right = a2;
	}
	
	public String toString()
	{
		return "Succ"+super.toString();
	}
	
	public void toJava(CodeWriter cw)
	{
		succ_left.toJava(cw);
		succ_right.toJava(cw);
	}
	
	public String toDotString()
	{
		return "Succ";
	}
}
