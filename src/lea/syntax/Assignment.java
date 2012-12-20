package lea.syntax;

import lea.generator.CodeWriter;

public class Assignment extends Instruction 
{
	Expression assignment_left, assignment_right;
	
	public Assignment(Expression a1, Expression a2)
	{
		super(a1, a2);
		assignment_left = a1;
		assignment_right = a2;
	}
	
	public String toString()
	{
		return "Assign"+super.toString();
	}
	
	public void toJava(CodeWriter w)
	{
		if (assignment_right != null)
			w.writeLine(assignment_left.getType() + " " + assignment_left.toJava() + " = " + assignment_right.toJava() + ";");
		else
			w.writeLine(assignment_left.getType() + " " + assignment_left.toJava() + ";");
	}
	
	public String toDotString()
	{
		return "Assign";
	}
}
