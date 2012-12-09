package lea.syntax;

public class Assignment extends Instruction 
{
	public Assignment(SyntaxTree a1, SyntaxTree a2)
	{
		super(a1, a2);
	}
	
	public String toString()
	{
		return "Assign"+super.toString();
	}
}
